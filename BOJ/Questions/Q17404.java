//Question No: 17404
//Title: RGB거리 2
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1000000;
    static int[][] cost;
    static int[][] dp;

    static int minCost(int n, int startColor) {
        for (int i = 0; i < 3; i++) {
            if (i == startColor) dp[0][i] = cost[0][i];
            else dp[0][i] = INF;
        }

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i - 1][1], dp[i - 1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i - 1][0], dp[i - 1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i - 1][0], dp[i - 1][1]) + cost[i][2];
        }

        int minVal = INF;
        for (int i = 0; i < 3; i++) {
            if (i != startColor) minVal = Math.min(minVal, dp[n - 1][i]);
        }
        return minVal;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        cost = new int[n][3];
        dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        for (int startColor = 0; startColor < 3; startColor++) {
            answer = Math.min(answer, minCost(n, startColor));
        }
        System.out.println(answer);
    }
}
