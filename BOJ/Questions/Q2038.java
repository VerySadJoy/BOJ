//Question No: 2038
//Title: 골롱 수열
//Tier: Gold I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void solve(int[] dp, int n) {
        dp[1] = 1;
        int sum = dp[1];
        int i = 1;

        while (sum < n) {
            i++;
            dp[i] = 1 + dp[i - dp[dp[i - 1]]];
            sum += dp[i];
        }

        System.out.println(i);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[1000001];
        solve(dp, n);
    }
}