package _02_algorithm._01_basic._02_hanoitower;

public class Hanoi {

    //ㅗㅗㅗ 모양의 하노이탑 게임
    //A B C
    //count 는 기둥 개수, from 은 현재 기둥, to는 옮길 기둥, temp는 원판들 임시로 둘 기둥.
    public void tower(int count,char from,char to,char temp) {
        if( count == 0) return;
        tower(count - 1, from, temp, to);
        System.out.printf("원반 %d를 %s에서 %s로 이동\n", count, from, to);
        tower(count - 1, temp, to, from);
    }
}
