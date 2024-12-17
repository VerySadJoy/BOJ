//Question No: 2482
//Title: 색상환
//Tier: Gold III
import java.io.*;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int MOD = 1_000_000_003;

    private static int n, k;
    private static int[][] dp;

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(reader.readLine());
        k = Integer.parseInt(reader.readLine());

        dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][1] = i;
            dp[i][0] = 1;
        }

        for (int i = 3; i <= n; i++) {
            for (int j = 2; j <= (i + 1) / 2; j++) {
                dp[i][j] = (dp[i - 1][j] + dp[i - 2][j - 1]) % MOD;
            }
        }

        writer.write((dp[n - 3][k - 1] + dp[n - 1][k]) % MOD + "\n");
        writer.close();
        reader.close();
    }
}