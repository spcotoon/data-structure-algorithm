package _02_algorithm._01_recursion;

public class RecursionSample {
    public void myFunction(int number) {
        if (number > 10) {
            return;
        }

        System.out.println(number);
        myFunction(number + 1);
    }
}
