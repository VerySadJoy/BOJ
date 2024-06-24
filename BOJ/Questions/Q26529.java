//Question No: 26529
//Title: Bunnies
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] input = reader.lines().mapToInt(Integer::parseInt).toArray();
        int N = input[0];

        int[] dp = new int[46];
        dp[0] = dp[1] = 1;

        for (int i = 2; i <= 45; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            int h = input[i];
            answer.append(dp[h]).append('\n');
        }

        System.out.print(answer.toString());
    }
}
