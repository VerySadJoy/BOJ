//Question No: 2015
//Title: 수들의 합 4
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] prefixSums;
    static Map<Integer, Long> sumCountMap = new HashMap<>();
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        prefixSums = new int[N + 1];

        long totalCount = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            prefixSums[i] = Integer.parseInt(st.nextToken()) + prefixSums[i - 1];
            if (prefixSums[i] == K) {
                totalCount++;
            }
            if (sumCountMap.containsKey(prefixSums[i] - K))
                totalCount += sumCountMap.get(prefixSums[i] - K);
            sumCountMap.put(prefixSums[i], sumCountMap.getOrDefault(prefixSums[i], 0L) + 1);
        }

        System.out.println(totalCount);
    }
}
