//Question No: 11438
//Title: LCA 2
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {
    private static int nodeCount, queryCount, maxLog;
    private static int[] depth;
    private static int[][] parent;
    private static ArrayList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        StringBuilder result = new StringBuilder();

        nodeCount = Integer.parseInt(reader.readLine());

        adjList = new ArrayList[nodeCount + 1];
        for (int i = 0; i <= nodeCount; i++) {
            adjList[i] = new ArrayList<>();
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());
            adjList[nodeA].add(nodeB);
            adjList[nodeB].add(nodeA);
        }

        maxLog = 0;
        int temp = 1;
        while (temp < nodeCount + 1) {
            temp <<= 1;
            maxLog++;
        }

        depth = new int[nodeCount + 1];
        parent = new int[nodeCount + 1][maxLog];

        computeDepthAndParents(1, 1);
        preprocessParents();

        queryCount = Integer.parseInt(reader.readLine());
        for (int i = 0; i < queryCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());
            result.append(findLCA(nodeA, nodeB)).append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    private static void computeDepthAndParents(int currentNode, int currentDepth) {
        depth[currentNode] = currentDepth;
        for (Integer nextNode : adjList[currentNode]) {
            if (depth[nextNode] == 0) {
                computeDepthAndParents(nextNode, currentDepth + 1);
                parent[nextNode][0] = currentNode;
            }
        }
    }

    private static void preprocessParents() {
        for (int i = 1; i < maxLog; i++) {
            for (int node = 1; node <= nodeCount; node++) {
                parent[node][i] = parent[parent[node][i - 1]][i - 1];
            }
        }
    }

    private static int findLCA(int nodeA, int nodeB) {
        if (depth[nodeA] < depth[nodeB]) {
            int temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;
        }

        for (int i = maxLog - 1; i >= 0; i--) {
            if (Math.pow(2, i) <= depth[nodeA] - depth[nodeB]) {
                nodeA = parent[nodeA][i];
            }
        }

        if (nodeA == nodeB) {
            return nodeA;
        }

        for (int i = maxLog - 1; i >= 0; i--) {
            if (parent[nodeA][i] != parent[nodeB][i]) {
                nodeA = parent[nodeA][i];
                nodeB = parent[nodeB][i];
            }
        }
        return parent[nodeA][0];
    }
}
