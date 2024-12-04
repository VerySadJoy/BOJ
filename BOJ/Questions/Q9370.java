//Question No: 9370
//Title: 미확인 도착지
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    static class Node implements Comparable<Node> {
        int destination, weight;

        public Node(int destination, int weight) {
            this.destination = destination;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node other) {
            return this.weight - other.weight;
        }
    }

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    private static final int INFINITY = 10_000_000;

    static int vertexCount, edgeCount, candidateCount;
    static int startVertex, midVertex1, midVertex2;
    static int[][] graph;
    static int[] shortestDistances;
    static boolean[] visitedNodes;
    static List<Integer> candidates;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        int testCases = Integer.parseInt(reader.readLine());

        for (int t = 0; t < testCases; t++) {
            initializeGraph();
            loadGraphEdges();
            loadCandidates();

            findShortestPaths();
            outputValidCandidates();
        }

        writer.close();
        reader.close();
    }

    private static void initializeGraph() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        vertexCount = Integer.parseInt(tokenizer.nextToken());
        edgeCount = Integer.parseInt(tokenizer.nextToken());
        candidateCount = Integer.parseInt(tokenizer.nextToken());

        graph = new int[vertexCount + 1][vertexCount + 1];
        shortestDistances = new int[vertexCount + 1];
        visitedNodes = new boolean[vertexCount + 1];

        for (int[] row : graph) Arrays.fill(row, INFINITY);
        Arrays.fill(shortestDistances, INFINITY);

        tokenizer = new StringTokenizer(reader.readLine());
        startVertex = Integer.parseInt(tokenizer.nextToken());
        midVertex1 = Integer.parseInt(tokenizer.nextToken());
        midVertex2 = Integer.parseInt(tokenizer.nextToken());
    }

    private static void loadGraphEdges() throws IOException {
        for (int i = 0; i < edgeCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int vertex1 = Integer.parseInt(tokenizer.nextToken());
            int vertex2 = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken()) * 2;
            graph[vertex1][vertex2] = graph[vertex2][vertex1] = weight;
        }
        graph[midVertex1][midVertex2] = graph[midVertex2][midVertex1] -= 1;
    }

    private static void loadCandidates() throws IOException {
        candidates = new ArrayList<>();
        for (int i = 0; i < candidateCount; i++) {
            candidates.add(Integer.valueOf(reader.readLine()));
        }
    }

    private static void findShortestPaths() {
        PriorityQueue<Node> priorityQueue = new PriorityQueue<>();
        priorityQueue.add(new Node(startVertex, 0));
        shortestDistances[startVertex] = 0;

        while (!priorityQueue.isEmpty()) {
            Node currentNode = priorityQueue.poll();
            int currentVertex = currentNode.destination;

            if (visitedNodes[currentVertex]) continue;

            visitedNodes[currentVertex] = true;

            for (int nextVertex = 1; nextVertex <= vertexCount; nextVertex++) {
                if (!visitedNodes[nextVertex] && shortestDistances[nextVertex] > shortestDistances[currentVertex] + graph[currentVertex][nextVertex]) {
                    shortestDistances[nextVertex] = shortestDistances[currentVertex] + graph[currentVertex][nextVertex];
                    priorityQueue.add(new Node(nextVertex, shortestDistances[nextVertex]));
                }
            }
        }
    }

    private static void outputValidCandidates() throws IOException {
        Collections.sort(candidates);
        for (int candidate : candidates) {
            if (shortestDistances[candidate] % 2 == 1) {
                writer.write(candidate + " ");
            }
        }
        writer.write("\n");
    }
}