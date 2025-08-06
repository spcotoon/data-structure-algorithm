package _01_data_structure._02_non_linear._03_avl_tree;

import _01_data_structure._02_non_linear._01_binary_tree.BinaryTree;


public class BinarySearchTree<T extends Comparable<T>>{

    BinaryTree<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(BinaryTree<T> rootNode) {
        this.root = rootNode;
    }

    public void insert(T data) {
        //처음 삽입하는 경우
        if (this.root == null) {
            this.root = new BinaryTree<>(data);
            return;
        }

        if (!(data instanceof Comparable)) {
            throw new IllegalArgumentException("BinarySearchTree requires data to be Comparable");
        }

        //이진트리에 하나 이상 데이터가 있는 경우
        insertNode(this.root, data);
    }

    private void insertNode(BinaryTree<T> currentNode, T data) {

        int comparison = data.compareTo(currentNode.getData());

        // 새 데이터가 현재 노드 데이터보다 작으면 왼쪽
        if (comparison < 0) {
            if (currentNode.getLeftSubTree() == null) {
                currentNode.setLeftSubTree(new BinaryTree<>(data));
            } else {
                insertNode(currentNode.getLeftSubTree(), data);
            }
        } else if (comparison > 0) {
            //새 데이터가 현재 노드보다 크면 오른쪽
            if (currentNode.getRightSubTree() == null) {
                currentNode.setRightSubTree(new BinaryTree<>(data));
            } else {
                insertNode(currentNode.getRightSubTree(), data);
            }
        } else {
            // comparison == 0 인경우, 즉 데이터가 이미 존재함

            System.out.println("Data " + data + " already exists.");
        }
    }

    public BinaryTree<T> search(T targetData) {
        return searchNode(this.root, targetData);
    }

    private BinaryTree<T> searchNode(BinaryTree<T> currentNode, T targetData) {
        //현재 노드가 null (트리가 비어있거나, 찾는 값 없음) null 반환
        if (currentNode == null) {
            return null;
        }

        int comparison = targetData.compareTo(currentNode.getData());

        if (comparison == 0) {
            //찾는 값 찾았음
            return currentNode;
        } else if (comparison < 0) {
            //targetData 가 작으면 왼쪽 서브트리로
            return searchNode(currentNode.getLeftSubTree(), targetData);
        } else {
            // comarison > 0, 즉 targetData가 더 크면 오른쪽 서브트리로

            return searchNode(currentNode.getRightSubTree(), targetData);
        }
    }

    public void remove(T targetData) {
        //만일 삭제하려는게 루트노드일 경우, 루트노드는 부모노드가 없으므로 가짜부모노드를 만들어 처리함. 가짜부모노드는 실제 데이터가 아니므로 데이터는 null 로 의미 없는 값 넣었음.
        BinaryTree<T> fakeParentRootNode = new BinaryTree<>(null);
        BinaryTree<T> parentNode = fakeParentRootNode;
        BinaryTree<T> currentNode = this.root;
        BinaryTree<T> deletingNode = null;

        fakeParentRootNode.setLeftSubTree(this.root);

        while (currentNode != null && !currentNode.getData().equals(targetData)) {
            parentNode = currentNode;

            if (targetData.compareTo(currentNode.getData()) < 0) {

                //타겟 데이터가 더 작으면 왼쪽으로
                currentNode = currentNode.getLeftSubTree();
            } else {
                currentNode = currentNode.getRightSubTree();
            }
        }

        if (currentNode == null) {
            System.out.println("데이터 " + targetData + "를 찾을 수 없습니다.");
            return;
        }

        deletingNode = currentNode;

        // 제거할 노드가 자식이 없는 경우
        if (deletingNode.getLeftSubTree() == null && deletingNode.getRightSubTree() == null) {
            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.removeLeftSubTree();
            } else {
                parentNode.removeRightSubTree();
            }
        } else if (deletingNode.getLeftSubTree() == null || deletingNode.getRightSubTree() == null) {

            //제거할 노드가 자식이 하나 있는 경우

            BinaryTree<T> deletingNodeChild;

            if (deletingNode.getLeftSubTree() != null) {
                deletingNodeChild = deletingNode.getLeftSubTree();
            } else {
                deletingNodeChild = deletingNode.getRightSubTree();
            }

            if (parentNode.getLeftSubTree() == deletingNode) {
                parentNode.setLeftSubTree(deletingNodeChild);
            } else {
                parentNode.setRightSubTree(deletingNodeChild);
            }
        } else {
            //자식 노드가 두개 있는 경우

            BinaryTree<T> replacingNode = deletingNode.getLeftSubTree();
            BinaryTree<T> replacingNodeParent = deletingNode;

            while (replacingNode.getRightSubTree() != null) {
                replacingNodeParent = replacingNode;
                replacingNode = replacingNode.getRightSubTree();
            }

            T deletingNodeData = deletingNode.getData();
            deletingNode.setData(replacingNode.getData());

            if (replacingNodeParent.getLeftSubTree() == replacingNode) {
                replacingNodeParent.setLeftSubTree(replacingNode.getLeftSubTree());
            } else {
                replacingNodeParent.setRightSubTree(replacingNode.getLeftSubTree());
            }

            deletingNode = replacingNode;
            deletingNode.setData(deletingNodeData);

            if (fakeParentRootNode.getLeftSubTree() != this.root) {
                this.root = fakeParentRootNode.getLeftSubTree();
            }

        }
    }
}