//Question No: 11085
//Title: 군사 이동
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class ConnectionData implements Comparable<ConnectionData> {
    int start, end, weight;

    ConnectionData(int start, int end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(ConnectionData other) {
        return Integer.compare(other.weight, this.weight);
    }
}

public class Main {
    static int numPeople, numConnections, startPoint, endPoint;
    static int[] parentArray;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numPeople = Integer.parseInt(tokenizer.nextToken());
        numConnections = Integer.parseInt(tokenizer.nextToken());
        
        tokenizer = new StringTokenizer(reader.readLine());
        startPoint = Integer.parseInt(tokenizer.nextToken());
        endPoint = Integer.parseInt(tokenizer.nextToken());

        ArrayList<ConnectionData> connections = new ArrayList<>();
        parentArray = new int[numPeople];
        for (int i = 0; i < numPeople; i++) {
            parentArray[i] = -1;
        }

        for (int i = 0; i < numConnections; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            connections.add(new ConnectionData(start, end, weight));
        }

        Collections.sort(connections);

        for (ConnectionData connection : connections) {
            union(connection.start, connection.end);
            if (find(startPoint) == find(endPoint)) {
                System.out.println(connection.weight);
                break;
            }
        }
    }

    public static int find(int node) {
        if (parentArray[node] < 0) {
            return node;
        }
        return parentArray[node] = find(parentArray[node]);
    }

    public static void union(int node1, int node2) {
        node1 = find(node1);
        node2 = find(node2);
        if (node1 != node2) {
            parentArray[node1] += parentArray[node2];
            parentArray[node2] = node1;
        }
    }
}