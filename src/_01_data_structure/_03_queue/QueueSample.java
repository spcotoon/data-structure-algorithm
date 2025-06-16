package _01_data_structure._03_queue;

import _01_data_structure._01_linked_list.DoublyLinkedListSample;
import _01_data_structure._01_linked_list.Node;

public class QueueSample {

    private final DoublyLinkedListSample list;

    public QueueSample() {
        this.list = new DoublyLinkedListSample();
    }

    public void enqueue(int data) {
        this.list.insertAt(0, data);
    }

    public Node dequeue() {
        try {
            return this.list.deleteLast();
        } catch (Exception e) {
            return null;
        }
    }

    public Node front() {
        return this.list.getTail();
    }

    public boolean isEmpty() {
        return (this.list.getCount() == 0);
    }
}
