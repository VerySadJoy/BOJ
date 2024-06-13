//Question No: 15681
//Title: 트리와 쿼리
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static ArrayList<Integer>[] adjacencyList;
    static boolean[] visited;
    static int[] subtreeSize;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");

        int numberOfNodes = Integer.parseInt(tokenizer.nextToken());
        int root = Integer.parseInt(tokenizer.nextToken());
        int numberOfQueries = Integer.parseInt(tokenizer.nextToken());

        adjacencyList = new ArrayList[numberOfNodes + 1];
        subtreeSize = new int[numberOfNodes + 1];
        visited = new boolean[numberOfNodes + 1];

        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i < numberOfNodes; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            int nodeU = Integer.parseInt(tokenizer.nextToken());
            int nodeV = Integer.parseInt(tokenizer.nextToken());

            adjacencyList[nodeU].add(nodeV);
            adjacencyList[nodeV].add(nodeU);
        }

        calculateSubtreeSize(root);

        StringBuilder result = new StringBuilder();
        while (numberOfQueries-- > 0) {
            int queryNode = Integer.parseInt(bufferedReader.readLine());
            result.append(subtreeSize[queryNode]).append("\n");
        }

        System.out.println(result);
    }

    public static int calculateSubtreeSize(int currentNode) {
        if (subtreeSize[currentNode] != 0) return subtreeSize[currentNode];
        visited[currentNode] = true;
        int count = 1;

        for (int adjacentNode : adjacencyList[currentNode]) {
            if (visited[adjacentNode]) continue;
            count += calculateSubtreeSize(adjacentNode);
        }

        subtreeSize[currentNode] = count;
        return subtreeSize[currentNode];
    }
}
