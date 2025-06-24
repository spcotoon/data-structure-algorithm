package _02_algorithm._01_recursion;

public class SumOfArray {

    public int sumArray(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0; // 배열이 비어있거나 null이면 0 반환
        }
        return sumArrayRecursive(arr, 0); // 재귀 호출 시작
    }

    private int sumArrayRecursive(int[] arr, int index) {
        // 1. 기본 조건 (Base Case): 더 이상 처리할 요소가 없을 때
        if (index == arr.length) {
            return 0;
        }

        // 2. 재귀 단계 (Recursive Step): 현재 요소를 더하고 다음 요소로 이동
        return arr[index] + sumArrayRecursive(arr, index + 1);
    }

}
