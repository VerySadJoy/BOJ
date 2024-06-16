//Question No: 3176
//Title: 도로 네트워크
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int to;
        int distance;

        public Edge(int to, int distance) {
            this.to = to;
            this.distance = distance;
        }
    }

    static int numberOfNodes;
    static int treeHeight;
    static List<Edge>[] adjacencyList;
    static int[][] parent, minRoad, maxRoad;
    static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;

        numberOfNodes = Integer.parseInt(br.readLine());
        depth = new int[numberOfNodes + 1];
        adjacencyList = new ArrayList[numberOfNodes + 1];

        for (int i = 1; i <= numberOfNodes; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        treeHeight = calculateTreeHeight();

        parent = new int[numberOfNodes + 1][treeHeight];
        minRoad = new int[numberOfNodes + 1][treeHeight];
        maxRoad = new int[numberOfNodes + 1][treeHeight];

        boolean[] isRoot = new boolean[numberOfNodes + 1];

        for (int i = 0; i < numberOfNodes - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeA = Integer.parseInt(st.nextToken());
            int nodeB = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());

            adjacencyList[nodeA].add(new Edge(nodeB, distance));
            adjacencyList[nodeB].add(new Edge(nodeA, distance));
            isRoot[nodeB] = true; // Mark nodeB as a child node
        }

        int rootIndex = 0;
        for (int i = 1; i <= numberOfNodes; i++) {
            if (!isRoot[i]) {
                rootIndex = i;
                break;
            }
        }

        initializeTree(rootIndex, 1, 0);
        fillParents();

        StringBuilder sb = new StringBuilder();
        int queries = Integer.parseInt(br.readLine());
        for (int i = 0; i < queries; i++) {
            st = new StringTokenizer(br.readLine());
            int nodeD = Integer.parseInt(st.nextToken());
            int nodeE = Integer.parseInt(st.nextToken());

            int[] result = findLCA(nodeD, nodeE);
            sb.append(result[0]).append(" ").append(result[1]);
            if (i != queries - 1) {
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static int calculateTreeHeight() {
        return (int) Math.ceil(Math.log(numberOfNodes) / Math.log(2)) + 1;
    }

    static void fillParents() {
        for (int i = 1; i < treeHeight; i++) {
            for (int j = 1; j <= numberOfNodes; j++) {
                parent[j][i] = parent[parent[j][i - 1]][i - 1];

                maxRoad[j][i] = Math.max(maxRoad[j][i - 1], maxRoad[parent[j][i - 1]][i - 1]);
                minRoad[j][i] = Math.min(minRoad[j][i - 1], minRoad[parent[j][i - 1]][i - 1]);
            }
        }
    }

    static void initializeTree(int current, int height, int parentIndex) {
        depth[current] = height;
        for (Edge next : adjacencyList[current]) {
            if (next.to != parentIndex) {
                initializeTree(next.to, height + 1, current);
                minRoad[next.to][0] = next.distance;
                maxRoad[next.to][0] = next.distance;
                parent[next.to][0] = current;
            }
        }
    }

    static int[] findLCA(int nodeA, int nodeB) {
        int depthA = depth[nodeA];
        int depthB = depth[nodeB];

        if (depthA < depthB) {
            int temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;
        }

        int minDistance = Integer.MAX_VALUE;
        int maxDistance = Integer.MIN_VALUE;

        for (int i = treeHeight - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[nodeA] - depth[nodeB]) {
                minDistance = Math.min(minDistance, minRoad[nodeA][i]);
                maxDistance = Math.max(maxDistance, maxRoad[nodeA][i]);
                nodeA = parent[nodeA][i];
            }
        }

        if (nodeA == nodeB) {
            return new int[]{minDistance, maxDistance};
        }

        for (int i = treeHeight - 1; i >= 0; i--) {
            if (parent[nodeA][i] != parent[nodeB][i]) {
                minDistance = Math.min(minDistance, Math.min(minRoad[nodeA][i], minRoad[nodeB][i]));
                maxDistance = Math.max(maxDistance, Math.max(maxRoad[nodeA][i], maxRoad[nodeB][i]));
                nodeA = parent[nodeA][i];
                nodeB = parent[nodeB][i];
            }
        }

        minDistance = Math.min(minDistance, Math.min(minRoad[nodeA][0], minRoad[nodeB][0]));
        maxDistance = Math.max(maxDistance, Math.max(maxRoad[nodeA][0], maxRoad[nodeB][0]));

        return new int[]{minDistance, maxDistance};
    }
}
