//Question No: 11689
//Title: GCD(n, k) = 1
//Tier: Gold I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long euler = n;

        for (long p = 2; p * p <= n; p++) {
            if (n % p == 0) {
                euler = euler / p * (p - 1);
                while (n % p == 0) {
                    n = n / p;
                }
            }
        }

        if (n > 1) {
            euler = euler / n * (n - 1);
        }

        System.out.println(euler);
    }
}
