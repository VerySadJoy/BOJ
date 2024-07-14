//Question No: 1420
//Title: 학교 가지마!
//Tier: Platinum II
import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int to, capacity, flow;
        Edge reverse;
        
        Edge(int to, int capacity) {
            this.to = to;
            this.capacity = capacity;
            this.flow = 0;
            this.reverse = null;
        }

        int residual() {
            return capacity - flow;
        }
    }

    static final int[] dr = {0, 0, 1, -1};
    static final int[] dc = {1, -1, 0, 0};
    static int rows, cols, source, sink;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());
        char[][] grid = new char[rows][cols];
        
        for (int i = 0; i < rows; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        List<Edge>[] graph = new ArrayList[2 * rows * cols];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '#') continue;
                int currentOut = 2 * (i * cols + j) + 1;
                int currentIn = 2 * (i * cols + j);

                if (grid[i][j] == 'K') {
                    source = currentOut;
                } else if (grid[i][j] == 'H') {
                    sink = currentIn;
                }

                for (int dir = 0; dir < 4; dir++) {
                    int ni = i + dr[dir];
                    int nj = j + dc[dir];
                    if (ni >= 0 && ni < rows && nj >= 0 && nj < cols && grid[ni][nj] != '#') {
                        int neighborIn = 2 * (ni * cols + nj);
                        addEdge(graph, currentOut, neighborIn);
                    }
                }
                addEdge(graph, currentIn, currentOut);
            }
        }

        if (Math.abs(source / 2 / cols - sink / 2 / cols) + Math.abs(source / 2 % cols - sink / 2 % cols) == 1) {
            System.out.println("-1");
        } else {
            System.out.println(maxFlow(graph));
        }
    }

    private static void addEdge(List<Edge>[] graph, int from, int to) {
        Edge e1 = new Edge(to, 1);
        Edge e2 = new Edge(from, 0);
        e1.reverse = e2;
        e2.reverse = e1;
        graph[from].add(e1);
        graph[to].add(e2);
    }

    private static int maxFlow(List<Edge>[] graph) {
        int maxFlow = 0;

        while (true) {
            Edge[] prev = new Edge[graph.length];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(source);

            while (!queue.isEmpty() && prev[sink] == null) {
                int curr = queue.poll();
                for (Edge edge : graph[curr]) {
                    if (prev[edge.to] == null && edge.to != source && edge.residual() > 0) {
                        prev[edge.to] = edge;
                        queue.add(edge.to);
                    }
                }
            }

            if (prev[sink] == null) break;

            int flow = 1;
            for (int cur = sink; cur != source; cur = prev[cur].reverse.to) {
                prev[cur].flow += flow;
                prev[cur].reverse.flow -= flow;
            }
            maxFlow += flow;
        }

        return maxFlow;
    }
}
