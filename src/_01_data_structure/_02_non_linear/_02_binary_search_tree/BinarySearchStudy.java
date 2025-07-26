package _01_data_structure._02_non_linear._02_binary_search_tree;

public class BinarySearchStudy {
    public static void main(String[] args) {

        Integer[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        int index = binarySearch(arr, 3, 0, arr.length - 1);

        if (index != -1) { // -1이 아니면 찾은 것
            System.out.println("찾는 값 3의 인덱스: " + index);
        } else {
            System.out.println("값을 찾을 수 없습니다.");
        }
    }

    private static int binarySearch(Integer[] arr, int target, int start, int end) {
        if (start > end) {
            return -1;
        }

        int mid = (int) (double) ((start + end) / 2);

        if (arr[mid] == target) {
            return mid;
        } else if (target > arr[mid]) {
            return binarySearch(arr, target, mid + 1, end);
        } else {
            return binarySearch(arr, target, start, mid - 1);
        }
    }
}
