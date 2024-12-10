//Question No: 4803
//Title: 트리
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph;
    static boolean[] visited;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int testCase = 1;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int nodeCount = Integer.parseInt(tokenizer.nextToken());
            int edgeCount = Integer.parseInt(tokenizer.nextToken());

            if (nodeCount == 0 && edgeCount == 0) break;

            graph = new ArrayList<>();
            for (int i = 0; i <= nodeCount; i++) {
                graph.add(new ArrayList<>());
            }

            visited = new boolean[nodeCount + 1];

            for (int i = 0; i < edgeCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine(), " ");
                int nodeA = Integer.parseInt(tokenizer.nextToken());
                int nodeB = Integer.parseInt(tokenizer.nextToken());

                graph.get(nodeA).add(nodeB);
                graph.get(nodeB).add(nodeA);
            }

            int treeCount = 0;
            for (int i = 1; i <= nodeCount; i++) {
                if (!visited[i]) {
                    treeCount += isTree(i);
                }
            }

            writer.write("Case " + testCase + ": ");
            if (treeCount > 1) {
                writer.write("A forest of " + treeCount + " trees.");
            } else if (treeCount == 1) {
                writer.write("There is one tree.");
            } else {
                writer.write("No trees.");
            }
            writer.write("\n");

            testCase++;
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    private static int isTree(int root) {
        Queue<Integer> queue = new LinkedList<>();
        int nodeCount = 0;
        int edgeCount = 0;

        queue.add(root);

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            if (visited[currentNode]) continue;
            visited[currentNode] = true;
            nodeCount++;

            for (int neighbor : graph.get(currentNode)) {
                edgeCount++;
                if (!visited[neighbor]) {
                    queue.add(neighbor);
                }
            }
        }

        return (edgeCount / 2) + 1 == nodeCount ? 1 : 0;
    }
}