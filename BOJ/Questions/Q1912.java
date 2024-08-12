//Question No: 1912
//Title: 연속합
//Tier: Silver II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] dp = new int[n];
        
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int result = array[0];
        dp[0] = array[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            result = Math.max(dp[i], result);
        }

        System.out.println(result);
    }
}