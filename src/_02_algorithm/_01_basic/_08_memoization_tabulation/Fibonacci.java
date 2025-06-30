package _02_algorithm._01_basic._08_memoization_tabulation;

import java.util.Map;

public class Fibonacci {
    public int getSequenceWithRecursion(int number) {
        if(number == 0 || number == 1 ) return number;
        return getSequenceWithRecursion(number - 2) + getSequenceWithRecursion(number - 1);
    }
    //재귀하다 보면 중복되는 계산이 많아짐. 비효율
    //중복되는 계산을 저장하고 중복되는 곳에서 저장된걸 꺼내쓰기
    //해시테이블 이용(계산할 값 key, 계산 된 값 value)

    public int getSequenceWithMemoizaion(int number, Map<Integer, Integer> memo) {
        if(number == 0 || number == 1 ) return number;

        if (memo.containsKey(number)) {
            return memo.get(number);
        }

        int result = getSequenceWithMemoizaion(number - 1, memo) + getSequenceWithMemoizaion(number - 2, memo);
        memo.put(number, result);
        return result;
    }

    public int getSequenceWithTabulation(int number, Map<Integer, Integer> memo) {
        if(number <= 1 ) return number;

        memo.put(0, 0);
        memo.put(1, 1);

        for (int i = 2; i <= number; i++) {
            memo.put(i, memo.get(i - 2) + memo.get(i - 1));
        }

        return memo.get(number);
    }
}
