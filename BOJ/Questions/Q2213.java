//Question No: 2213
//Title: 트리의 독립집합
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adjacencyList;
    static int[] weights;
    static int[][] dp;
    static boolean[] visited;
    static List<Integer> resultNodes;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int nodeCount = Integer.parseInt(reader.readLine());

        weights = new int[nodeCount + 1];
        adjacencyList = new ArrayList[nodeCount + 1];
        dp = new int[nodeCount + 1][2];
        visited = new boolean[nodeCount + 1];
        resultNodes = new ArrayList<>();

        for (int i = 0; i <= nodeCount; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= nodeCount; i++) {
            weights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < nodeCount - 1; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());
            adjacencyList[nodeA].add(nodeB);
            adjacencyList[nodeB].add(nodeA);
        }

        dfs(1);

        if (dp[1][1] > dp[1][0]) {
            System.out.println(dp[1][1]);
            traceSolution(1, 1);
        } else {
            System.out.println(dp[1][0]);
            traceSolution(1, 0);
        }

        Collections.sort(resultNodes);
        for (int node : resultNodes) {
            System.out.print(node + " ");
        }
    }

    static void dfs(int currentNode) {
        dp[currentNode][0] = 0;
        dp[currentNode][1] = weights[currentNode];

        visited[currentNode] = true;

        for (int neighbor : adjacencyList[currentNode]) {
            if (!visited[neighbor]) {
                dfs(neighbor);

                dp[currentNode][0] += Math.max(dp[neighbor][0], dp[neighbor][1]);
                dp[currentNode][1] += dp[neighbor][0];
            }
        }

        visited[currentNode] = false;
    }

    static void traceSolution(int currentNode, int include) {
        visited[currentNode] = true;

        if (include == 1) {
            resultNodes.add(currentNode);
            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    traceSolution(neighbor, 0);
                }
            }
        } else {
            for (int neighbor : adjacencyList[currentNode]) {
                if (!visited[neighbor]) {
                    if (dp[neighbor][1] > dp[neighbor][0]) {
                        traceSolution(neighbor, 1);
                    } else {
                        traceSolution(neighbor, 0);
                    }
                }
            }
        }

        visited[currentNode] = false;
    }
}