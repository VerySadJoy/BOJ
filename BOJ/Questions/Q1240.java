//Question No: 1240
//Title: 노드사이의 거리
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX_N = 100001;
    static List<Edge>[] graph;
    static boolean[] visited;
    
    static class Edge {
        int node;
        int length;
        
        Edge(int node, int length) {
            this.node = node;
            this.length = length;
        }
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());
        
        graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(tokenizer.nextToken());
            int n2 = Integer.parseInt(tokenizer.nextToken());
            int l = Integer.parseInt(tokenizer.nextToken());
            graph[n1].add(new Edge(n2, l));
            graph[n2].add(new Edge(n1, l));
        }
        
        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int n1 = Integer.parseInt(tokenizer.nextToken());
            int n2 = Integer.parseInt(tokenizer.nextToken());
            System.out.println(bfs(n1, n2));
        }
    }
    
    static int bfs(int start, int find) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{start, 0});
        visited = new boolean[graph.length];
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int v = current[0];
            int d = current[1];
            
            if (v == find) {
                return d;
            }
            
            for (Edge edge : graph[v]) {
                int i = edge.node;
                int l = edge.length;
                if (!visited[i]) {
                    visited[i] = true;
                    queue.add(new int[]{i, d + l});
                }
            }
        }
        
        return -1;
    }
}