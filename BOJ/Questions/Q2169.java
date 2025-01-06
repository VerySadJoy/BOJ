//Question No: 2169
//Title: 로봇 조종하기
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {

    static int rows, cols;
    static int[][] grid, dp, temp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken());
        cols = Integer.parseInt(tokenizer.nextToken());
        grid = new int[rows][cols];
        dp = new int[rows][cols];
        temp = new int[2][cols];

        for (int i = 0; i < rows; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        dp[0][0] = grid[0][0];
        for (int j = 1; j < cols; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < rows; i++) {
            temp[0][0] = dp[i - 1][0] + grid[i][0];
            for (int j = 1; j < cols; j++) {
                temp[0][j] = Math.max(temp[0][j - 1], dp[i - 1][j]) + grid[i][j];
            }

            temp[1][cols - 1] = dp[i - 1][cols - 1] + grid[i][cols - 1];
            for (int j = cols - 2; j >= 0; j--) {
                temp[1][j] = Math.max(temp[1][j + 1], dp[i - 1][j]) + grid[i][j];
            }

            for (int j = 0; j < cols; j++) {
                dp[i][j] = Math.max(temp[0][j], temp[1][j]);
            }
        }

        System.out.println(dp[rows - 1][cols - 1]);
    }
}