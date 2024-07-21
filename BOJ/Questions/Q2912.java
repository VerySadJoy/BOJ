//Question No: 2912
//Title: 백설공주와 난쟁이
//Tier: Platinum II
import java.util.*;
import java.io.*;

public class Main {
    static int totalDwarfs, colors, lo, hi;
    static int[] dwarfColors, hatCount;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        totalDwarfs = Integer.parseInt(tokenizer.nextToken());
        colors = Integer.parseInt(tokenizer.nextToken());

        dwarfColors = new int[totalDwarfs + 1];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= totalDwarfs; i++) dwarfColors[i] = Integer.parseInt(tokenizer.nextToken());

        int numQueries = Integer.parseInt(reader.readLine());
        int[][] queries = new int[numQueries][3];

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numQueries; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            queries[i][0] = start;
            queries[i][1] = end;
            queries[i][2] = i;
        }

        Arrays.sort(queries, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                int sqrtN = (int) Math.sqrt(totalDwarfs);
                int bucket1 = o1[1] / sqrtN;
                int bucket2 = o2[1] / sqrtN;
                if (bucket1 == bucket2) return Integer.compare(o1[0], o2[0]);
                else return Integer.compare(bucket1, bucket2);
            }
        });

        hatCount = new int[10001];
        lo = 1; hi = 0;
        String[] results = new String[numQueries];
        for (int i = 0; i < numQueries; i++) {
            int[] query = queries[i];
            int result = findMajorityColor(query[0], query[1]);
            if (result == 0) results[query[2]] = "no";
            else results[query[2]] = "yes " + result;
        }
        for (String result : results) {
            output.append(result).append("\n");
        }
        System.out.print(output);
    }

    static int findMajorityColor(int start, int end) {
        int length = end - start + 1;
        while (lo < start) --hatCount[dwarfColors[lo++]];
        while (lo > start) ++hatCount[dwarfColors[--lo]];
        while (hi < end) ++hatCount[dwarfColors[++hi]];
        while (hi > end) --hatCount[dwarfColors[hi--]];
        for (int i = 1; i <= colors; i++) {
            if (hatCount[i] > length / 2) return i;
        }
        return 0;
    }
}
