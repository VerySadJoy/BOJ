//Question No: 13034
//Title: 다각형 게임
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int[] dp = new int[1001];
        dp[0] = dp[1] = 0;
        dp[2] = 1;

        int n = Integer.parseInt(reader.readLine());
        boolean[] calculated = new boolean[16];

        for (int i = 3; i <= n; i++) {
            Arrays.fill(calculated, false);

            for (int j = 0; j <= i - 2; j++) {
                int xorResult = dp[j] ^ dp[i - 2 - j];
                calculated[xorResult] = true;
            }

            for (int j = 0; j < 16; j++) {
                if (!calculated[j]) {
                    dp[i] = j;
                    break;
                }
            }
        }

        writer.write(dp[n] != 0 ? "1\n" : "2\n");
        writer.close();
        reader.close();
    }
}