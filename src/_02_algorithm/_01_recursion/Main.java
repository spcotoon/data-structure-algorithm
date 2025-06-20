package _02_algorithm._01_recursion;

public class Main {
    public static void main(String[] args) {
        RecursionSample recursion = new RecursionSample();

        recursion.myFunction(1);

        Factorial factorial = new Factorial();
        System.out.println("5!: " + factorial.factorial(5));
    }
}
