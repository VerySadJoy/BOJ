//Question No: 15989
//Title: 1, 2, 3 더하기 4
//Tier: Gold V
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        
        int testCases = Integer.parseInt(reader.readLine());
        int[][] dp = new int[10001][4];
        
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 10000; i++) {
            dp[i][1] = dp[i - 1][1];
            dp[i][2] = dp[i - 2][1] + dp[i - 2][2];
            dp[i][3] = dp[i - 3][1] + dp[i - 3][2] + dp[i - 3][3];
        }
        
        for (int i = 0; i < testCases; i++) {
            int number = Integer.parseInt(reader.readLine());
            output.append(dp[number][1] + dp[number][2] + dp[number][3]).append("\n");
        }

        System.out.println(output);
    }
}
