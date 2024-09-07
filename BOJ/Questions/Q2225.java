//Question No: 2225
//Title: 합분해
//Tier: Gold V
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static int N, K;
    static final long MOD = 1000000000;
    static long[][] dp;

    public static void main(String[] args) throws Exception {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in)); 
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            
            StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            K = Integer.parseInt(tokenizer.nextToken());
            
            dp = new long[K + 1][N + 1];
            dp[0][0] = 1;
            
            for (int i = 1; i <= K; i++) {
                for (int j = 0; j <= N; j++) {
                    for (int k = 0; k <= j; k++) {
                        dp[i][j] += dp[i - 1][k];
                    }
                    dp[i][j] %= MOD;
                }
            }
            
            bufferedWriter.write(dp[K][N] + "\n");
            bufferedWriter.flush();
        }
    }
}