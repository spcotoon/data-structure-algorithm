package _01_data_structure._02_non_linear._05_heap;

import java.util.ArrayList;
import java.util.List;

public class HeapSort {
    public static void main(String[] args) {
        class MyData implements Comparable<MyData>{
            int data;
            int priority;

            public MyData(int data) {
                this.data = data;
                this.priority = data;
            }

            @Override
            public int compareTo(MyData o) {
                return Integer.compare(this.priority, o.priority);
            }
        }


        Heap<MyData> heap = new Heap<>();

        heap.insert(new MyData(2));
        heap.insert(new MyData(8));
        heap.insert(new MyData(5));
        heap.insert(new MyData(6));
        heap.insert(new MyData(10));
        heap.insert(new MyData(4));
        heap.insert(new MyData(3));
        heap.insert(new MyData(7));
        heap.insert(new MyData(9));
        heap.insert(new MyData(1));

        List<BinaryTree<MyData>> myData = new ArrayList<>();

        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());
        myData.add(heap.remove());

        for (BinaryTree<MyData> node : myData) {
            System.out.println(node.getData().data);
        }
    }
}
