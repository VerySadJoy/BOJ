//Question No: 1648
//Title: 격자판 채우기
//Tier: Platinum III
import java.util.*;
import java.io.*;

public class Main {
    static int rows, cols;
    static int[][] dp;
    static final int MOD = 9901;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        dp = new int[rows * cols][1 << cols];
        for (int i = 0; i < rows * cols; i++) {
            Arrays.fill(dp[i], -1);
        }
        System.out.println(recursion(0, 0));
    }

    public static int recursion(int blockIndex, int status) {
        if (blockIndex == rows * cols && status == 0) return 1;
        if (blockIndex >= rows * cols) return 0;
        if (dp[blockIndex][status] != -1) return dp[blockIndex][status];
        dp[blockIndex][status] = 0;
        if ((status & 1) != 0) {
            dp[blockIndex][status] += recursion(blockIndex + 1, status >> 1);
        } else {
            dp[blockIndex][status] += recursion(blockIndex + 1, (status | 1 << cols) >> 1);
            if (blockIndex % cols != cols - 1 && (status & 2) == 0) {
                dp[blockIndex][status] += recursion(blockIndex + 2, status >> 2);
            }
        }
        dp[blockIndex][status] %= MOD;
        return dp[blockIndex][status];
    }
}
