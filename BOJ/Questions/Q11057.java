//Question No: 11057
//Title: 오르막 수
//Tier: Silver I
import java.util.Scanner;

public class Main {
    static final int MOD = 10007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[][] dp = new int[n + 1][10];

        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dp[i][0] = 1;
                    continue;
                }
                dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % MOD;
            }
        }

        int result = 0;
        for (int i = 0; i < 10; i++) {
            result = (result + dp[n][i]) % MOD;
        }

        System.out.println(result);
    }
}
