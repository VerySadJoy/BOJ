//Question No: 24446
//Title: 알고리즘 수업 - 너비 우선 탐색 3
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int numberOfNodes, numberOfEdges, startNode;
    static List<Integer>[] adjacencyList;
    static int[] distance;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            
            numberOfNodes = Integer.parseInt(tokenizer.nextToken());
            numberOfEdges = Integer.parseInt(tokenizer.nextToken());
            startNode = Integer.parseInt(tokenizer.nextToken());
            
            adjacencyList = new ArrayList[numberOfNodes + 1];
            for (int i = 1; i <= numberOfNodes; i++) {
                adjacencyList[i] = new ArrayList<>();
            }
            
            for (int i = 0; i < numberOfEdges; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int node1 = Integer.parseInt(tokenizer.nextToken());
                int node2 = Integer.parseInt(tokenizer.nextToken());
                adjacencyList[node1].add(node2);
                adjacencyList[node2].add(node1);
            }
            
            solve();
        }
    }

    static void solve() {
        bfs();
        for (int i = 1; i <= numberOfNodes; i++) {
            System.out.println(distance[i]);
        }
    }

    static void bfs() {
        distance = new int[numberOfNodes + 1];
        Arrays.fill(distance, -1);
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        distance[startNode] = 0;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int neighbor : adjacencyList[currentNode]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[currentNode] + 1;
                    queue.offer(neighbor);
                }
            }
        }
    }
}