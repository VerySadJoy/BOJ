//Question No: 1535
//Title: 안녕
//Tier: Silver II
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfItems = Integer.parseInt(reader.readLine());
        int capacityLimit = 99;
        int[][] dp = new int[numberOfItems + 1][capacityLimit + 1];
        int[] weights = new int[numberOfItems + 1];
        int[] values = new int[numberOfItems + 1];
        
        StringTokenizer weightTokens = new StringTokenizer(reader.readLine());
        StringTokenizer valueTokens = new StringTokenizer(reader.readLine());
        
        for (int i = 1; i <= numberOfItems; i++) {
            weights[i] = Integer.parseInt(weightTokens.nextToken());
            values[i] = Integer.parseInt(valueTokens.nextToken());
        }
        
        for (int i = 1; i <= numberOfItems; i++) {
            for (int j = 1; j <= capacityLimit; j++) {
                if (weights[i] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - weights[i]] + values[i], dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        System.out.print(dp[numberOfItems][capacityLimit]);
    }
}