//Question No: 4386
//Title: 별자리 만들기
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node1, node2;
    double weight;

    public Edge(int node1, int node2, double weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}

class Node {
    double x, y;

    public Node(double x, double y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N;
    static int[] parent;
    static ArrayList<Node> nodes = new ArrayList<>();
    static PriorityQueue<Edge> edges = new PriorityQueue<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        parent = new int[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            nodes.add(new Node(x, y));
            parent[i] = i;
        }

        for (int i = 0; i < N - 1; i++) {
            Node node1 = nodes.get(i);
            for (int j = i + 1; j < N; j++) {
                Node node2 = nodes.get(j);
                double weight = Math.sqrt(Math.pow(node1.x - node2.x, 2) + Math.pow(node1.y - node2.y, 2));
                edges.add(new Edge(i, j, weight));
            }
        }

        double sum = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            int node1 = edge.node1;
            int node2 = edge.node2;
            double weight = edge.weight;
            if (find(node1) != find(node2)) {
                union(node1, node2);
                sum += weight;
            }
        }

        System.out.printf("%.2f", sum);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            parent[rootB] = rootA;
        }
    }
}
