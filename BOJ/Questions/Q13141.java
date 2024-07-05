//Question No: 13141
//Title: Ignition
//Tier: Platinum V
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    private static final int INF = 987654321;
    private static int numVertices, numEdges;
    private static int[][] adjacencyMatrix;
    private static int[][] shortestDistances;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        numVertices = scanner.nextInt();
        numEdges = scanner.nextInt();
        
        adjacencyMatrix = new int[numVertices + 1][numVertices + 1];
        shortestDistances = new int[numVertices + 1][numVertices + 1];

        for (int i = 1; i <= numVertices; i++) {
            Arrays.fill(adjacencyMatrix[i], -1);
            Arrays.fill(shortestDistances[i], INF);
            shortestDistances[i][i] = 0;
        }

        for (int i = 0; i < numEdges; i++) {
            int startVertex = scanner.nextInt();
            int endVertex = scanner.nextInt();
            int edgeLength = scanner.nextInt();

            if (adjacencyMatrix[startVertex][endVertex] == -1 || adjacencyMatrix[startVertex][endVertex] < edgeLength) {
                adjacencyMatrix[startVertex][endVertex] = edgeLength;
                adjacencyMatrix[endVertex][startVertex] = edgeLength;
            }

            if (shortestDistances[startVertex][endVertex] == INF || edgeLength < shortestDistances[startVertex][endVertex]) {
                shortestDistances[startVertex][endVertex] = edgeLength;
                shortestDistances[endVertex][startVertex] = edgeLength;
            }
        }

        floydWarshall();
        System.out.printf("%.1f\n", calculateBurnTime());

        scanner.close();
    }

    private static void floydWarshall() {
        for (int k = 1; k <= numVertices; k++) {
            for (int i = 1; i <= numVertices; i++) {
                for (int j = 1; j <= numVertices; j++) {
                    shortestDistances[i][j] = Math.min(shortestDistances[i][j], shortestDistances[i][k] + shortestDistances[k][j]);
                }
            }
        }
    }

    private static double calculateBurnTime() {
        double minimumBurnTime = INF;

        for (int start = 1; start <= numVertices; start++) {
            double longestBurnTime = 0;

            for (int from = 1; from <= numVertices; from++) {
                for (int to = 1; to <= numVertices; to++) {
                    int edgeLength = adjacencyMatrix[from][to];

                    if (edgeLength != -1) {
                        double remainingLength = edgeLength - (shortestDistances[start][to] - shortestDistances[start][from]);

                        if (remainingLength > 0) {
                            double burnTime = (remainingLength / 2) + shortestDistances[start][to];
                            longestBurnTime = Math.max(burnTime, longestBurnTime);
                        }
                    }
                }
            }

            minimumBurnTime = Math.min(longestBurnTime, minimumBurnTime);
        }

        return minimumBurnTime;
    }
}
