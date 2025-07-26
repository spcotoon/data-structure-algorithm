package _01_data_structure._02_non_linear._01_binary_tree;

public class BinaryTreePractice {
    public static void main(String[] args) {
        BinaryTree<Integer> tree1 = new BinaryTree<>(1);
        BinaryTree<Integer> tree2 = new BinaryTree<>(2);
        BinaryTree<Integer> tree3 = new BinaryTree<>(3);
        BinaryTree<Integer> tree4 = new BinaryTree<>(4);
        BinaryTree<Integer> tree5 = new BinaryTree<>(5);
        BinaryTree<Integer> tree6 = new BinaryTree<>(6);
        BinaryTree<Integer> tree7 = new BinaryTree<>(7);
        BinaryTree<String> strTree1 = new BinaryTree<>("트리1");
        BinaryTree<String> strTree2 = new BinaryTree<>("트리2");
        BinaryTree<String> strTree3 = new BinaryTree<>("트리3");

        class Person {
            private String name;
            private int age;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
            }

            @Override
            public String toString() {
                return "|" + name + ", " + age +"살" + "|";
            }
        }

        BinaryTree<Person> person1 = new BinaryTree<>(new Person("사람1", 10));
        BinaryTree<Person> person2 = new BinaryTree<>(new Person("사람2", 15));
        BinaryTree<Person> person3 = new BinaryTree<>(new Person("사람3", 20));


        /*
                1
            2       3
          4  5    6  7
        8
         */

        tree1.setLeftSubTree(tree2);
        tree1.setRightSubTree(tree3);
        tree2.setLeftSubTree(tree4);
        tree2.setRightSubTree(tree5);
        tree3.setLeftSubTree(tree6);
        tree3.setRightSubTree(tree7);

        strTree1.setLeftSubTree(strTree2);
        strTree1.setRightSubTree(strTree3);

        person1.setLeftSubTree(person2);
        person1.setRightSubTree(person3);

        System.out.println("루트노드의 오른쪽 자식노드: " + tree1.getRightSubTree().getData());
        System.out.println("루트노드의 오른쪽 자식노드의 왼쪽 자식노드: " + tree1.getRightSubTree().getLeftSubTree().getData());

        System.out.println("전위 순회");
        System.out.println(tree1.preOrderTraversal());

        System.out.println("중위 순회");
        System.out.println(tree1.inOrderTraversal());

        System.out.println("후위 순회");
        System.out.println(tree1.postOrderTraversal());

        System.out.println(strTree1.preOrderTraversal());

        System.out.println(person1.inOrderTraversal());
    }
}
