//Question No: 6506
//Title: 엘 도라도
//Tier: Gold V
import java.util.*;
import java.io.*;

public class Main {

    static int totalNumbers, sequenceLength;
    static int[] board = new int[101];
    static long[][] dp = new long[101][101];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder outputBuilder = new StringBuilder();

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");

            totalNumbers = Integer.parseInt(tokenizer.nextToken());
            sequenceLength = Integer.parseInt(tokenizer.nextToken());

            if (totalNumbers == 0 && sequenceLength == 0) {
                break;
            }

            tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int i = 1; i <= totalNumbers; i++) {
                board[i] = Integer.parseInt(tokenizer.nextToken());
            }

            initializeDp();

            for (int i = 2; i <= totalNumbers; i++) {
                for (int j = i - 1; j >= 1; j--) {
                    if (board[i] <= board[j]) {
                        continue;
                    }
                    for (int a = 2; a <= sequenceLength; a++) {
                        dp[i][a] += dp[j][a - 1];
                    }
                }
            }

            long result = 0;
            for (int i = 1; i <= totalNumbers; i++) {
                result += dp[i][sequenceLength];
            }

            outputBuilder.append(result).append("\n");
        }

        System.out.print(outputBuilder);

        reader.close();
    }

    static void initializeDp() {
        for (int i = 1; i <= totalNumbers; i++) {
            for (int j = 1; j <= sequenceLength; j++) {
                dp[i][j] = 0;
            }
            dp[i][1] = 1;
        }
    }
}