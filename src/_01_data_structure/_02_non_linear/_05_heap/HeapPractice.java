package _01_data_structure._02_non_linear._05_heap;

import java.util.List;

public class HeapPractice {
    public static void main(String[] args) {

        class Person implements Comparable<Person>{
            String name;
            int age;
            int priority;

            public Person(String name, int age) {
                this.name = name;
                this.age = age;
                this.priority = age;
            }

            @Override
            public int compareTo(Person o) {
                return Integer.compare(this.priority, o.priority);
            }

            @Override
            public String toString() {
                return name + "(" + age + ")";
            }
        }

        Heap<Person> heap = new Heap<>();
        heap.insert(new Person("a", 20));
        heap.insert(new Person("b", 10));
        heap.insert(new Person("c", 31));

        System.out.println(heap.getRoot().getData());
    }
}
