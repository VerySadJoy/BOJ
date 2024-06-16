//Question No: 5719
//Title: 거의 최단 경로
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        public int compareTo(Node o) {
            return Integer.compare(this.weight, o.weight);
        }
    }

    static final int INFINITY = Integer.MAX_VALUE;
    static int n, m;
    static int[] shortestPath;
    static boolean[][] excludedRoutes;
    static List<Node>[] graph;
    static List<Integer>[] excludedBy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String input;

        StringBuilder sb = new StringBuilder();
        while (!(input = br.readLine()).equals("0 0")) {
            st = new StringTokenizer(input);
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int destination = Integer.parseInt(st.nextToken());

            graph = new ArrayList[n];
            excludedBy = new ArrayList[n];
            shortestPath = new int[n];
            for (int i = 0; i < n; i++) {
                graph[i] = new ArrayList<>();
                excludedBy[i] = new ArrayList<>();
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                int cost = Integer.parseInt(st.nextToken());
                graph[u].add(new Node(v, cost));
            }

            excludedRoutes = new boolean[n][n];
            computeShortestPath(start);
            markExcludedRoutes(start, destination);
            computeShortestPath(start);

            int result = (shortestPath[destination] == INFINITY) ? -1 : shortestPath[destination];
            sb.append(result).append("\n");
        }
        System.out.print(sb);
    }

    static void initializeShortestPath() {
        Arrays.fill(shortestPath, INFINITY);
    }

    static void markExcludedRoutes(int start, int destination) {
        if (start == destination) return;
        for (int from : excludedBy[destination]) {
            if (!excludedRoutes[from][destination]) {
                excludedRoutes[from][destination] = true;
                markExcludedRoutes(start, from);
            }
        }
    }

    static void computeShortestPath(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        initializeShortestPath();
        shortestPath[start] = 0;
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            int current = node.to;
            int currentWeight = node.weight;

            if (currentWeight > shortestPath[current]) continue;

            for (Node next : graph[current]) {
                if (excludedRoutes[current][next.to]) continue;

                int newWeight = shortestPath[current] + next.weight;
                if (newWeight < shortestPath[next.to]) {
                    shortestPath[next.to] = newWeight;
                    excludedBy[next.to] = new ArrayList<>();
                    excludedBy[next.to].add(current);
                    pq.offer(new Node(next.to, newWeight));
                } else if (newWeight == shortestPath[next.to]) {
                    excludedBy[next.to].add(current);
                }
            }
        }
    }
}
