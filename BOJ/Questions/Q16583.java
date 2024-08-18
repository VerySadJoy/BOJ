//Question No: 16583
//Title: Boomerangs
//Tier: Platinum I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    static int nodes, components = 0;
    static ArrayList<Integer>[] graph, children;
    static ArrayList<int[]> triplets;
    static int[] childCount, parent;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        int[] input = parseInput();
        nodes = input[0];
        int edges = input[1];

        initializeDataStructures();

        for (int i = 0; i < edges; i++) {
            int[] edge = parseInput();
            int node1 = edge[0];
            int node2 = edge[1];
            graph[node1].add(node2);
            graph[node2].add(node1);
        }

        for (int i = 1; i <= nodes; i++) {
            if (!visited[i]) {
                traverseAndMark(i);
            }
        }

        writeOutput(components);
        writer.newLine();

        for (int[] triplet : triplets) {
            writer.write(triplet[0] + " " + triplet[1] + " " + triplet[2]);
            writer.newLine();
        }

        writer.flush();
        writer.close();
    }

    static void initializeDataStructures() {
        graph = new ArrayList[nodes + 1];
        children = new ArrayList[nodes + 1];
        childCount = new int[nodes + 1];
        parent = new int[nodes + 1];
        visited = new boolean[nodes + 1];
        triplets = new ArrayList<>();

        for (int i = 0; i <= nodes; i++) {
            graph[i] = new ArrayList<>();
            children[i] = new ArrayList<>();
        }
    }

    static void traverseAndMark(int node) {
        visited[node] = true;
        childCount[node] = graph[node].size();

        for (int neighbor : graph[node]) {
            if (visited[neighbor]) {
                if (parent[node] != neighbor) {
                    children[neighbor].add(node);
                }
                childCount[neighbor]--;
                continue;
            }
            parent[neighbor] = node;
            traverseAndMark(neighbor);
        }

        components += childCount[node] / 2;

        if (childCount[node] % 2 == 1) {
            childCount[parent[node]]++;
        }

        int childSize = children[node].size();
        for (int i = 1; i < childSize; i += 2) {
            int[] triplet = {children[node].get(i - 1), node, children[node].get(i)};
            triplets.add(triplet);
        }

        if (childSize % 2 == 1 && parent[node] != 0) {
            int[] triplet = {children[node].get(childSize - 1), node, parent[node]};
            triplets.add(triplet);
        } else if (childSize % 2 == 0) {
            children[parent[node]].add(node);
        }
    }

    static int[] parseInput() throws IOException {
        String[] inputString = reader.readLine().split(" ");
        int[] inputInts = new int[inputString.length];
        for (int i = 0; i < inputString.length; i++) {
            inputInts[i] = Integer.parseInt(inputString[i]);
        }
        return inputInts;
    }

    static void writeOutput(long number) throws IOException {
        writer.write(Long.toString(number));
    }
}