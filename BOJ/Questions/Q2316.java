//Question No: 2316
//Title: 도시 왕복하기 2
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final int MAXN = 803;
    static int cityNum, pathNum, vertexNum;
    static int[][] capacity = new int[MAXN][MAXN];
    static int[][] flow = new int[MAXN][MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        cityNum = Integer.parseInt(st.nextToken());
        pathNum = Integer.parseInt(st.nextToken());

        vertexNum = (cityNum + 1) * 2;

        for (int i = 2; i < vertexNum; i += 2) {
            capacity[i][i + 1] = 1;
        }

        for (int i = 0; i < pathNum; ++i) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            int uIn = u * 2;
            int uOut = uIn + 1;
            int vIn = v * 2;
            int vOut = vIn + 1;

            capacity[uOut][vIn] = INF;
            capacity[vOut][uIn] = INF;
        }

        int sourceOut = (1 * 2) + 1;
        int sinkIn = (2 * 2);
        System.out.println(minimumCut(sourceOut, sinkIn));
    }

    static int minimumCut(int source, int sink) {
        int totalFlow = 0;

        while (true) {
            int[] parent = new int[vertexNum];
            Arrays.fill(parent, -1);
            Queue<Integer> queue = new LinkedList<>();
            parent[source] = source;
            queue.add(source);

            while (!queue.isEmpty() && parent[sink] == -1) {
                int u = queue.poll();

                for (int v = 2; v < vertexNum; ++v) {
                    if (capacity[u][v] - flow[u][v] > 0 && parent[v] == -1) {
                        queue.add(v);
                        parent[v] = u;
                    }
                }
            }

            if (parent[sink] == -1) break;

            int amount = INF;
            for (int p = sink; p != source; p = parent[p]) {
                amount = Math.min(capacity[parent[p]][p] - flow[parent[p]][p], amount);
            }

            for (int p = sink; p != source; p = parent[p]) {
                flow[parent[p]][p] += amount;
                flow[p][parent[p]] -= amount;
            }

            totalFlow += amount;
        }
        return totalFlow;
    }
}
