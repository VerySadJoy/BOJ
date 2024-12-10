//Question No: 16763
//Title: Fine Dining
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {
    static final int INF = (int) 1e9 + 5;
    static List<int[]>[] graph;
    static int[] dst1, dst2;

    public static void dijkstra(int[] dst, int start) {
        Arrays.fill(dst, INF);
        dst[start] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        pq.add(new int[]{0, start});
        while (!pq.isEmpty()) {
            int[] t = pq.poll();
            int dist = t[0];
            int current = t[1];
            if (dst[current] != dist) continue;
            for (int[] next : graph[current]) {
                int nextNode = next[0];
                int nextDist = next[1];
                if (dst[nextNode] > dst[current] + nextDist) {
                    dst[nextNode] = dst[current] + nextDist;
                    pq.add(new int[]{dst[nextNode], nextNode});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        graph = new ArrayList[n + 2];
        for (int i = 1; i <= n + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            int z = Integer.parseInt(tokenizer.nextToken());
            graph[x].add(new int[]{y, z});
            graph[y].add(new int[]{x, z});
        }

        dst1 = new int[n + 2];
        dst2 = new int[n + 2];
        dijkstra(dst1, n);

        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            graph[n + 1].add(new int[]{x, dst1[x] - y});
        }

        dijkstra(dst2, n + 1);

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < n; i++) {
            writer.write((dst1[i] >= dst2[i] ? 1 : 0) + "\n");
        }
        writer.flush();
        writer.close();
    }
}