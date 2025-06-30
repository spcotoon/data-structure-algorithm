package _02_algorithm._01_basic._05_insertion_sort;

import java.util.Arrays;

public class InsertionSortPractice {
    public static void main(String[] args) {
        int[] arr = {4, 1, 5, 3, 6, 2};
        System.out.println("=== 정렬 전 ===");
        System.out.println(Arrays.toString(arr));

        Insertion insertion = new Insertion();
        insertion.sort(arr);
        System.out.println("=== 정렬 후 ===");
        System.out.println(Arrays.toString(arr));
    }
}
