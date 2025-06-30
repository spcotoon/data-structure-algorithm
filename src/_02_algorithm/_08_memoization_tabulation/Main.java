package _02_algorithm._08_memoization_tabulation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        Map<Integer, Integer> memo = new HashMap<>();

        long start = System.nanoTime();
        System.out.println(fibonacci.getSequenceWithRecursion(40));
        long end = System.nanoTime();
        System.out.println("재귀 피보나치 함수 실행시간 " + (end-start));

        start = System.nanoTime();
        System.out.println(fibonacci.getSequenceWithMemoizaion(40, memo));
        end = System.nanoTime();
        System.out.println("메모이제이션 함수 실행시간 " + (end-start));

        Map<Integer, Integer> memo2 = new HashMap<>();

        start = System.nanoTime();
        System.out.println(fibonacci.getSequenceWithTabulation(40, memo2));
        end = System.nanoTime();
        System.out.println("타뷸레이션 함수 실행시간 " + (end-start));

    }



}
