//Question No: 30518
//Title: 짜고 치는 가위바위보 (Small)
//Tier: Silver I
import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String lighter = reader.readLine().trim();
        String smallant = reader.readLine().trim();

        int avail = 0;
        int n = smallant.length();

        for (int pick = 1; pick <= n; pick++) {
            List<int[]> combinations = generateCombinations(n, pick);
            for (int[] combination : combinations) {
                StringBuilder stringBuilder = new StringBuilder(lighter);
                for (int index : combination) {
                    stringBuilder.append(smallant.charAt(index));
                }
                String combinedString = stringBuilder.toString();
                if (isValid(combinedString)) {
                    avail++;
                    avail %= MOD;
                }
            }
        }
        System.out.println(avail);
    }

    static List<int[]> generateCombinations(int n, int k) {
        List<int[]> combinations = new ArrayList<>();
        combine(combinations, new int[k], 0, n - 1, 0);
        return combinations;
    }

    static void combine(List<int[]> combinations, int[] comb, int start, int end, int index) {
        if (index == comb.length) {
            combinations.add(comb.clone());
            return;
        }
        for (int i = start; i <= end && end - i + 1 >= comb.length - index; i++) {
            comb[index] = i;
            combine(combinations, comb, i + 1, end, index + 1);
        }
    }

    static boolean isValid(String s) {
        for (int i = 0; i < s.length() - 2; i++) {
            char a = s.charAt(i);
            char b = s.charAt(i + 1);
            char c = s.charAt(i + 2);
            if ((a == 'R' && b == 'S' && c == 'S') ||
                (a == 'S' && b == 'P' && c == 'P') ||
                (a == 'P' && b == 'R' && c == 'R')) {
                return false;
            }
        }
        return true;
    }
}
