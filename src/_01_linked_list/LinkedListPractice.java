package _01_linked_list;

class Node {

    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getNext() {
        return next;
    }

    public int getData() {
        return data;
    }
}

class LinkedListSample {
    private Node head;
    private int count;

    public LinkedListSample() {
        this.head = null;
        this.count = 0;
    }

    public void insertAt(int index, int data) {
        if (index > this.count || index < 0) {
            throw new RuntimeException("범위를 넘어감.");
        }

        Node newNode = new Node(data);

        if (index == 0) {
            newNode.setNext(head);
            this.head = newNode;
        } else {
            Node currentNode = this.head;

            for (int i = 0; i < index -1; i++) {
                currentNode = currentNode.getNext();
            }
            newNode.setNext(currentNode.getNext());
            currentNode.setNext(newNode);
        }
        this.count++;
    }

    public void printAll() {
        Node currentNode = this.head;
        StringBuilder text = new StringBuilder("[");

        while (currentNode != null) {
            text.append(currentNode.getData());
            currentNode = currentNode.getNext();

            if (currentNode != null) {
                text.append(", ");
            }
        }

        text.append("]");
        System.out.println(text);
    }

    public void clear() {
        this.head = null;
        this.count = 0;
    }

    public void insertLast(int data) {
        this.insertAt(this.count, data);
    }

    public Node deleteAt(int index) {
        if (index >= this.count || index < 0) {
            throw new RuntimeException("제거할수 없음.");
        }

        Node currentNode = this.head;

        if (index == 0) {
            Node deletedNode = this.head;
            this.head = this.head.getNext();
            this.count--;
            return deletedNode;
        } else {
            for (int i = 0; i < index - 1; i++) {
                currentNode = currentNode.getNext();
            }

            Node deletedNode = currentNode.getNext();
            currentNode.setNext(currentNode.getNext().getNext());
            this.count--;
            return deletedNode;
        }
    }

    public Node deleteLast() {
        return this.deleteAt(this.count - 1);
    }

    public Node getNodeAt(int index) {
        if (index > this.count || index < 0) {
            throw new RuntimeException("범위를 넘어감.");
        }

        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.getNext();
        }

        return currentNode;
    }
}

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
