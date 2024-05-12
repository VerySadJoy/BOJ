//Question No: 1509
//Title: 팰린드롬 분할
//Tier: Gold I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
    static boolean[][] isPalindrome;
    static int[] dp;
    static String str;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        str = br.readLine();
        isPalindrome = new boolean[str.length()][str.length()];
        dp = new int[str.length() + 1];

        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j <= i; j++) {
                if (str.charAt(i) == str.charAt(j) && (i - j < 2 || isPalindrome[j + 1][i - 1])) {
                    isPalindrome[j][i] = true;
                }
            }
        }

        dp[0] = 0;
        for (int i = 1; i <= str.length(); i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        bw.write(String.valueOf(dp[str.length()]));
        bw.flush();
        bw.close();
        br.close();
    }
}
