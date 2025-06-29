package _02_algorithm._07_quick_sort;

public class Quick {

    public void sort(int[] arr, int left, int right) {
        if (left <= right) {
            int pivot = divide(arr, left, right);
            sort(arr, left, pivot -1);
            sort(arr, pivot + 1, right);
        }
    }

    private int divide(int[] arr, int left, int right) {
        int pivot = arr[left];
        int leftStartIndex = left + 1;
        int rightStartIndex = right;

        //leftStartIndex 가 rightStartIndex 보다 크면, 서로 지나쳤단 뜻
        while (leftStartIndex <= rightStartIndex) {

            // leftStartIndex 가 배열 범위 안에서(right) 오른쪽으로 이동하면서 pivot 보다 큰 숫자 만나면 멈춤.
            while (leftStartIndex <= right && pivot >= arr[leftStartIndex]) {
                leftStartIndex++;
            }

            // rightStartIndex 가 배열 범위 안에서(left) 왼쪽쪽으로 이동하면서 pivot 보다 작은 숫자 만나면 멈춤.
            while (rightStartIndex >= (left + 1) && pivot <= arr[rightStartIndex]) {
                rightStartIndex--;
            }

            //아직 leftStartIndex와 rightStartIndex가 서로 지나치지 않은 상황에서 각각의 조건으로 멈췄다면 서로 자리 교체
            if (leftStartIndex <= rightStartIndex) {
                swap(arr, leftStartIndex, rightStartIndex);
            }
        }//여기까지 반복문 다 돌고나면 leftStartIndex와 rightStartIndex가 서로 지나치게됨

        //이때 pivot 위치랑 rightStartIndex 교환해주면 pivot이 자기 자리를 찾아 정렬됨
        swap(arr, left, rightStartIndex);
        return rightStartIndex;
    }

    private void swap(int[] arr, int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }
}
