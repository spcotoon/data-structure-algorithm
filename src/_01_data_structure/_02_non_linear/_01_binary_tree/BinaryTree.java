package _01_data_structure._02_non_linear._01_binary_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {

    private T data;
    private BinaryTree<T> leftSubTree;
    private BinaryTree<T> rightSubTree;


    public BinaryTree(T data) {
        this.data = data;
        this.leftSubTree = null;
        this.rightSubTree = null;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinaryTree<T> getLeftSubTree() {
        return this.leftSubTree;
    }

    public BinaryTree<T> getRightSubTree() {
        return this.rightSubTree;
    }

    public void setLeftSubTree(BinaryTree<T> tree) {
        this.leftSubTree = tree;
    }

    public void setRightSubTree(BinaryTree<T> tree) {
        this.rightSubTree = tree;
    }

    // ---전위 순회
    public List<T> preOrderTraversal() {
        List<T> result = new ArrayList<>();
        preOrderTraversal(this, result);
        return result;
    }

    private void preOrderTraversal(BinaryTree<T> tree, List<T> result) {
        if(tree == null) return;

        result.add(tree.getData());
        preOrderTraversal(tree.getLeftSubTree(), result);
        preOrderTraversal(tree.getRightSubTree(), result);
    }

    // --- 중위 순회 ---
    public List<T> inOrderTraversal() {
        List<T> result = new ArrayList<>();
        inOrderTraversal(this, result);
        return result;
    }

    private void inOrderTraversal(BinaryTree<T> tree, List<T> result) {
        if (tree == null) return;

        inOrderTraversal(tree.getLeftSubTree(), result);
        result.add(tree.getData());
        inOrderTraversal(tree.getRightSubTree(), result);
    }

    // --- 후위 순회 ---
    public List<T> postOrderTraversal() {
        List<T> result = new ArrayList<>();
        postOrderTraversal(this, result);
        return result;
    }

    private void postOrderTraversal(BinaryTree<T> tree, List<T> result) {
        if (tree == null) return;

        postOrderTraversal(tree.getLeftSubTree(), result);
        postOrderTraversal(tree.getRightSubTree(), result);
        result.add(tree.getData());
    }
}
