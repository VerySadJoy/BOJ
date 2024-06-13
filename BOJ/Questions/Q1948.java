//Question No: 1948
//Title: 임계경로
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int numNodes = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int numEdges = Integer.parseInt(tokenizer.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        ArrayList<ArrayList<Edge>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= numNodes; i++) {
            graph.add(new ArrayList<Edge>());
            reverseGraph.add(new ArrayList<Edge>());
        }

        int[] inDegree = new int[numNodes + 1];
        int[] longestPath = new int[numNodes + 1];

        for (int i = 0; i < numEdges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int from = Integer.parseInt(tokenizer.nextToken());
            int to = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            graph.get(from).add(new Edge(to, weight));
            inDegree[to]++;
            reverseGraph.get(to).add(new Edge(from, weight));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        int startNode = Integer.parseInt(tokenizer.nextToken());
        int endNode = Integer.parseInt(tokenizer.nextToken());

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(startNode);
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (Edge edge : graph.get(currentNode)) {
                inDegree[edge.toNode]--;
                longestPath[edge.toNode] = Math.max(longestPath[edge.toNode], longestPath[currentNode] + edge.weight);
                if (inDegree[edge.toNode] == 0) {
                    queue.offer(edge.toNode);
                }
            }
        }
        queue.offer(endNode);
        int criticalPathCount = 0;
        boolean[] visited = new boolean[numNodes + 1];
        visited[endNode] = true;
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (Edge edge : reverseGraph.get(currentNode)) {
                if (longestPath[currentNode] == longestPath[edge.toNode] + edge.weight) {
                    criticalPathCount++;
                    if (!visited[edge.toNode]) {
                        queue.offer(edge.toNode);
                        visited[edge.toNode] = true;
                    }
                }
            }
        }

        System.out.println(longestPath[endNode]);
        System.out.println(criticalPathCount);
    }

    static class Edge {
        int toNode;
        int weight;

        public Edge(int toNode, int weight) {
            this.toNode = toNode;
            this.weight = weight;
        }
    }
}
