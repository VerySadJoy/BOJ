//Question No: 11479
//Title: 서로 다른 부분 문자열의 개수 2
//Tier: Platinum II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        
        int n = s.length();
        int[] suffixArray = buildSuffixArray(s, n);
        int[] lcpArray = buildLCPArray(s, n, suffixArray);
        
        long totalSubstrings = (long) n * (n + 1) / 2;
        for (int i = 1; i < n; i++) {
            totalSubstrings -= lcpArray[i];
        }
        
        System.out.println(totalSubstrings);
    }
    
    private static int[] buildSuffixArray(String s, int n) {
        Integer[] suffixArray = new Integer[n];
        int[] rank = new int[2 * n];
        int[] newRank = new int[2 * n];
        
        for (int i = 0; i < n; i++) {
            suffixArray[i] = i;
            rank[i] = s.charAt(i);
        }
        
        for (int d = 1; d < n; d <<= 1) {
            int finalD = d;
            Arrays.sort(suffixArray, (i, j) -> {
                if (rank[i] != rank[j]) return rank[i] - rank[j];
                return rank[i + finalD] - rank[j + finalD];
            });
            
            newRank[suffixArray[0]] = 1;
            for (int i = 1; i < n; i++) {
                newRank[suffixArray[i]] = newRank[suffixArray[i - 1]] + (rank[suffixArray[i - 1]] != rank[suffixArray[i]] ||
                                                                         rank[suffixArray[i - 1] + d] != rank[suffixArray[i] + d] ? 1 : 0);
            }
            System.arraycopy(newRank, 0, rank, 0, n);
        }
        
        return Arrays.stream(suffixArray).mapToInt(Integer::intValue).toArray();
    }
    
    private static int[] buildLCPArray(String s, int n, int[] suffixArray) {
        int[] lcpArray = new int[n];
        int[] inverseSuffixArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            inverseSuffixArray[suffixArray[i]] = i;
        }
        
        for (int k = 0, i = 0; i < n; i++) {
            if (inverseSuffixArray[i] > 0) {
                int j = suffixArray[inverseSuffixArray[i] - 1];
                while (i + k < n && j + k < n && s.charAt(i + k) == s.charAt(j + k)) {
                    k++;
                }
                lcpArray[inverseSuffixArray[i]] = k;
                if (k > 0) k--;
            }
        }
        
        return lcpArray;
    }
}