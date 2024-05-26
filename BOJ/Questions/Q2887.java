//Question No: 2887
//Title: 행성 터널
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Edge implements Comparable<Edge> {
    int node1, node2, weight;

    public Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

class Node {
    int index, x, y, z;

    public Node(int index, int x, int y, int z) {
        this.index = index;
        this.x = x;
        this.y = y;
        this.z = z;
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
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            nodes.add(new Node(i, x, y, z));
            parent[i] = i;
        }
        for (int i = 0; i < 3; i++) {
            final int dim = i;
            nodes.sort(Comparator.comparingInt(node -> node.x));
            for (int j = 0; j < N - 1; j++) {
                edges.add(new Edge(nodes.get(j).index, nodes.get(j + 1).index, Math.abs(nodes.get(j).x - nodes.get(j + 1).x)));
            }
            nodes.sort(Comparator.comparingInt(node -> node.y));
            for (int j = 0; j < N - 1; j++) {
                edges.add(new Edge(nodes.get(j).index, nodes.get(j + 1).index, Math.abs(nodes.get(j).y - nodes.get(j + 1).y)));
            }
            nodes.sort(Comparator.comparingInt(node -> node.z));
            for (int j = 0; j < N - 1; j++) {
                edges.add(new Edge(nodes.get(j).index, nodes.get(j + 1).index, Math.abs(nodes.get(j).z - nodes.get(j + 1).z)));
            }
        }

        int sum = 0;
        while (!edges.isEmpty()) {
            Edge edge = edges.poll();
            int node1 = edge.node1;
            int node2 = edge.node2;
            int weight = edge.weight;
            if (find(node1) != find(node2)) {
                union(node1, node2);
                sum += weight;
            }
        }

        System.out.println(sum);
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
