//Question No: 13161
//Title: 분단의 슬픔
//Tier: Platinum I
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_V = 502;
    static final int SOURCE = 500;
    static final int SINK = 501;
    static final int INF = Integer.MAX_VALUE;

    static int[][] capacity = new int[MAX_V][MAX_V];
    static int[][] flow = new int[MAX_V][MAX_V];
    static int[] level = new int[MAX_V];
    static int[] work = new int[MAX_V];
    static List<Integer>[] adj = new ArrayList[MAX_V];

    static {
        for (int i = 0; i < MAX_V; i++) {
            adj[i] = new ArrayList<>();
        }
    }

    static boolean bfs() {
        Arrays.fill(level, -1);
        level[SOURCE] = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(SOURCE);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adj[current]) {
                if (level[next] == -1 && capacity[current][next] > flow[current][next]) {
                    level[next] = level[current] + 1;
                    queue.add(next);
                }
            }
        }
        return level[SINK] != -1;
    }

    static int dfs(int current, int destination, int currentFlow) {
        if (current == destination) return currentFlow;
        for (int i = work[current]; i < adj[current].size(); i++, work[current]++) {
            int next = adj[current].get(i);
            if (level[next] == level[current] + 1 && capacity[current][next] - flow[current][next] > 0) {
                int nextFlow = dfs(next, destination, Math.min(currentFlow, capacity[current][next] - flow[current][next]));
                if (nextFlow > 0) {
                    flow[current][next] += nextFlow;
                    flow[next][current] -= nextFlow;
                    return nextFlow;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int nodes = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < nodes; i++) {
            int nodeType = Integer.parseInt(st.nextToken());
            if (nodeType == 1) {
                capacity[SOURCE][i] = INF;
                adj[i].add(SOURCE);
                adj[SOURCE].add(i);
            } else if (nodeType == 2) {
                capacity[i][SINK] = INF;
                adj[i].add(SINK);
                adj[SINK].add(i);
            }
        }
        for (int i = 0; i < nodes; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < nodes; j++) {
                capacity[i][j] = Integer.parseInt(st.nextToken());
                if (i != j) adj[i].add(j);
            }
        }
        int maxFlow = 0;
        while (bfs()) {
            Arrays.fill(work, 0);
            int flowAmount;
            while ((flowAmount = dfs(SOURCE, SINK, INF)) > 0) {
                maxFlow += flowAmount;
            }
        }
        bw.write(maxFlow + "\n");
        boolean[] visited = new boolean[MAX_V];
        Queue<Integer> queue = new LinkedList<>();
        visited[SOURCE] = true;
        queue.add(SOURCE);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int next : adj[current]) {
                if (!visited[next] && capacity[current][next] - flow[current][next] > 0) {
                    visited[next] = true;
                    queue.add(next);
                }
            }
        }
        for (int i = 0; i < nodes; i++) {
            if (visited[i]) bw.write((i + 1) + " ");
        }
        bw.write("\n");
        for (int i = 0; i < nodes; i++) {
            if (!visited[i]) bw.write((i + 1) + " ");
        }
        bw.write("\n");
        bw.flush();
        br.close();
        bw.close();
    }
}