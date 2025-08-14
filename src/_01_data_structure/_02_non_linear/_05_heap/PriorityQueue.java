package _01_data_structure._02_non_linear._05_heap;

public class PriorityQueue<T extends Comparable<T>> {

    private Heap<T> heap;

    public PriorityQueue() {
        this.heap = new Heap<>();
    }

    public void enqueue(T data) {
        this.heap.insert(data);
    }

    public BinaryTree<T> dequeue() {
        return this.heap.remove();
    }

}
