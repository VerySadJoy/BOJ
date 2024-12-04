//Question No: 11657
//Title: 타임머신
//Tier: Gold IV
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static class Edge {
        int start;
        int end;
        int weight;

        public Edge(int start, int end, int weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }
    }

    static Edge[] edges;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int nodeCount = Integer.parseInt(tokenizer.nextToken());
        int edgeCount = Integer.parseInt(tokenizer.nextToken());
        edges = new Edge[edgeCount];
        long[] distances = new long[nodeCount + 1];
        Arrays.fill(distances, Integer.MAX_VALUE);

        for (int i = 0; i < edgeCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            edges[i] = new Edge(start, end, weight);
        }

        distances[1] = 0;
        for (int i = 1; i < nodeCount; i++) {
            for (Edge edge : edges) {
                if (distances[edge.start] != Integer.MAX_VALUE &&
                        distances[edge.end] > distances[edge.start] + edge.weight) {
                    distances[edge.end] = distances[edge.start] + edge.weight;
                }
            }
        }

        boolean hasNegativeCycle = false;
        for (Edge edge : edges) {
            if (distances[edge.start] != Integer.MAX_VALUE &&
                    distances[edge.end] > distances[edge.start] + edge.weight) {
                hasNegativeCycle = true;
                break;
            }
        }

        if (hasNegativeCycle) {
            writer.write("-1\n");
        } else {
            for (int i = 2; i <= nodeCount; i++) {
                if (distances[i] == Integer.MAX_VALUE) {
                    writer.write("-1\n");
                } else {
                    writer.write(distances[i] + "\n");
                }
            }
        }

        writer.flush();
        writer.close();
    }
}