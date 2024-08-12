//Question No: 2747
//Title: 피보나치 수
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    static int[] memoizedFib = new int[46];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fibonacci(n));
    }

    public static int fibonacci(int n) {
        if (n == 0) {
            memoizedFib[0] = 0;
            return 0;
        }
        if (n == 1) {
            memoizedFib[1] = 1;
            return 1;
        }
        if (memoizedFib[n] == 0) {
            memoizedFib[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return memoizedFib[n];
    }
}