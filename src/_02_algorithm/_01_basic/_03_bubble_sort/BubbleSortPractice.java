package _02_algorithm._01_basic._03_bubble_sort;

import java.util.Arrays;

public class BubbleSortPractice {
    public static void main(String[] args) {
        int[] arr = {4, 2, 3, 1};
        System.out.println("===정렬 전===");
        System.out.println(Arrays.toString(arr));

        Bubble bubble = new Bubble();
        bubble.sort(arr);
        System.out.println("===정렬 후===");
        System.out.println(Arrays.toString(arr));
    }
}
