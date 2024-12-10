//Question No: 15877
//Title: Apples and Bananas
//Tier: Gold IV
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int a = Integer.parseInt(input[0]);
        int b = Integer.parseInt(input[1]);

        if (a == 0 && b == 0) {
            System.out.println("Bob");
            return;
        }

        boolean[][] dp = new boolean[1010][1010];

        for (int i = 0; i <= 1000; i++) {
            for (int j = 0; j <= 1000; j++) {
                dp[i][j] = false;
                if (i - 1 >= 0 && j - 3 >= 0 && !dp[i - 1][j - 3]) {
                    dp[i][j] = true;
                }
                if (j - 1 >= 0 && i - 3 >= 0 && !dp[i - 3][j - 1]) {
                    dp[i][j] = true;
                }
                if (j - 1 >= 0 && !dp[i][j - 1]) {
                    dp[i][j] = true;
                }
                if (i - 1 >= 0 && !dp[i - 1][j]) {
                    dp[i][j] = true;
                }
            }
        }

        System.out.println(dp[a][b] ? "Alice" : "Bob");
    }
}