package _02_algorithm._01_basic._06_merge_sort;

public class Merge {


    public void sort(int[] arr, int leftIndex, int rightIndex) {

        if (leftIndex < rightIndex) {
            int midIndex = (leftIndex + rightIndex) / 2;
            sort(arr, leftIndex, midIndex);
            sort(arr, midIndex + 1, rightIndex);
            merge(arr, leftIndex, midIndex, rightIndex);
        }
    }

    private void merge(int[] arr, int leftIndex, int midIndex, int rightIndex) {
        //반 자른 좌,우 시작지점 인덱스
        int leftAreaIndex = leftIndex;
        int rightAreaIndex = midIndex + 1;

        //rightIndex가 현재 배열 제일 끝에있으니 +1 해주면 현재 배열 길이
        int[] tempArr = new int[rightIndex + 1];
        //복사본에 값 채울 임시 인덱스
        int tempArrIndex = leftIndex;

        while (leftAreaIndex <= midIndex && rightAreaIndex <= rightIndex) {
            if (arr[leftAreaIndex] <= arr[rightAreaIndex]) {

                //후위 증가식으로
                //tempArr[tempArrIndex] = arr[leftAreaIndex++];
                //이래도 되지만 햇갈리니 일단 아래처럼 나눠서 씀
                tempArr[tempArrIndex] = arr[leftAreaIndex];
                leftAreaIndex++;
            } else {
                tempArr[tempArrIndex] = arr[rightAreaIndex];
                rightAreaIndex++;
            }
            tempArrIndex++;
        }

        // while 문 통해서 왼쪽영역이 먼저 복사 끝났을 때
        // 즉 while 문의 leftAreaIndex <= midIndex 이 조건 벗어 났을때
        if (leftAreaIndex > midIndex) {
            for (int i = rightAreaIndex; i <= rightIndex; i++) {
                tempArr[tempArrIndex] = arr[i];
                tempArrIndex++;
            }
        } else {
            // while 문 통해서 오른쪽영역이 복사 먼저 끝났을 때
            // 얜 while의 rightAreaIndex <= rightIndex 이조건 벗어났을때고
            for (int i = leftAreaIndex; i <= midIndex; i++) {
                tempArr[tempArrIndex] = arr[i];
                tempArrIndex++;
            }
        }

        for (int i = leftIndex; i <= rightIndex; i++) {
            arr[i] = tempArr[i];
        }
    }
}
