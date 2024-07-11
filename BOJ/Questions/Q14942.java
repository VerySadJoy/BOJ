//Question No: 14942
//Title: 개미
//Tier: Platinum V
import java.util.*;
import java.io.*;

public class Main {
    private static int numOfNodes;
    private static int[] energyLevels;
    private static List<List<int[]>> adjacencyList = new ArrayList<>();
    private static boolean[] visited;
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer tokenizer;
    private static int[] distances, previousNodes;

    public static void main(String[] args) throws IOException {
        numOfNodes = Integer.parseInt(bufferedReader.readLine());
        energyLevels = new int[numOfNodes + 1];
        distances = new int[numOfNodes + 1];
        previousNodes = new int[numOfNodes + 1];
        visited = new boolean[numOfNodes + 1];

        Arrays.fill(distances, Integer.MAX_VALUE);
        distances[1] = 0;

        for (int i = 0; i <= numOfNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 1; i <= numOfNodes; i++) {
            energyLevels[i] = Integer.parseInt(bufferedReader.readLine());
        }

        for (int i = 0; i < numOfNodes - 1; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int node1 = Integer.parseInt(tokenizer.nextToken());
            int node2 = Integer.parseInt(tokenizer.nextToken());
            int distance = Integer.parseInt(tokenizer.nextToken());

            adjacencyList.get(node1).add(new int[]{node2, distance});
            adjacencyList.get(node2).add(new int[]{node1, distance});
        }

        performDijkstra(1);

        for (int i = 1; i <= numOfNodes; i++) {
            int energy = energyLevels[i];
            int currentNode = i;

            while (energy >= 0) {
                int nextNode = previousNodes[currentNode];

                if (currentNode == 1) {
                    System.out.println(1);
                    break;
                }

                boolean found = false;
                for (int[] edge : adjacencyList.get(currentNode)) {
                    if (edge[0] == nextNode) {
                        if (edge[1] > energy) {
                            System.out.println(currentNode);
                            found = true;
                            break;
                        }

                        energy -= edge[1];
                    }
                }

                if (found) {
                    break;
                }

                currentNode = nextNode;
            }
        }
    }

    public static void performDijkstra(int startNode) {
        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));

        priorityQueue.add(new int[]{startNode, 0});
        visited[startNode] = true;

        while (!priorityQueue.isEmpty()) {
            int[] current = priorityQueue.poll();
            int currentNode = current[0];
            int currentEnergy = current[1];

            for (int[] neighbor : adjacencyList.get(currentNode)) {
                int nextNode = neighbor[0];
                int nextEnergy = neighbor[1];

                if (visited[nextNode]) continue;
                if (distances[currentNode] + nextEnergy >= distances[nextNode]) continue;

                distances[nextNode] = distances[currentNode] + nextEnergy;
                priorityQueue.add(new int[]{nextNode, nextEnergy});
                previousNodes[nextNode] = currentNode;
                visited[nextNode] = true;
            }
        }
    }
}
