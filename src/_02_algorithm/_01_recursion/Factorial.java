package _02_algorithm._01_recursion;

public class Factorial {
    public int factorial(int number) {
        if (number == 1 || number == 0) {
            return 1;
        } else {
            return number * factorial(number -1);
        }
    }
}
