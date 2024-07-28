//Question No: 9248
//Title: Suffix Array
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static int[] pos = new int[500001];

    static class SuffixComparator implements Comparator<Integer> {
        private final int[] group;
        private final int t;

        SuffixComparator(int[] group, int t) {
            this.group = group;
            this.t = t;
        }

        @Override
        public int compare(Integer a, Integer b) {
            if (group[a] != group[b]) return Integer.compare(group[a], group[b]);
            return Integer.compare(group[a + t], group[b + t]);
        }
    }

    static List<Integer> computeSuffixArray(String s) {
        int n = s.length();
        int t = 1;
        int[] group = new int[n + 1];
        for (int i = 0; i < n; i++) group[i] = s.charAt(i);
        group[n] = -1;

        List<Integer> suffixArray = new ArrayList<>(n);
        for (int i = 0; i < n; i++) suffixArray.add(i);

        while (t < n) {
            SuffixComparator comparator = new SuffixComparator(group, t);
            suffixArray.sort(comparator);

            t *= 2;
            if (t >= n) break;

            int[] newGroup = new int[n + 1];
            newGroup[n] = -1;
            newGroup[suffixArray.get(0)] = 0;

            for (int i = 1; i < n; i++) {
                if (comparator.compare(suffixArray.get(i - 1), suffixArray.get(i)) != 0) {
                    newGroup[suffixArray.get(i)] = newGroup[suffixArray.get(i - 1)] + 1;
                } else {
                    newGroup[suffixArray.get(i)] = newGroup[suffixArray.get(i - 1)];
                }
            }
            group = newGroup;
        }

        return suffixArray;
    }

    static List<Integer> computeLCPArray(String s, List<Integer> suffixArray) {
        int n = s.length();
        List<Integer> lcpArray = new ArrayList<>(Collections.nCopies(n, 0));
        int[] rank = new int[n];
        for (int i = 0; i < n; i++) rank[suffixArray.get(i)] = i;

        int lcpLength = 0;
        for (int i = 0; i < n; i++) {
            if (rank[i] > 0) {
                int j = suffixArray.get(rank[i] - 1);
                while (i + lcpLength < n && j + lcpLength < n && s.charAt(i + lcpLength) == s.charAt(j + lcpLength)) {
                    lcpLength++;
                }
                lcpArray.set(rank[i], lcpLength);
                if (lcpLength > 0) lcpLength--;
            }
        }
        return lcpArray;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        
        List<Integer> suffixArray = computeSuffixArray(input);
        List<Integer> lcpArray = computeLCPArray(input, suffixArray);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            output.append(suffixArray.get(i) + 1).append(" ");
        }
        output.append("\nx ");
        for (int i = 1; i < input.length(); i++) {
            output.append(lcpArray.get(i)).append(" ");
        }
        System.out.print(output.toString());
    }
}