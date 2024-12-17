//Question No: 1311
//Title: 할 일 정하기 1
//Tier: Gold I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int INF = 20 * 10000 + 1;

    public static void main(String[] args) throws Exception {
        int n = Integer.parseInt(reader.readLine());
        int[][] costMatrix = new int[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 1; j <= n; j++) {
                costMatrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int[][] dp = new int[n + 1][1 << (n + 1)];
        for (int[] row : dp) Arrays.fill(row, INF);
        dp[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < 1 << (n + 1); j++) {
                if (dp[i - 1][j] == INF) continue;

                for (int k = 1; k <= n; k++) {
                    if ((j & (1 << k)) != 0) continue;
                    dp[i][j | (1 << k)] = Math.min(dp[i][j | (1 << k)], dp[i - 1][j] + costMatrix[i][k]);
                }
            }
        }

        System.out.println(dp[n][(1 << (n + 1)) - 2]);
    }
}