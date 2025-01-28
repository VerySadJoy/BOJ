//Question No: 6531
//Title: 이런 문제는 유치원생도 해결할 수 있어
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {

    static String s;
    static char[][] dp;

    public static boolean rec(int l, int r) {
        int len = r - l + 1;
        if (len <= 1) {
            return true;
        } else if (len == 2) {
            return s.charAt(l) == '{' && s.charAt(r) == '}';
        }

        if (dp[l][r] != 42) {
            return dp[l][r] == 1;
        }

        boolean res = s.charAt(l + 1) == ',' && rec(l + 2, r);
        if (!res && s.charAt(l) == '{') {
            for (int t = l + 1; t <= r; t++) {
                if (s.charAt(t) == '}' && rec(l + 1, t - 1)) {
                    res = (t == r) || (s.charAt(t + 1) == ',' && t + 2 <= r && rec(t + 2, r));
                    if (res) {
                        break;
                    }
                }
            }
        }
        dp[l][r] = (char) (res ? 1 : 0);
        return res;
    }

    public static boolean solve(BufferedReader reader) throws IOException {
        s = reader.readLine();
        int n = s.length();
        dp = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], (char) 42);
        }
        return s.charAt(0) == '{' && s.charAt(n - 1) == '}' && rec(1, n - 2);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(reader.readLine());
        for (int testCase = 1; testCase <= t; testCase++) {
            boolean result = solve(reader);
            writer.write("Word #" + testCase + ": " + (result ? "Set\n" : "No Set\n"));
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}