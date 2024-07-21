//Question No: 2673
//Title: 교차하지 않는 원의 현들의 최대집합
//Tier: Platinum IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] dp = new int[101][101];
        int[][] cost = new int[101][101];

        for (int i = 0; i < n; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            cost[start][end] = cost[end][start] = 1;
        }

        for (int i = 1; i <= 100; i++) {
            for (int j = i; j >= 1; j--) {
                for (int k = j; k < i; k++) {
                    dp[j][i] = Math.max(dp[j][i], dp[j][k] + dp[k][i] + cost[i][j]);
                }
            }
        }

        System.out.println(dp[1][100]);
    }
}