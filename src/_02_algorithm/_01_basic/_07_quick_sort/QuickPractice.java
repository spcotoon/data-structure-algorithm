package _02_algorithm._01_basic._07_quick_sort;

import java.util.Arrays;

public class QuickPractice {
    public static void main(String[] args) {

        int[] arr = {5, 3, 7, 2, 6, 4, 9, 1, 8};
        System.out.println("=== 정렬 전 ===");
        System.out.println(Arrays.toString(arr));

        Quick quick = new Quick();
        quick.sort(arr, 0, arr.length - 1);

        System.out.println("=== 정렬 후 ===");
        System.out.println(Arrays.toString(arr));
    }
}
