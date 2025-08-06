package _01_data_structure._02_non_linear._04_red_black_tree;

public class RedBlackTreePractice {
    public static void main(String[] args) {

        RedBlackTree<Integer> rbTree = new RedBlackTree<>();
        rbTree.insert(17);
        rbTree.insert(9);
        rbTree.insert(19);
        rbTree.insert(75);
        rbTree.insert(85);

        rbTree.remove(19);
        rbTree.remove(75);
        rbTree.remove(85);
        System.out.println(rbTree.root);
        System.out.println(rbTree.root.inOrderTraversal());
    }
}
