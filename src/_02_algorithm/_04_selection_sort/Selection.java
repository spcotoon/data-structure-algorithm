package _02_algorithm._04_selection_sort;

public class Selection {

    public void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minValueIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minValueIndex]) {
                    minValueIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minValueIndex];
            arr[minValueIndex] = temp;
        }
    }
}
