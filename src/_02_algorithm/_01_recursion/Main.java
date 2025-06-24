package _02_algorithm._01_recursion;

public class Main {
    public static void main(String[] args) {
        RecursionSample recursion = new RecursionSample();

        recursion.myFunction(1);

        Factorial factorial = new Factorial();
        System.out.println("5!: " + factorial.factorial(5));


        int[] arr = {1, 2, 3, 4, 5};
        SumOfArray sumOfArray = new SumOfArray();
        int i = sumOfArray.sumArray(arr);
        System.out.println(i);

        char[] str = {'h','e','l','l','o'};
        LengthOfStr lengthOfStr = new LengthOfStr();
        int strLength = lengthOfStr.strLength(str);
        System.out.println(strLength);

        PowerSample powerSample = new PowerSample();
        int power = powerSample.power(2, 5);
        System.out.println(power);
    }
}
