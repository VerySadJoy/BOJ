//Question No: 17412
//Title: 도시 왕복하기 1
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {
    private static final int SOURCE = 1;
    private static final int SINK = 2;
    static int[][] capacity, flow;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p = Integer.parseInt(st.nextToken());
        
        capacity = new int[n + 1][n + 1];
        flow = new int[n + 1][n + 1];
        List<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) edges[i] = new ArrayList<>();
        
        while (p-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            capacity[a][b] = 1;
            edges[a].add(b);
            edges[b].add(a);
        }

        long maxFlow = 0;
        while (true) {
            int[] parent = new int[n + 1];
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new ArrayDeque<>();
            parent[SOURCE] = SOURCE;
            queue.add(SOURCE);

            while (!queue.isEmpty() && parent[SINK] == -1) {
                int current = queue.poll();
                for (int next : edges[current]) {
                    if (capacity[current][next] - flow[current][next] > 0 && parent[next] == -1) {
                        queue.add(next);
                        parent[next] = current;
                    }
                }
            }
            if (parent[SINK] == -1) break;

            int minFlow = Integer.MAX_VALUE;
            for (int i = SINK; i != SOURCE; i = parent[i]) {
                minFlow = Math.min(minFlow, capacity[parent[i]][i] - flow[parent[i]][i]);
            }
            for (int i = SINK; i != SOURCE; i = parent[i]) {
                flow[parent[i]][i] += minFlow;
                flow[i][parent[i]] -= minFlow;
            }

            maxFlow += minFlow;
        }
        System.out.println(maxFlow);
    }
}