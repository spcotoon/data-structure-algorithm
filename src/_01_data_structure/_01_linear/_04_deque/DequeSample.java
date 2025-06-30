package _01_data_structure._01_linear._04_deque;

import _01_data_structure._01_linear._01_linked_list.DoublyLinkedListSample;
import _01_data_structure._01_linear._01_linked_list.Node;

public class DequeSample {

    private final DoublyLinkedListSample list;

    public DequeSample() {
        this.list = new DoublyLinkedListSample();
    }

    public void printAll() {
        this.list.printAll();
    }

    public void addFirst(int data) {
        this.list.insertAt(0, data);
    }

    public Node removeFirst() {
        return this.list.deleteAt(0);
    }

    public void addLast(int data) {
        this.list.insertAt(this.list.getCount(), data);
    }

    public Node removeLast() {
        return this.list.deleteLast();
    }

    public boolean isEmpty() {
        return (this.list.getCount() == 0);
    }
}
