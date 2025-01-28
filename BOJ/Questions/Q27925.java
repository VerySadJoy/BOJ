//Question No: 27925
//Title: 인덕션
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {

    static final int INF = 1_000_000_000;
    static int n;
    static int[] arr;
    static int[][][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dp = new int[n][10][10][10];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        bw.write(String.valueOf(recur(0, 0, 0, 0)));
        bw.flush();
        bw.close();
        br.close();
    }

    private static int recur(int depth, int one, int two, int three) {
        if (depth == n) {
            return 0;
        }
        if (dp[depth][one][two][three] != -1) {
            return dp[depth][one][two][three];
        }

        int result = INF;

        result = Math.min(result,
                recur(depth + 1, arr[depth], two, three) + Math.min(Math.abs(one - arr[depth]),
                        10 - Math.max(one, arr[depth]) + Math.min(one, arr[depth])));

        result = Math.min(result,
                recur(depth + 1, one, arr[depth], three) + Math.min(Math.abs(two - arr[depth]),
                        10 - Math.max(two, arr[depth]) + Math.min(two, arr[depth])));

        result = Math.min(result,
                recur(depth + 1, one, two, arr[depth]) + Math.min(Math.abs(three - arr[depth]),
                        10 - Math.max(three, arr[depth]) + Math.min(three, arr[depth])));

        return dp[depth][one][two][three] = result;
    }
}