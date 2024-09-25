//Question No: 24444
//Title: 알고리즘 수업 - 너비 우선 탐색 1
//Tier: Silver II
import java.io.*;
import java.util.*;

public class Main {
    static int totalNodes, totalEdges;
    static List<List<Integer>> adjacencyList = new ArrayList<>();
    static int[] visitOrder;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());

        totalNodes = Integer.parseInt(tokenizer.nextToken());
        totalEdges = Integer.parseInt(tokenizer.nextToken());
        int startNode = Integer.parseInt(tokenizer.nextToken());

        visitOrder = new int[totalNodes + 1];
        for (int i = 0; i <= totalNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < totalEdges; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine());

            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());

            adjacencyList.get(nodeA).add(nodeB);
            adjacencyList.get(nodeB).add(nodeA);
        }

        for (int i = 1; i <= totalNodes; i++) {
            Collections.sort(adjacencyList.get(i));
        }

        performBFS(startNode);

        for (int i = 1; i <= totalNodes; i++) {
            System.out.println(visitOrder[i]);
        }
    }

    static void performBFS(int startNode) {
        Queue<Integer> queue = new LinkedList<>();
        int visitCount = 1;

        queue.offer(startNode);
        visitOrder[startNode] = visitCount++;

        while (!queue.isEmpty()) {
            int currentNode = queue.poll();

            for (int i = 0; i < adjacencyList.get(currentNode).size(); i++) {
                int nextNode = adjacencyList.get(currentNode).get(i);

                if (visitOrder[nextNode] != 0) {
                    continue;
                }

                queue.offer(nextNode);
                visitOrder[nextNode] = visitCount++;
            }
        }
    }
}