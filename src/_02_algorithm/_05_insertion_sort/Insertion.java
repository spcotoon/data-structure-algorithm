package _02_algorithm._05_insertion_sort;

public class Insertion {

    public void sort(int[] arr) {
        //정렬된 영역에 아직 정렬되지 않은 영역 원소를 비교하며 끼워넣음.
        //선택정렬에서 0번째 원소는 이미 정렬된 영역으로 가정하기 때문에 i = 1부터 시작
        for (int i = 1; i < arr.length; i++) {
            int insertingData = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > insertingData) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = insertingData;
        }
    }
}
