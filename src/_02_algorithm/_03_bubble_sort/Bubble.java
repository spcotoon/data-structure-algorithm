package _02_algorithm._03_bubble_sort;

public class Bubble {
    public void sort(int[] arr) {
        //자기 옆 데이터랑 비교하며 자리 바꿈
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < (arr.length - i - 1); j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
}
