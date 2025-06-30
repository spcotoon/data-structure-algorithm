package _01_data_structure._01_linear._01_linked_list;

public class LinkedListPractice {
    public static void main(String[] args) {
        // 노드 생성
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);

        node1.setNext(node2);
        node2.setNext(node3);

        // 모든 데이터 출력
        System.out.println(node1.getData());
        System.out.println(node1.getNext().getData());
        System.out.println(node1.getNext().getNext().getData());

        LinkedListSample list = new LinkedListSample();
        System.out.println("=====insertAt()=====");
        list.insertAt(0, 0);
        list.insertAt(1, 1);
        list.insertAt(2, 2);
        list.insertAt(3, 3);
        list.insertAt(4, 4);
        list.printAll();
        System.out.println("=====clear()=====");
        list.clear();
        list.printAll();
        System.out.println("=====insertLast()=====");
        list.insertLast(0);
        list.insertLast(1);
        list.insertLast(2);
        list.insertLast(3);
        list.insertLast(4);
        list.printAll();
        System.out.println("=====deleteAt()=====");
        list.deleteAt(2);
        list.printAll();
        list.deleteAt(0);
        list.printAll();
        System.out.println("=====deleteLast()=====");
        list.deleteLast();
        list.printAll();
        System.out.println("=====getNodeAt()=====");
        Node node = list.getNodeAt(1);
        System.out.println(node.getData());
    }

}
