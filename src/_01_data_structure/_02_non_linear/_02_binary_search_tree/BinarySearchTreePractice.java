package _01_data_structure._02_non_linear._02_binary_search_tree;

public class BinarySearchTreePractice {
    public static void main(String[] args) {

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insert(18);
        binarySearchTree.insert(15);
        binarySearchTree.insert(10);
        binarySearchTree.insert(6);
        binarySearchTree.insert(3);
        binarySearchTree.insert(8);
        binarySearchTree.insert(12);
        binarySearchTree.insert(11);
        binarySearchTree.insert(31);
        binarySearchTree.insert(27);
        binarySearchTree.insert(24);
        binarySearchTree.insert(20);
        binarySearchTree.insert(33);
        binarySearchTree.insert(35);
        binarySearchTree.insert(37);

        System.out.println(binarySearchTree.root.inOrderTraversal());

        System.out.println("=== search 6 ===");
        System.out.println(binarySearchTree.search(6).getData());

        System.out.println("=== search 1 ===");
        System.out.println(binarySearchTree.search(1));

    }
}
