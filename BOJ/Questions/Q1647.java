//Question No: 1647
//Title: 도시 분할 계획
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Edge {
        int from;
        int to;
        int cost;

        public Edge(int from, int to, int cost) {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Edge>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Edge(a, b, c));
            graph.get(b).add(new Edge(b, a, c));
        }

        boolean[] visited = new boolean[N + 1];
        PriorityQueue<Edge> pq = new PriorityQueue<>(Comparator.comparingInt(e -> e.cost));
        pq.addAll(graph.get(1));
        visited[1] = true;
        
        int minCost = 0;
        int maxCost = 0;
        int selectedEdges = 0;
        
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            if (visited[edge.to]) continue;
            visited[edge.to] = true;
            minCost += edge.cost;
            maxCost = Math.max(maxCost, edge.cost);
            selectedEdges++;
            
            if (selectedEdges == N - 1) break;
            
            for (Edge next : graph.get(edge.to)) {
                if (!visited[next.to]) {
                    pq.add(next);
                }
            }
        }

        System.out.println(minCost - maxCost);
    }
}
