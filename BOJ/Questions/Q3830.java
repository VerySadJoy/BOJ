//Question No: 3830
//Title: 교수님은 기다리지 않는다
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX = 100001;
    private static int numberOfNodes, numberOfQueries;
    private static int[] parent;
    private static int[] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer;
        StringBuilder result = new StringBuilder();

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            numberOfNodes = Integer.parseInt(tokenizer.nextToken());
            numberOfQueries = Integer.parseInt(tokenizer.nextToken());
            
            if (numberOfNodes == 0 && numberOfQueries == 0) {
                break;
            }
            
            init();

            while (numberOfQueries-- > 0) {
                tokenizer = new StringTokenizer(reader.readLine());
                char command = tokenizer.nextToken().charAt(0);
                if (command == '!') {
                    int nodeA = Integer.parseInt(tokenizer.nextToken());
                    int nodeB = Integer.parseInt(tokenizer.nextToken());
                    int weightDifference = Integer.parseInt(tokenizer.nextToken());
                    union(nodeA, nodeB, weightDifference);
                } else if (command == '?') {
                    int nodeA = Integer.parseInt(tokenizer.nextToken());
                    int nodeB = Integer.parseInt(tokenizer.nextToken());
                    int rootA = find(nodeA);
                    int rootB = find(nodeB);
                    if (rootA == rootB) {
                        result.append(distance[nodeB] - distance[nodeA]).append("\n");
                    } else {
                        result.append("UNKNOWN\n");
                    }
                }
            }
        }
        
        System.out.print(result.toString());
        reader.close();
    }

    private static void init() {
        parent = new int[numberOfNodes + 1];
        distance = new int[numberOfNodes + 1];
        for (int i = 1; i <= numberOfNodes; i++) {
            parent[i] = i;
            distance[i] = 0;
        }
    }

    private static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        int root = find(parent[node]);
        distance[node] += distance[parent[node]];
        return parent[node] = root;
    }

    private static void union(int nodeA, int nodeB, int weightDifference) {
        int rootA = find(nodeA);
        int rootB = find(nodeB);
        if (rootA != rootB) {
            distance[rootB] = distance[nodeA] + weightDifference - distance[nodeB];
            parent[rootB] = rootA;
        }
    }
}
