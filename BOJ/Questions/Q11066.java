//Question No: 11066
//Title: 파일 합치기
//Tier: Gold III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokenizer = null;

    public static void main(String[] args) throws Exception {
        int testCases = Integer.parseInt(reader.readLine());

        for (int testCase = 0; testCase < testCases; testCase++) {
            int chapters;
            int[] chapterSizes;
            int[] cumulativeSums;
            int[][] dp;

            chapters = Integer.parseInt(reader.readLine());
            chapterSizes = new int[chapters + 1];
            dp = new int[chapters + 1][chapters + 1];
            cumulativeSums = new int[chapters + 1];

            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= chapters; i++) {
                chapterSizes[i] = Integer.parseInt(tokenizer.nextToken());
                cumulativeSums[i] = cumulativeSums[i - 1] + chapterSizes[i];
            }

            for (int length = 1; length <= chapters; length++) {
                for (int start = 1; start + length <= chapters; start++) {
                    int end = start + length;
                    dp[start][end] = Integer.MAX_VALUE;
                    for (int divide = start; divide < end; divide++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][divide] + dp[divide + 1][end] + cumulativeSums[end] - cumulativeSums[start - 1]);
                    }
                }
            }

            System.out.println(dp[1][chapters]);
        }
    }
}