//Question No: 6497
//Title: 전력난
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;

    Edge(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return weight - o.weight;
    }
}

public class Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine());
            int nodeCount = Integer.parseInt(tokenizer.nextToken());
            int edgeCount = Integer.parseInt(tokenizer.nextToken());

            if (nodeCount == 0 && edgeCount == 0) {
                break;
            }

            edgeList = new ArrayList<>();
            int totalCost = 0;

            for (int i = 0; i < edgeCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int start = Integer.parseInt(tokenizer.nextToken());
                int end = Integer.parseInt(tokenizer.nextToken());
                int weight = Integer.parseInt(tokenizer.nextToken());

                edgeList.add(new Edge(start, end, weight));
                totalCost += weight;
            }

            Collections.sort(edgeList);
            parent = new int[nodeCount];
            for (int i = 0; i < nodeCount; i++) {
                parent[i] = i;
            }

            int minimumCost = 0;
            for (Edge edge : edgeList) {
                if (find(edge.start) != find(edge.end)) {
                    minimumCost += edge.weight;
                    union(edge.start, edge.end);
                }
            }

            writer.write((totalCost - minimumCost) + "\n");
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int find(int x) {
        if (x == parent[x]) {
            return x;
        }
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            parent[y] = x;
        }
    }
}