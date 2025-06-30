package _01_data_structure._01_linear._03_queue;

public class QueuePractice {
    public static void main(String[] args) {
        QueueSample queue = new QueueSample();

        System.out.println("===enqueue()===");
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);

        System.out.println(queue.front().getData());

        System.out.println("===dequeue()===");
        System.out.println(queue.dequeue().getData());
        System.out.println(queue.dequeue().getData());
        System.out.println(queue.dequeue().getData());
        System.out.println(queue.dequeue());

        System.out.println("isEmpty: " + queue.isEmpty());
    }
}
