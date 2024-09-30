//Question No: 24480
//Title: 알고리즘 수업 - 깊이 우선 탐색 2
//Tier: Silver II
import java.io.*;
import java.util.*;

public class Main {
    static int totalNodes, totalEdges, startNode, visitCount = 1;
    static int[] visitOrder;
    static boolean[] visitedNodes;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine(), " ");
        totalNodes = Integer.parseInt(tokenizer.nextToken());
        totalEdges = Integer.parseInt(tokenizer.nextToken());
        startNode = Integer.parseInt(tokenizer.nextToken());

        visitOrder = new int[totalNodes + 1];
        visitedNodes = new boolean[totalNodes + 1];
        for (int i = 0; i <= totalNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < totalEdges; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine(), " ");
            int nodeU = Integer.parseInt(tokenizer.nextToken());
            int nodeV = Integer.parseInt(tokenizer.nextToken());
            graph.get(nodeU).add(nodeV);
            graph.get(nodeV).add(nodeU);
        }

        performDFS(startNode);

        for (int i = 1; i <= totalNodes; i++) {
            outputWriter.write(visitOrder[i] + "\n");
        }

        outputWriter.flush();
        outputWriter.close();
        inputReader.close();
    }

    static void performDFS(int currentNode) {
        visitedNodes[currentNode] = true;
        visitOrder[currentNode] = visitCount++;
        Collections.sort(graph.get(currentNode), Collections.reverseOrder());
        for (Integer neighborNode : graph.get(currentNode)) {
            if (!visitedNodes[neighborNode]) {
                performDFS(neighborNode);
            }
        }
    }
}