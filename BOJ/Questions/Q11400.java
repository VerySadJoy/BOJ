//Question No: 11400
//Title: 단절선
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Edge {
    int start;
    int end;

    Edge(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Main {
    static int visitOrder = 1;
    static int[] order;
    static ArrayList<Edge> bridges;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numVertices = Integer.parseInt(tokenizer.nextToken());
        int numEdges = Integer.parseInt(tokenizer.nextToken());

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();
        for (int i = 0; i <= numVertices; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        for (int i = 0; i < numEdges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int vertexA = Integer.parseInt(tokenizer.nextToken());
            int vertexB = Integer.parseInt(tokenizer.nextToken());
            adjacencyList.get(vertexA).add(vertexB);
            adjacencyList.get(vertexB).add(vertexA);
        }

        order = new int[numVertices + 1];
        bridges = new ArrayList<>();

        for (int i = 1; i <= numVertices; i++) {
            if (order[i] == 0) {
                findBridges(i, 0, adjacencyList);
            }
        }

        Collections.sort(bridges, (edge1, edge2) -> (edge1.start == edge2.start) ? edge1.end - edge2.end : edge1.start - edge2.start);

        StringBuilder result = new StringBuilder();
        result.append(bridges.size()).append("\n");

        for (Edge bridge : bridges) {
            result.append(bridge.start).append(" ").append(bridge.end).append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int findBridges(int currentVertex, int parentVertex, ArrayList<ArrayList<Integer>> adjacencyList) {
        order[currentVertex] = visitOrder++;
        int lowestOrder = order[currentVertex];

        for (int adjacentVertex : adjacencyList.get(currentVertex)) {
            if (adjacentVertex == parentVertex) {
                continue;
            }

            if (order[adjacentVertex] == 0) {
                int childLowestOrder = findBridges(adjacentVertex, currentVertex, adjacencyList);

                if (childLowestOrder > order[currentVertex]) {
                    if (adjacentVertex > currentVertex) {
                        bridges.add(new Edge(currentVertex, adjacentVertex));
                    } else {
                        bridges.add(new Edge(adjacentVertex, currentVertex));
                    }
                }
                lowestOrder = Math.min(lowestOrder, childLowestOrder);
            } else {
                lowestOrder = Math.min(lowestOrder, order[adjacentVertex]);
            }
        }

        return lowestOrder;
    }
}
