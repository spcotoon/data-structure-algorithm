package _01_data_structure._02_non_linear._03_avl_tree;

import _01_data_structure._02_non_linear._02_binary_search_tree.BinarySearchTree;

import java.util.List;

public class AVLTreePractice {
    public static void main(String[] args) {

        AVLTree<Integer> avlTree = new AVLTree<>();
        System.out.println("=== avl insert ===");
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        System.out.println(avlTree.root.preOrderTraversal());
        System.out.println("=== remove ===");
        avlTree.remove(6);
        System.out.println(avlTree.root.preOrderTraversal());
        System.out.println("=== binary tree insert ===");
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        binarySearchTree.insert(1);
        binarySearchTree.insert(2);
        binarySearchTree.insert(3);
        binarySearchTree.insert(4);
        binarySearchTree.insert(5);
        binarySearchTree.insert(6);
        binarySearchTree.insert(7);
        System.out.println(binarySearchTree.root.preOrderTraversal());
        System.out.println("=== remove ===");
        binarySearchTree.remove(6);
        System.out.println(binarySearchTree.root.preOrderTraversal());
    }
}
