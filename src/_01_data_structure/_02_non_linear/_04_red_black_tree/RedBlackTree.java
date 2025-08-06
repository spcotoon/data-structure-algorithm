package _01_data_structure._02_non_linear._04_red_black_tree;

public class RedBlackTree<T extends Comparable<T>> {

    public BinaryTree<T> root;

    public RedBlackTree() {
        // 시작부터 NilNode로 초기화
        this.root = NilNode.getInstance();
    }

    public RedBlackTree(BinaryTree<T> rootNode) {
        this.root = rootNode != null ? rootNode : NilNode.getInstance();
    }

    // --------------------- 검색 ---------------------
    public BinaryTree<T> search(T targetData) {
        return searchNode(this.root, targetData);
    }

    private BinaryTree<T> searchNode(BinaryTree<T> currentNode, T targetData) {
        if (currentNode == null || currentNode instanceof NilNode) return null;

        int comparison = targetData.compareTo(currentNode.getData());

        if (comparison == 0) return currentNode;
        else if (comparison < 0)
            return searchNode(currentNode.getLeftSubTree(), targetData);
        else
            return searchNode(currentNode.getRightSubTree(), targetData);
    }

    // --------------------- 회전 ---------------------
    private void rotateLeft(BinaryTree<T> node) {
        BinaryTree<T> parent = node.getParent();
        BinaryTree<T> rightChild = node.getRightSubTree();

        node.setRightSubTree(rightChild.getLeftSubTree());
        if (!(rightChild.getLeftSubTree() instanceof NilNode)) {
            rightChild.getLeftSubTree().setParent(node);
        }

        rightChild.setLeftSubTree(node);
        node.setParent(rightChild);

        this.replaceParentChild(parent, node, rightChild);
    }

    private void rotateRight(BinaryTree<T> node) {
        BinaryTree<T> parent = node.getParent();
        BinaryTree<T> leftChild = node.getLeftSubTree();

        node.setLeftSubTree(leftChild.getRightSubTree());
        if (!(leftChild.getRightSubTree() instanceof NilNode)) {
            leftChild.getRightSubTree().setParent(node);
        }

        leftChild.setRightSubTree(node);
        node.setParent(leftChild);

        this.replaceParentChild(parent, node, leftChild);
    }

    private void replaceParentChild(BinaryTree<T> parent, BinaryTree<T> oldChild, BinaryTree<T> newChild) {
        BinaryTree<T> childToSet = (newChild != null) ? newChild : NilNode.getInstance();

        if (parent == null) {
            this.root = childToSet;
        } else if (parent.getLeftSubTree() == oldChild) {
            parent.setLeftSubTree(childToSet);
        } else if (parent.getRightSubTree() == oldChild) {
            parent.setRightSubTree(childToSet);
        }

        childToSet.setParent(parent);
    }

    // --------------------- 삽입 ---------------------
    public void insert(T data) {
        BinaryTree<T> current = this.root;
        BinaryTree<T> parent = null;

        while (!(current instanceof NilNode)) {
            parent = current;
            if (data.compareTo(current.getData()) < 0) {
                current = current.getLeftSubTree();
            } else if (data.compareTo(current.getData()) > 0) {
                current = current.getRightSubTree();
            } else {
                return; // 중복 무시
            }
        }

        BinaryTree<T> newNode = new BinaryTree<>(data);
        newNode.setLeftSubTree(NilNode.getInstance());
        newNode.setRightSubTree(NilNode.getInstance());

        if (parent == null || parent instanceof NilNode) {
            this.root = newNode;
        } else if (parent.getData().compareTo(data) > 0) {
            parent.setLeftSubTree(newNode);
        } else {
            parent.setRightSubTree(newNode);
        }

        newNode.setParent(parent);
        this.rebalanceAfterInsertion(newNode);
    }

