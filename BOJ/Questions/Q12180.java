//Question No: 12180
//Title: Googlander (Small)
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int R = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            int[][] dp = new int[R][C];
            dp[0][0] = 1;

            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (i - 1 >= 0) {
                        dp[i][j] += dp[i - 1][j];
                    }
                    if (j - 1 >= 0) {
                        dp[i][j] += dp[i][j - 1];
                    }
                }
            }

            System.out.println("Case #" + t + ": " + dp[R - 1][C - 1]);
        }
    }
}
