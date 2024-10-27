//Question No: 30413
//Title: 양 한 마리... 양 A마리... 양 A제곱마리...
//Tier: Gold III
import java.util.Scanner;

public class Main {

    private static final int MOD = 1_000_000_007;

    private static long power(long base, long exponent) {
        if (exponent == 1) return base;
        long result = power(base, exponent / 2);
        result = result * result % MOD;
        if (exponent % 2 != 0) result = result * base % MOD;
        return result % MOD;
    }

    private static void solve() {
        Scanner scanner = new Scanner(System.in);
        long base = scanner.nextLong();
        long exponent = scanner.nextLong();
        if (base == 1) {
            System.out.println(exponent % MOD);
        } else {
            long result = (power(base, exponent) - 1) * power(base - 1, MOD - 2) % MOD;
            System.out.println(result);
        }
        scanner.close();
    }

    public static void main(String[] args) {
        int testCases = 1;
        while (testCases-- > 0) {
            solve();
        }
    }
}