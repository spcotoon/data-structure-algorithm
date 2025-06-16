package _01_data_structure._02_stack;

import _01_data_structure._01_linked_list.LinkedListSample;
import _01_data_structure._01_linked_list.Node;

public class StackSample {

    private final LinkedListSample list;

    public StackSample() {
        this.list = new LinkedListSample();
    }

    public void push(int data) {
        this.list.insertAt(0, data);
    }

    public Node pop() {
        try {
            return this.list.deleteAt(0);
        } catch (Exception e) {
            return null;
        }
    }

    public Node peek() {
        return this.list.getNodeAt(0);
    }

    public boolean isEmpty() {
        return (this.list.getCount() == 0);
    }
}
