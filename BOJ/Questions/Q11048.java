//Question No: 11048
//Title: 이동하기
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = reader.readLine().split(" ");

        int rows = Integer.parseInt(inputs[0]);
        int columns = Integer.parseInt(inputs[1]);

        int[][] map = new int[rows + 1][columns + 1];
        int[][] dp = new int[rows + 1][columns + 1];
        
        for (int i = 1; i <= rows; i++) {
            inputs = reader.readLine().split(" ");
            for (int j = 1; j <= columns; j++) {
                map[i][j] = Integer.parseInt(inputs[j - 1]);
            }
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                dp[i][j] = Math.max(map[i][j] + dp[i - 1][j], map[i][j] + dp[i][j - 1]);
            }
        }

        System.out.println(dp[rows][columns]);
    }
}