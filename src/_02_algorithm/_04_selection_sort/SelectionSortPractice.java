package _02_algorithm._04_selection_sort;

import java.util.Arrays;

public class SelectionSortPractice {
    public static void main(String[] args) {

        int[] arr = {4, 2, 1, 3};
        System.out.println("=== 정렬 전 ===");
        System.out.println(Arrays.toString(arr));

        Selection selection = new Selection();
        selection.sort(arr);
        System.out.println("=== 정렬 후 ===");
        System.out.println(Arrays.toString(arr));
    }
}
