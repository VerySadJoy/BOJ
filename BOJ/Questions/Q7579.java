//Question No: 7579
//Title: 앱
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static int[] memory, cost;
    static int[][] dp;
    static final int MAX_COST = 10001;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        memory = new int[N + 1];
        cost = new int[N + 1];
        dp = new int[N + 1][MAX_COST];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            memory[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        int result = findMinimumCost();

        System.out.println(result);
    }

    static int findMinimumCost() {
        int minCost = MAX_COST;

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < MAX_COST; j++) {
                if (j >= cost[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost[i]] + memory[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }

                if (dp[i][j] >= M) {
                    minCost = Math.min(minCost, j);
                }
            }
        }

        return minCost;
    }
}
