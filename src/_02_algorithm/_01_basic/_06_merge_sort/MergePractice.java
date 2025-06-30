package _02_algorithm._01_basic._06_merge_sort;

import java.util.Arrays;

public class MergePractice {
    public static void main(String[] args) {
        int[] arr = {3, 5, 2, 4, 1, 7, 8, 6};
        System.out.println("=== 정렬 전 ===");
        System.out.println(Arrays.toString(arr));

        Merge merge = new Merge();
        merge.sort(arr, 0, arr.length - 1);
        System.out.println("=== 정렬 후 ===");
        System.out.println(Arrays.toString(arr));

    }
}
