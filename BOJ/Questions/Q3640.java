//Question No: 3640
//Title: 제독
//Tier: Platinum II
import java.util.*;
import java.io.*;

class Edge {
    int next, flow, capacity, cost;
    Edge reverse;

    Edge(int next, int capacity, int cost) {
        this.next = next;
        this.capacity = capacity;
        this.cost = cost;
        this.flow = 0;
    }

    void addFlow(int flow) {
        this.flow += flow;
        this.reverse.flow -= flow;
    }

    int remainingCapacity() {
        return this.capacity - this.flow;
    }
}

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static final long LINF = Long.MAX_VALUE;
    static final int MOD = 1_000_000_007;
    static final int MAX_V = 2050;
    static final int SRC = MAX_V - 1, SINK = MAX_V - 2;

    static List<Edge>[] adj = new ArrayList[MAX_V];

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < MAX_V; i++) {
            adj[i] = new ArrayList<>();
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = br.readLine()) != null) {
            StringTokenizer st = new StringTokenizer(line);
            int vertexCount = Integer.parseInt(st.nextToken());
            int edgeCount = Integer.parseInt(st.nextToken());

            clearGraph();

            addEdge(SRC, 1, 2, 0);
            addEdge(vertexCount + vertexCount, SINK, 2, 0);

            for (int i = 1; i <= vertexCount; i++) {
                int cap = (i == 1 || i == vertexCount) ? 2 : 1;
                addEdge(i, i + vertexCount, cap, 0);
            }

            while (edgeCount-- > 0) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                addEdge(from + vertexCount, to, 1, cost);
            }

            long[] result = minCostMaxFlow(SRC, SINK);
            System.out.println(result[0]);
        }
    }

    static void clearGraph() {
        for (int i = 0; i < MAX_V; i++) {
            adj[i].clear();
        }
    }

    static void addEdge(int from, int to, int capacity, int cost) {
        Edge forward = new Edge(to, capacity, cost);
        Edge backward = new Edge(from, 0, -cost);
        forward.reverse = backward;
        backward.reverse = forward;
        adj[from].add(forward);
        adj[to].add(backward);
    }

    static long[] minCostMaxFlow(int source, int sink) {
        long cost = 0;
        int maxFlow = 0;
        int[] previousNode = new int[MAX_V];
        Edge[] path = new Edge[MAX_V];
        boolean[] inQueue = new boolean[MAX_V];
        int[] distance = new int[MAX_V];

        while (true) {
            Arrays.fill(previousNode, -1);
            Arrays.fill(path, null);
            Arrays.fill(inQueue, false);
            Arrays.fill(distance, INF);

            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);
            distance[source] = 0;

            while (!queue.isEmpty()) {
                int current = queue.poll();
                inQueue[current] = false;

                for (Edge edge : adj[current]) {
                    int next = edge.next;
                    if (edge.remainingCapacity() > 0 && distance[next] > distance[current] + edge.cost) {
                        distance[next] = distance[current] + edge.cost;
                        previousNode[next] = current;
                        path[next] = edge;
                        if (!inQueue[next]) {
                            queue.add(next);
                            inQueue[next] = true;
                        }
                    }
                }
            }

            if (previousNode[sink] == -1) {
                break;
            }

            int flow = INF;
            for (int node = sink; node != source; node = previousNode[node]) {
                flow = Math.min(flow, path[node].remainingCapacity());
            }

            for (int node = sink; node != source; node = previousNode[node]) {
                cost += (long) flow * path[node].cost;
                path[node].addFlow(flow);
            }

            maxFlow += flow;
        }

        return new long[]{cost, maxFlow};
    }
}