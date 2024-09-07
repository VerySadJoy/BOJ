//Question No: 16456
//Title: 하와와 대학생쨩 하와이로 가는 거시와요~
//Tier: Silver I
import java.util.Scanner;

public class Main {
    static final int MOD = 1000000009;
    static long[] dp = new long[50000];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        dp[0] = dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < number; i++) {
            dp[i] = (dp[i - 1] + dp[i - 3]) % MOD;
        }

        System.out.println(dp[number - 1]);
    }
}