package _01_data_structure._02_non_linear._04_red_black_tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<T> {

    enum Color{
        RED, BLACK
    }

    private Color color;
    private T data;
    private BinaryTree<T> leftSubTree;
    private BinaryTree<T> rightSubTree;
    private BinaryTree<T> parentTree;

    public BinaryTree(T data) {
        this.data = data;
        this.leftSubTree = null;
        this.rightSubTree = null;
        this.parentTree = null;

        this.color = Color.RED;
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
        if (tree == null || tree instanceof NilNode) return;

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
        if (tree == null || tree instanceof NilNode<T>) return;

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
        if (tree == null || tree instanceof NilNode) return;

        postOrderTraversal(tree.getLeftSubTree(), result);
        postOrderTraversal(tree.getRightSubTree(), result);
        result.add(tree.getData());
    }

    public BinaryTree<T> removeLeftSubTree() {
        BinaryTree<T> deletingNode = this.getLeftSubTree();
        this.setLeftSubTree(null);
        return deletingNode;
    }

    public BinaryTree<T> removeRightSubTree() {
        BinaryTree<T> deletingNode = this.getRightSubTree();
        this.setRightSubTree(null);
        return deletingNode;
    }

    public BinaryTree<T> getParent() {
        return this.parentTree;
    }

    public void setParent(BinaryTree<T> tree) {
        this.parentTree = tree;
    }

    public boolean isRed() {
        return this.color == Color.RED;
    }

    public boolean isBlack() {
        return this.color == Color.BLACK;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return this.color;
    }
}
