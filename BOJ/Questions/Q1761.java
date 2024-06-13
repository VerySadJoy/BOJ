//Question No: 1761
//Title: 정점들의 거리
//Tier: Platinum V
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    static int n, height;
    static List<Node>[] adjacencyList;
    static int[][] dp;
    static int[] distance;
    static int[] depth;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        adjacencyList = createAdjacencyList(n);

        readEdges(reader);

        height = calculateTreeHeight();
        initializeArrays(n);

        preprocess(1, 1, 0);
        fillParents();

        processQueries(reader);
        System.out.println(output.toString());
    }

    static List<Node>[] createAdjacencyList(int size) {
        List<Node>[] list = new ArrayList[size + 1];
        for (int i = 0; i <= size; i++) {
            list[i] = new ArrayList<>();
        }
        return list;
    }

    static void readEdges(BufferedReader reader) throws IOException {
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            adjacencyList[from].add(new Node(to, weight));
            adjacencyList[to].add(new Node(from, weight));
        }
    }

    static int calculateTreeHeight() {
        return (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
    }

    static void initializeArrays(int size) {
        depth = new int[size + 1];
        distance = new int[size + 1];
        dp = new int[size + 1][height];
    }

    static void preprocess(int current, int currentHeight, int parent) {
        depth[current] = currentHeight;
        for (Node neighbor : adjacencyList[current]) {
            if (neighbor.to != parent) {
                distance[neighbor.to] = distance[current] + neighbor.weight;
                preprocess(neighbor.to, currentHeight + 1, current);
                dp[neighbor.to][0] = current;
            }
        }
    }

    static void fillParents() {
        for (int i = 1; i < height; i++) {
            for (int j = 1; j <= n; j++) {
                dp[j][i] = dp[dp[j][i - 1]][i - 1];
            }
        }
    }

    static void processQueries(BufferedReader reader) throws IOException {
        int queryCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < queryCount; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());

            int lca = findLCA(nodeA, nodeB);
            int distanceBetweenNodes = distance[nodeA] + distance[nodeB] - 2 * distance[lca];
            output.append(distanceBetweenNodes).append("\n");
        }
    }

    static int findLCA(int nodeA, int nodeB) {
        if (depth[nodeA] < depth[nodeB]) {
            int temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;
        }

        for (int i = height - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[nodeA] - depth[nodeB]) {
                nodeA = dp[nodeA][i];
            }
        }

        if (nodeA == nodeB) return nodeA;

        for (int i = height - 1; i >= 0; i--) {
            if (dp[nodeA][i] != dp[nodeB][i]) {
                nodeA = dp[nodeA][i];
                nodeB = dp[nodeB][i];
            }
        }

        return dp[nodeA][0];
    }
}
