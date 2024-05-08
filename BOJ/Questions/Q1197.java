//Question No: 1197
//Title: 최소 스패닝 트리
//Tier: Gold IV
import java.io.*;
import java.util.*;

class Main {
    static class Edge implements Comparable<Edge> {
        int start, end, weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Edge o) {
            return this.weight - o.weight;
        }
    }

    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        PriorityQueue<Edge> pq = new PriorityQueue<>();

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            pq.offer(new Edge(A, B, C));
        }

        parent = new int[V + 1];
        for (int i = 1; i <= V; i++) {
            parent[i] = i;
        }

        int answer = 0;
        while (!pq.isEmpty()) {
            Edge edge = pq.poll();
            int start = edge.start;
            int end = edge.end;
            int weight = edge.weight;

            int rootStart = find(start);
            int rootEnd = find(end);

            if (rootStart != rootEnd) {
                union(start, end);
                answer += weight;
            }
        }

        System.out.println(answer);
    }

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) {
            if (a < b) parent[b] = a;
            else parent[a] = b;
        }
    }
}
