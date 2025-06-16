package _01_data_structure._04_deque;

public class DequePractice {
    public static void main(String[] args) {

        DequeSample deque = new DequeSample();
        System.out.println("===addFirst()===");
        System.out.println("isEmpty: " + deque.isEmpty());
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addFirst(5);
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());

        System.out.println("\n===removeFirst()===");
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        deque.removeFirst();
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());

        System.out.println("\n===addLast()===");
        deque.addLast(1);
        deque.addLast(2);
        deque.addLast(3);
        deque.addLast(4);
        deque.addLast(5);
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());

        System.out.println("\n===removeLast()===");
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        deque.removeLast();
        deque.printAll();
        System.out.println("isEmpty: " + deque.isEmpty());
    }
}
