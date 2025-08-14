package _01_data_structure._02_non_linear._05_heap;

public class PriorityQueuePractice {
    public static void main(String[] args) {

        class Monster implements Comparable<Monster> {
            String name;
            int health;
            int priority;

            public Monster(String name, int health) {
                this.name = name;
                this.health = health;
                this.priority = health;
            }

            @Override
            public int compareTo(Monster o) {
                return Integer.compare(this.priority, o.priority);
            }

            @Override
            public String toString() {
                return "Monster{" +
                        "name='" + name + '\'' +
                        ", health=" + health +
                        '}';
            }
        }

        PriorityQueue<Monster> priorityQueue = new PriorityQueue<Monster>();

        priorityQueue.enqueue(new Monster("슬라임", 100));
        priorityQueue.enqueue(new Monster("슬라임", 87));
        priorityQueue.enqueue(new Monster("슬라임", 21));
        priorityQueue.enqueue(new Monster("슬라임", 47));
        priorityQueue.enqueue(new Monster("슬라임", 200));


        System.out.println(priorityQueue.dequeue().getData());
        System.out.println(priorityQueue.dequeue().getData());
        System.out.println(priorityQueue.dequeue().getData());
        System.out.println(priorityQueue.dequeue().getData());
        System.out.println(priorityQueue.dequeue().getData());
    }
}
