//Question No: 1126
//Title: 같은 탑
//Tier: Platinum III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNext()) {
            n = sc.nextInt();
            arr = new int[n + 2];
            dp = new int[52][500002];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            for (int i = 0; i < 52; i++) {
                for (int j = 0; j < 500002; j++) {
                    dp[i][j] = -2;
                }
            }

            System.out.println(calculateMaxHeight(0, 0, 0));
        }
    }

    static int n;
    static int[] arr;
    static int[][] dp;

    private static int calculateMaxHeight(int index, int leftTop, int rightTop) {
        int difference = leftTop - rightTop + 250000;

        if (index > n) return -1;

        if (leftTop > 250000 || rightTop > 250000) return -1;
        if (dp[index][difference] != -2) return dp[index][difference];

        dp[index][difference] = -1;
        if (leftTop == rightTop && leftTop != 0) dp[index][difference] = 0;

        int leftHeight = calculateMaxHeight(index + 1, leftTop + arr[index], rightTop);
        int rightHeight = calculateMaxHeight(index + 1, leftTop, rightTop + arr[index]);
        int middleHeight = calculateMaxHeight(index + 1, leftTop, rightTop);

        if (leftHeight != -1) {
            dp[index][difference] = Math.max(dp[index][difference], leftHeight + arr[index]);
        }
        if (rightHeight != -1) {
            dp[index][difference] = Math.max(dp[index][difference], rightHeight);
        }
        if (middleHeight != -1) {
            dp[index][difference] = Math.max(dp[index][difference], middleHeight);
        }

        return dp[index][difference];
    }
}
