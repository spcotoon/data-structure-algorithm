package _01_data_structure._02_non_linear._02_binary_search_tree;

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

}