    // --------------------- 삭제 ---------------------
    public void remove(T data) {
        BinaryTree<T> currentNode = this.root;

        while (!(currentNode instanceof NilNode) && !currentNode.getData().equals(data)) {
            if (data.compareTo(currentNode.getData()) < 0) {
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        if (currentNode instanceof NilNode) return;

        BinaryTree<T> replaceNode;
        BinaryTree.Color deletedNodeColor;

        if (currentNode.getLeftSubTree() instanceof NilNode || currentNode.getRightSubTree() instanceof NilNode) {
            replaceNode = this.removeWithZeroOrOneChild(currentNode);
            deletedNodeColor = currentNode.getColor();
        } else {
            BinaryTree<T> successor = this.getBiggestNode(currentNode.getLeftSubTree());
            currentNode.setData(successor.getData());
            replaceNode = this.removeWithZeroOrOneChild(successor);
            deletedNodeColor = successor.getColor();
        }

        if (deletedNodeColor == BinaryTree.Color.BLACK) {
            this.rebalanceAfterDeletion(replaceNode);
            if (replaceNode instanceof NilNode) {
                this.replaceParentChild(replaceNode.getParent(), replaceNode, NilNode.getInstance());
            }
        }
    }

    // --------------------- 삭제 후 재균형 ---------------------
    private void rebalanceAfterDeletion(BinaryTree<T> node) {
        if (node == this.root) {
            if (!(node instanceof NilNode)) node.setColor(BinaryTree.Color.BLACK);
            return;
        }

        BinaryTree<T> sibling = this.getSibling(node);
        if (sibling == null || sibling instanceof NilNode) return;

        if (sibling.isRed()) {
            this.handleRedSibling(node, sibling);
            sibling = this.getSibling(node);
            if (sibling == null || sibling instanceof NilNode) return;
        }

        if (this.isBlack(sibling)) {
            if (this.isBlack(sibling.getLeftSubTree()) && this.isBlack(sibling.getRightSubTree())) {
                if (node.getParent().isRed()) {
                    sibling.setColor(BinaryTree.Color.RED);
                    node.getParent().setColor(BinaryTree.Color.BLACK);
                } else {
                    sibling.setColor(BinaryTree.Color.RED);
                    this.rebalanceAfterDeletion(node.getParent());
                }
            } else {
                this.handleBlackSiblingWithAtLeastOneRedChild(node, sibling);
            }
        }
    }

    private void handleBlackSiblingWithAtLeastOneRedChild(BinaryTree<T> node, BinaryTree<T> sibling) {
        boolean nodeIsLeftChild = (node.getParent().getLeftSubTree() == node);

        if (nodeIsLeftChild && this.isBlack(sibling.getRightSubTree())) {
            sibling.getLeftSubTree().setColor(BinaryTree.Color.BLACK);
            sibling.setColor(BinaryTree.Color.RED);
            this.rotateRight(sibling);
            sibling = node.getParent().getRightSubTree();
        } else if (!nodeIsLeftChild && this.isBlack(sibling.getLeftSubTree())) {
            sibling.getRightSubTree().setColor(BinaryTree.Color.BLACK);
            sibling.setColor(BinaryTree.Color.RED);
            this.rotateLeft(sibling);
            sibling = node.getParent().getLeftSubTree();
        }

        sibling.setColor(node.getParent().getColor());
        node.getParent().setColor(BinaryTree.Color.BLACK);

        if (nodeIsLeftChild) {
            sibling.getRightSubTree().setColor(BinaryTree.Color.BLACK);
            this.rotateLeft(node.getParent());
        } else {
            sibling.getLeftSubTree().setColor(BinaryTree.Color.BLACK);
            this.rotateRight(node.getParent());
        }
    }

    private void handleRedSibling(BinaryTree<T> node, BinaryTree<T> sibling) {
        sibling.setColor(BinaryTree.Color.BLACK);
        node.getParent().setColor(BinaryTree.Color.RED);

        if (node.getParent().getLeftSubTree() == node) {
            this.rotateLeft(node.getParent());
        } else {
            this.rotateRight(node.getParent());
        }
    }

    // --------------------- 유틸 ---------------------
    private BinaryTree<T> getSibling(BinaryTree<T> node) {
        BinaryTree<T> parent = node.getParent();
        if (parent == null) return null;

        if (node == parent.getLeftSubTree()) {
            return parent.getRightSubTree();
        } else {
            return parent.getLeftSubTree();
        }
    }

    private BinaryTree<T> getBiggestNode(BinaryTree<T> node) {
        while (!(node.getRightSubTree() instanceof NilNode)) {
            node = node.getRightSubTree();
        }
        return node;
    }

    private BinaryTree<T> removeWithZeroOrOneChild(BinaryTree<T> node) {
        if (!(node.getLeftSubTree() instanceof NilNode)) {
            this.replaceParentChild(node.getParent(), node, node.getLeftSubTree());
            return node.getLeftSubTree();
        } else if (!(node.getRightSubTree() instanceof NilNode)) {
            this.replaceParentChild(node.getParent(), node, node.getRightSubTree());
            return node.getRightSubTree();
        } else {
            BinaryTree<T> newChild = NilNode.getInstance();
            this.replaceParentChild(node.getParent(), node, newChild);
            return newChild;
        }
    }

    private void rebalanceAfterInsertion(BinaryTree<T> node) {
        BinaryTree<T> parent = node.getParent();

        if (parent == null) {
            node.setColor(BinaryTree.Color.BLACK);
            return;
        }

        if (parent.isBlack()) return;

        BinaryTree<T> uncle = getUncle(parent);
        BinaryTree<T> grandParent = parent.getParent();

        if (uncle != null && uncle.isRed()) {
            parent.setColor(BinaryTree.Color.BLACK);
            uncle.setColor(BinaryTree.Color.BLACK);
            grandParent.setColor(BinaryTree.Color.RED);
            this.rebalanceAfterInsertion(grandParent);
        } else if (this.isBlack(uncle)) {
            if (grandParent.getRightSubTree() == parent && parent.getLeftSubTree() == node) {
                this.rotateRight(parent);
                this.rotateLeft(grandParent);
                node.setColor(BinaryTree.Color.BLACK);
                grandParent.setColor(BinaryTree.Color.RED);
            } else if (grandParent.getLeftSubTree() == parent && parent.getRightSubTree() == node) {
                this.rotateLeft(parent);
                this.rotateRight(grandParent);
                node.setColor(BinaryTree.Color.BLACK);
                grandParent.setColor(BinaryTree.Color.RED);
            } else if (grandParent.getRightSubTree() == parent && parent.getRightSubTree() == node) {
                this.rotateLeft(grandParent);
                parent.setColor(BinaryTree.Color.BLACK);
                grandParent.setColor(BinaryTree.Color.RED);
            } else if (grandParent.getLeftSubTree() == parent && parent.getLeftSubTree() == node) {
                this.rotateRight(grandParent);
                parent.setColor(BinaryTree.Color.BLACK);
                grandParent.setColor(BinaryTree.Color.RED);
            }
        }
    }

    private BinaryTree<T> getUncle(BinaryTree<T> parent) {
        BinaryTree<T> grandParent = parent.getParent();
        if (grandParent == null) return null;

        if (grandParent.getLeftSubTree() == parent) {
            return grandParent.getRightSubTree();
        } else {
            return grandParent.getLeftSubTree();
        }
    }

    private boolean isBlack(BinaryTree<T> node) {
        return node == null || node.isBlack();
    }
}
