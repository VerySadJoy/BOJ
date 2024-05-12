//Question No: 2098
//Title: 외판원 순회
//Tier: Gold I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader reader;
    public static int N;
    public static int[][] W;
    public static int[][] dp;
    public static final int INF = 16 * 1_000_000;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());
        W = new int[N][N];
        dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int result = tsp(0, 1);

        System.out.println(result);
    }

    public static int tsp(int current, int visited) {
        if (visited == (1 << N) - 1) {
            if (W[current][0] == 0) {
                return INF;
            }
            return W[current][0];
        }

        if (dp[current][visited] != 0) {
            return dp[current][visited];
        }

        dp[current][visited] = INF;

        for (int i = 0; i < N; i++) {
            if ((visited & (1 << i)) == 0 && W[current][i] != 0) {
                dp[current][visited] = Math.min(dp[current][visited], tsp(i, visited | (1 << i)) + W[current][i]);
            }
        }

        return dp[current][visited];
    }
}
