package _02_algorithm._01_basic._01_recursion;

public class LengthOfStr {

    // 문자열(char 배열)의 길이를 재귀적으로 계산하는 공개 메서드
    public int strLength(char[] arr) {
        if (arr == null) {
            return 0; // null 배열인 경우 길이는 0
        }
        return strLengthRecursive(arr, 0); // 재귀 호출 시작
    }

    // 실제 재귀 로직을 담당하는 private 헬퍼 메서드
    private int strLengthRecursive(char[] arr, int index) {
        // 1. 기본 조건 (Base Case):
        // 현재 인덱스가 배열의 길이와 같으면 (즉, 배열의 끝에 도달하면)
        // 더 이상 셀 문자가 없으므로 0을 반환합니다.
        if (index == arr.length) {
            return 0;
        }

        // 2. 재귀 단계 (Recursive Step):
        // 현재 문자를 1로 세고 (현재 문자의 존재 자체를 1로 계산),
        // 다음 인덱스로 이동하여 나머지 문자열의 길이를 재귀적으로 더합니다.
        return 1 + strLengthRecursive(arr, index + 1);
    }
}
