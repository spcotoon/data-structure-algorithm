package _01_data_structure._02_non_linear._05_heap;

public class Heap<T extends Comparable<T>>{

    private BinaryTree<T> root;
    private BinaryTree<T> lastInsertedNode;

    public Heap() {
        this.root = null;
        this.lastInsertedNode = null;
    }

    public BinaryTree<T> getRoot() {
        return root;
    }

    public void insert(T data) {
        if (this.lastInsertedNode == null) {
            this.lastInsertedNode = new BinaryTree<>(data);
            this.root = this.lastInsertedNode;
            return;
        }

        BinaryTree<T> insertingParent = this.getInsertingParent();
        BinaryTree<T> newNode = new BinaryTree<>(data);

        if (insertingParent.getLeftSubTree() == null) {
            insertingParent.setLeftSubTree(newNode);
        } else if (insertingParent.getRightSubTree() == null) {
            insertingParent.setRightSubTree(newNode);
        }
        newNode.setParent(insertingParent);
        this.lastInsertedNode = newNode;

        while (newNode.getParent() != null) {
            if (this.isBigPriority(newNode.getData(), newNode.getParent().getData())) {
                T tempData = newNode.getParent().getData();
                newNode.getParent().setData(newNode.getData());
                newNode.setData(tempData);
                newNode = newNode.getParent();
            } else {
                break;
            }
        }
    }

    public BinaryTree<T> remove() {
        BinaryTree<T> deletedNode = null;

        if (this.lastInsertedNode == this.root) {
            deletedNode = this.root;
            this.root = null;
            this.lastInsertedNode = null;
            return deletedNode;
        }

        BinaryTree<T> prevLastInsertedNode = getNewLastInsertedNode();
        T tempData = this.root.getData();
        this.root.setData(this.lastInsertedNode.getData());
        this.lastInsertedNode.setData(tempData);

        if (this.lastInsertedNode.getParent().getLeftSubTree() == this.lastInsertedNode) {
            this.lastInsertedNode.getParent().setLeftSubTree(null);
        } else {
            this.lastInsertedNode.getParent().setRightSubTree(null);
        }

        this.lastInsertedNode.setParent(null);
        deletedNode = this.lastInsertedNode;
        this.lastInsertedNode = prevLastInsertedNode;

        BinaryTree<T> current = this.root;
        do {
            BinaryTree<T> higherChild = this.getHigherPriorityChild(current.getLeftSubTree(), current.getRightSubTree());
            if (higherChild == null) {
                break;
            } else if (!this.isBigPriority(current.getData(), higherChild.getData())) {
                T temp = current.getData();
                current.setData(higherChild.getData());
                higherChild.setData(temp);
                current = higherChild;
            } else {
                break;
            }
        } while (current.getLeftSubTree() != null || current.getRightSubTree() != null);

        return deletedNode;
    }

    private BinaryTree<T> getHigherPriorityChild(BinaryTree<T> left, BinaryTree<T> right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        } else if (this.isBigPriority(left.getData(), right.getData())) {
            return left;
        } else {
            return right;
        }
    }

    private BinaryTree<T> getNewLastInsertedNode() {
        BinaryTree<T> prevLastInsertedNode = null;

        if (this.lastInsertedNode == this.lastInsertedNode.getParent().getLeftSubTree()) {
            BinaryTree<T> current = this.lastInsertedNode;
            BinaryTree<T> firstLeftSibling = null;

            while (current.getParent().getParent() != null) {
                current = current.getParent();
                firstLeftSibling = this.getLeftSibling(current);
                if (firstLeftSibling != null) {
                    break;
                }
            }

            if (firstLeftSibling != null) {
                while (firstLeftSibling.getRightSubTree() != null) {
                    firstLeftSibling = firstLeftSibling.getRightSubTree();
                }
                prevLastInsertedNode = firstLeftSibling;
            } else {
                current = this.root;
                while (current.getRightSubTree() != null) {
                    current = current.getRightSubTree();
                }
                prevLastInsertedNode = current;
            }
        } else {
            prevLastInsertedNode = this.lastInsertedNode.getParent().getLeftSubTree();
        }

        return prevLastInsertedNode;
    }

    private BinaryTree<T> getInsertingParent() {

        if (this.lastInsertedNode.getParent() == null) {
            return this.lastInsertedNode;
        } else {
            if (this.lastInsertedNode == this.lastInsertedNode.getParent().getLeftSubTree()) {
                return this.lastInsertedNode.getParent();
            } else {
                BinaryTree<T> current = this.lastInsertedNode;
                BinaryTree<T> firstRightSibling = null;

                while (current.getParent().getParent() != null) {
                    current = current.getParent();

                    firstRightSibling = getRightSibling(current);

                    if (firstRightSibling != null) {
                        break;
                    }
                }

                if (firstRightSibling != null) {
                    while (firstRightSibling.getLeftSubTree() != null) {
                        firstRightSibling = firstRightSibling.getLeftSubTree();
                    }
                    return firstRightSibling;
                } else {
                    current = this.root;
                    while (current.getLeftSubTree() != null) {
                        current = current.getLeftSubTree();
                    }
                    return current;
                }
            }
        }
    }

    private boolean isBigPriority(T first, T second) {
        return first.compareTo(second) < 0;
    }

    private BinaryTree<T> getRightSibling(BinaryTree<T> node) {
        if (node.getParent().getRightSubTree() != node) {
            return node.getParent().getRightSubTree();
        }
        return null;
    }

    private BinaryTree<T> getLeftSibling(BinaryTree<T> node) {
        if (node.getParent().getLeftSubTree() != node) {
            return node.getParent().getLeftSubTree();
        }
        return null;
    }

}
