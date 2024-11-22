//Question No: 5934
//Title: Visiting Cows
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    private static List<List<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfNodes = Integer.parseInt(reader.readLine());

        for (int i = 0; i <= numberOfNodes; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i < numberOfNodes; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int nodeA = Integer.parseInt(tokenizer.nextToken());
            int nodeB = Integer.parseInt(tokenizer.nextToken());
            graph.get(nodeA).add(nodeB);
            graph.get(nodeB).add(nodeA);
        }

        int[] result = depthFirstSearch(1, -1);
        System.out.println(Math.max(result[0], result[1]));
    }

    private static int[] depthFirstSearch(int currentNode, int parent) {
        int includingCurrent = 1;
        int excludingCurrent = 0;

        for (int neighbor : graph.get(currentNode)) {
            if (neighbor == parent) {
                continue;
            }

            int[] childResult = depthFirstSearch(neighbor, currentNode);
            excludingCurrent += Math.max(childResult[0], childResult[1]);
            includingCurrent += childResult[1];
        }

        return new int[]{includingCurrent, excludingCurrent};
    }
}