//Question No: 11780
//Title: 플로이드 2
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    static int cityCount, INF = 100_001;
    static int[][] distances;
    static List<Integer>[][] routes;
    static StringBuilder output;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        cityCount = Integer.parseInt(reader.readLine());
        int busCount = Integer.parseInt(reader.readLine());

        output = new StringBuilder();
        distances = new int[cityCount + 1][cityCount + 1];
        routes = new ArrayList[cityCount + 1][cityCount + 1];
        
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                routes[i][j] = new ArrayList<>();
                if (i != j) {
                    distances[i][j] = INF;
                }
            }
        }

        for (int i = 0; i < busCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());
            int weight = Integer.parseInt(tokenizer.nextToken());
            distances[start][end] = Math.min(distances[start][end], weight);
        }

        floydWarshall();

        printDistanceMatrix();
        printRoutes();
        System.out.println(output);
    }

    static void floydWarshall() {
        for (int mid = 1; mid <= cityCount; mid++) {
            for (int start = 1; start <= cityCount; start++) {
                for (int end = 1; end <= cityCount; end++) {
                    if (distances[start][end] > distances[start][mid] + distances[mid][end]) {
                        distances[start][end] = distances[start][mid] + distances[mid][end];
                        updateRoute(start, mid, end);
                    }
                }
            }
        }
    }

    static void updateRoute(int start, int mid, int end) {
        routes[start][end].clear();
        routes[start][end].addAll(routes[start][mid]);
        routes[start][end].add(mid);
        routes[start][end].addAll(routes[mid][end]);
    }

    static void printDistanceMatrix() {
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (distances[i][j] == INF) {
                    output.append("0 ");
                } else {
                    output.append(distances[i][j]).append(" ");
                }
            }
            output.append("\n");
        }
    }

    static void printRoutes() {
        for (int i = 1; i <= cityCount; i++) {
            for (int j = 1; j <= cityCount; j++) {
                if (i == j || distances[i][j] == INF) {
                    output.append("0\n");
                    continue;
                }
                List<Integer> route = routes[i][j];
                output.append((route.size() + 2)).append(" ").append(i).append(" ");
                for (int city : route) {
                    output.append(city).append(" ");
                }
                output.append(j).append("\n");
            }
        }
    }
}