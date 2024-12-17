//Question No: 17435
//Title: 합성함수와 쿼리
//Tier: Gold I
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int LOG = 19;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder result = new StringBuilder();

        int m = Integer.parseInt(reader.readLine());
        var dp = new int[LOG + 1][m + 1];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= m; i++) {
            dp[0][i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 1; i <= LOG; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = dp[i - 1][dp[i - 1][j]];
            }
        }

        int queryCount = Integer.parseInt(reader.readLine());
        while (queryCount-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int x = Integer.parseInt(tokenizer.nextToken());
            for (int bit = 0; bit < LOG; bit++) {
                if ((n & (1 << bit)) > 0) {
                    x = dp[bit][x];
                }
            }
            result.append(x).append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}