//Question No: 10266
//Title: 시계 사진들
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 360000;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int n = Integer.parseInt(tokenizer.nextToken());
        boolean[] clock1 = new boolean[MAX * 2];
        boolean[] clock2 = new boolean[MAX];
        
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            clock1[num] = clock1[MAX + num] = true;
        }
        
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            clock2[num] = true;
        }
        
        System.out.println(kmp(clock1, clock2));
    }

    static List<Integer> getPi(boolean[] pattern) {
        int m = pattern.length;
        List<Integer> pi = new ArrayList<>(Collections.nCopies(m, 0));
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = pi.get(j - 1);
            }
            if (pattern[i] == pattern[j]) {
                pi.set(i, ++j);
            }
        }
        return pi;
    }

    static String kmp(boolean[] text, boolean[] pattern) {
        List<Integer> pi = getPi(pattern);
        int m = pattern.length;
        int n = text.length;
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text[i] != pattern[j]) {
                j = pi.get(j - 1);
            }
            if (text[i] == pattern[j]) {
                if (j == m - 1) {
                    return "possible";
                } else {
                    j++;
                }
            }
        }
        return "impossible";
    }
}