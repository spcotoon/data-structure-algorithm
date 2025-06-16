package _01_data_structure._01_linked_list;

public class Node {
    private int data;
    private Node next;

    //DoublyLinkedList 에서 사용
    private Node prev;

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
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
