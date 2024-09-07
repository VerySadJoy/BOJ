//Question No: 9373
//Title: 복도 뚫기
//Tier: Platinum II
import java.io.*;
import java.util.*;

class ScannerHelper {
    BufferedReader reader;
    StringTokenizer tokenizer;

    public ScannerHelper() {
        reader = new BufferedReader(new InputStreamReader(System.in));
    }

    String next() {
        while (tokenizer == null || !tokenizer.hasMoreElements()) {
            try {
                tokenizer = new StringTokenizer(reader.readLine());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return tokenizer.nextToken();
    }

    int nextInt() {
        return Integer.parseInt(next());
    }
}
class Edge implements Comparable<Edge> {
    double distance;
    int node1;
    int node2;

    Edge(double distance, int node1, int node2) {
        this.distance = distance;
        this.node1 = node1;
        this.node2 = node2;
    }

    @Override
    public int compareTo(Edge other) {
        return Double.compare(this.distance, other.distance);
    }
}
class Circle {
    int x;
    int y;
    int radius;

    Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
public class Main {
    public static ScannerHelper scanner = new ScannerHelper();
    public static PrintWriter writer = new PrintWriter(new BufferedOutputStream(System.out));
    public static int[] unionFind = new int[1002];

    public static void main(String[] args) throws IOException {
        int testCases = scanner.nextInt();
        while (testCases-- > 0) {
            int width = scanner.nextInt();
            int numCircles = scanner.nextInt();
            Queue<Edge> edgeQueue = new PriorityQueue<>();
            Vector<Circle> circles = new Vector<>();
            for (int i = 0; i < numCircles; i++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int radius = scanner.nextInt();
                circles.add(new Circle(x, y, radius));
            }
            edgeQueue.add(new Edge(width, numCircles, numCircles + 1));
            for (int i = 0; i < numCircles; i++) {
                edgeQueue.add(new Edge(Math.max(0, circles.get(i).x - circles.get(i).radius), i, numCircles));
                edgeQueue.add(new Edge(Math.max(0, width - circles.get(i).x - circles.get(i).radius), i, numCircles + 1));

                for (int j = 0; j < i; j++) {
                    double distanceBetweenCircles = calculateDistance(circles.get(i).x, circles.get(i).y, circles.get(j).x, circles.get(j).y);
                    edgeQueue.add(new Edge(Math.max(0.0, distanceBetweenCircles - circles.get(i).radius - circles.get(j).radius), j, i));
                }
            }
            Arrays.fill(unionFind, -1);
            while (!edgeQueue.isEmpty()) {
                Edge edge = edgeQueue.poll();
                if (unionNodes(edge.node1, edge.node2)) {
                    if (findNode(numCircles) == findNode(numCircles + 1)) {
                        if (edge.distance == 0) {
                            writer.println(0);
                        } else {
                            writer.printf("%.6f\n", edge.distance / 2);
                        }
                        break;
                    }
                }
            }
        }
        writer.flush();
    }

    public static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
    }

    static int findNode(int node) {
        if (unionFind[node] < 0) return node;
        return unionFind[node] = findNode(unionFind[node]);
    }

    static boolean unionNodes(int nodeA, int nodeB) {
        nodeA = findNode(nodeA);
        nodeB = findNode(nodeB);
        if (nodeA == nodeB) return false;

        if (unionFind[nodeA] < unionFind[nodeB]) {
            unionFind[nodeA] += unionFind[nodeB];
            unionFind[nodeB] = nodeA;
        } else {
            unionFind[nodeB] += unionFind[nodeA];
            unionFind[nodeA] = nodeB;
        }
        return true;
    }
}