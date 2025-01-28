//Question No: 5977
//Title: Mowing the Lawn
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static long[] psum, dp;
    static PriorityQueue<long[]> pq;
    static int n, k;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        k = Integer.parseInt(tokenizer.nextToken());

        psum = new long[n + 1];
        dp = new long[n + 1];
        pq = new PriorityQueue<>((a, b) -> Long.compare(b[0], a[0]));

        pq.offer(new long[]{0, 0});

        for (int i = 1; i <= n; i++) {
            long t = Long.parseLong(reader.readLine());
            psum[i] = psum[i - 1] + t;

            while (!pq.isEmpty() && pq.peek()[1] < i - k) {
                pq.poll();
            }

            dp[i] = psum[i] + pq.peek()[0];
            pq.offer(new long[]{dp[i - 1] - psum[i], i});

            dp[i] = Math.max(dp[i], dp[i - 1]);
        }

        System.out.println(dp[n]);
    }
}