//Question No: 18249
//Title: 욱제가 풀어야 하는 문제
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    private static final int MOD = 1000000007;
    private static final int MAX = 191230;
    private static int[] dp = new int[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i < MAX; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % MOD;
        }

        int t = Integer.parseInt(br.readLine().trim());
        StringBuilder sb = new StringBuilder();

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            sb.append(dp[n]).append("\n");
        }

        System.out.print(sb.toString());
    }
}
