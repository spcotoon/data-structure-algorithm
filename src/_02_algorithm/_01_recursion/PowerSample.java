package _02_algorithm._01_recursion;

public class PowerSample {
    public int power(int x, int n) {
        if (n == 0) {
            return 1;
        }

        return power(x, n - 1) * x;
    }
}
