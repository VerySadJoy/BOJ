//Question No: 13511
//Title: 트리와 쿼리 2
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {

    static class Node {
        int to, cost;

        Node(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static int n, maxHeight;
    static List<Node>[] tree;
    static int[][] parent;
    static int[] depth;
    static long[] cost;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        n = Integer.parseInt(reader.readLine());
        maxHeight = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;

        tree = new ArrayList[n + 1];
        parent = new int[n + 1][maxHeight];
        depth = new int[n + 1];
        cost = new long[n + 1];

        for (int i = 1; i <= n; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int w = Integer.parseInt(tokenizer.nextToken());
            tree[u].add(new Node(v, w));
            tree[v].add(new Node(u, w));
        }

        init(1, 0, -1);
        preprocess();

        StringBuilder result = new StringBuilder();
        int queryCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < queryCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(tokenizer.nextToken());
            int u = Integer.parseInt(tokenizer.nextToken());
            int v = Integer.parseInt(tokenizer.nextToken());
            int lca = findLCA(u, v);

            if (type == 1) {
                result.append(cost[u] + cost[v] - 2 * cost[lca]).append("\n");
            } else {
                int k = Integer.parseInt(tokenizer.nextToken());
                result.append(findKthNode(u, v, lca, k)).append("\n");
            }
        }
        System.out.print(result);
    }

    static void init(int current, int height, int parentNode) {
        depth[current] = height;
        for (Node next : tree[current]) {
            if (next.to != parentNode) {
                cost[next.to] = cost[current] + next.cost;
                parent[next.to][0] = current;
                init(next.to, height + 1, current);
            }
        }
    }

    static void preprocess() {
        for (int i = 1; i < maxHeight; i++) {
            for (int node = 1; node <= n; node++) {
                parent[node][i] = parent[parent[node][i - 1]][i - 1];
            }
        }
    }

    static int findLCA(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        for (int i = maxHeight - 1; i >= 0; i--) {
            if (depth[u] - depth[v] >= (1 << i)) {
                u = parent[u][i];
            }
        }

        if (u == v) return u;

        for (int i = maxHeight - 1; i >= 0; i--) {
            if (parent[u][i] != parent[v][i]) {
                u = parent[u][i];
                v = parent[v][i];
            }
        }
        return parent[u][0];
    }

    static int findKthNode(int u, int v, int lca, int k) {
        int distanceFromU = depth[u] - depth[lca] + 1;

        if (k == distanceFromU) return lca;

        int node = (k < distanceFromU) ? u : v;
        int steps = (k < distanceFromU) ? k - 1 : depth[u] + depth[v] - 2 * depth[lca] - k + 1;

        for (int i = maxHeight - 1; i >= 0; i--) {
            if ((steps & (1 << i)) > 0) {
                node = parent[node][i];
            }
        }
        return node;
    }
}