//Question No: 3584
//Title: 가장 가까운 공통 조상
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] tree;
    static int[] parent, depth;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCaseCount; t++) {
            int nodeCount = Integer.parseInt(reader.readLine());

            parent = new int[nodeCount + 1];
            depth = new int[nodeCount + 1];
            tree = new ArrayList[nodeCount + 1];
            for (int i = 1; i <= nodeCount; i++) {
                tree[i] = new ArrayList<>();
            }

            boolean[] isRoot = new boolean[nodeCount + 1];
            Arrays.fill(isRoot, true);

            for (int i = 0; i < nodeCount - 1; i++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int parentNode = Integer.parseInt(tokenizer.nextToken());
                int childNode = Integer.parseInt(tokenizer.nextToken());
                tree[parentNode].add(childNode);
                isRoot[childNode] = false;
            }

            int root = 0;
            for (int i = 1; i <= nodeCount; i++) {
                if (isRoot[i]) {
                    root = i;
                    break;
                }
            }

            initialize(root, 1, 0);

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());
            System.out.println(findLCA(nodeA, nodeB));
        }
    }

    static void initialize(int current, int height, int parentNode) {
        depth[current] = height;
        parent[current] = parentNode;
        for (int next : tree[current]) {
            if (next != parentNode) {
                initialize(next, height + 1, current);
            }
        }
    }

    static int findLCA(int nodeA, int nodeB) {
        while (depth[nodeA] > depth[nodeB]) {
            nodeA = parent[nodeA];
        }

        while (depth[nodeB] > depth[nodeA]) {
            nodeB = parent[nodeB];
        }

        while (nodeA != nodeB) {
            nodeA = parent[nodeA];
            nodeB = parent[nodeB];
        }

        return nodeA;
    }
}