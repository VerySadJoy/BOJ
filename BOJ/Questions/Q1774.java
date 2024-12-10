//Question No: 1774
//Title: 우주신과의 교감
//Tier: Gold III
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

class Point {
    int num;
    double x;
    double y;

    Point(int num, double x, double y) {
        this.num = num;
        this.x = x;
        this.y = y;
    }
}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    double weight;

    Edge(int start, int end, double weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Double.compare(this.weight, o.weight);
    }
}

public class Main {
    static int[] parent;
    static ArrayList<Edge> edgeList;

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int nodeCount = Integer.parseInt(tokenizer.nextToken());
        int preConnectedEdges = Integer.parseInt(tokenizer.nextToken());

        parent = new int[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            parent[i] = i;
        }

        Point[] points = new Point[nodeCount + 1];
        for (int i = 1; i <= nodeCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            double x = Double.parseDouble(tokenizer.nextToken());
            double y = Double.parseDouble(tokenizer.nextToken());
            points[i] = new Point(i, x, y);
        }

        for (int i = 0; i < preConnectedEdges; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            union(start, end);
        }

        edgeList = new ArrayList<>();
        for (int i = 1; i <= nodeCount; i++) {
            for (int j = i + 1; j <= nodeCount; j++) {
                double weight = calculateDistance(points[i], points[j]);
                edgeList.add(new Edge(points[i].num, points[j].num, weight));
            }
        }
        Collections.sort(edgeList);

        double result = 0;
        for (Edge edge : edgeList) {
            if (find(edge.start) != find(edge.end)) {
                result += edge.weight;
                union(edge.start, edge.end);
            }
        }

        writer.write(String.format("%.2f", result) + "\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    private static double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p1.x - p2.x, 2) + Math.pow(p1.y - p2.y, 2));
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