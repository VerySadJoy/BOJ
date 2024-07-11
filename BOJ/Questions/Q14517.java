//Question No: 14517
//Title: 팰린드롬 개수 구하기 (Large)
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        int length = inputString.length();
        int[][] palindromeSubsequenceCount = new int[length][length];
        int MOD = 10007;

        for (int i = 0; i < length; i++) {
            palindromeSubsequenceCount[i][i] = 1;
        }

        for (int i = 1; i < length; i++) {
            palindromeSubsequenceCount[i - 1][i] = 2;
            if (inputString.charAt(i) == inputString.charAt(i - 1)) {
                palindromeSubsequenceCount[i - 1][i]++;
            }
        }

        for (int gap = 2; gap < length; gap++) {
            for (int start = 0; start + gap < length; start++) {
                int end = start + gap;
                if (inputString.charAt(start) == inputString.charAt(end)) {
                    palindromeSubsequenceCount[start][end] = (palindromeSubsequenceCount[start][end - 1]  + palindromeSubsequenceCount[start + 1][end] + 1) % MOD;
                } else {
                    palindromeSubsequenceCount[start][end] = (MOD  + palindromeSubsequenceCount[start][end - 1] + palindromeSubsequenceCount[start + 1][end] - palindromeSubsequenceCount[start + 1][end - 1]) % MOD;
                }
            }
        }

        System.out.println(palindromeSubsequenceCount[0][length - 1]);
    }
}
