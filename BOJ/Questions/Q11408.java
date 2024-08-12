//Question No: 11408
//Title: 열혈강호 5
//Tier: Platinum III
import java.util.*;

public class Main {
    static final int MAX_V = 900;
    static final int SOURCE = MAX_V - 2;
    static final int SINK = MAX_V - 1;
    static final int WORK_OFFSET = 400;
    static final int INFINITY = 987654321;

    static List<Integer>[] adjacencyList = new ArrayList[MAX_V];
    static int[][] capacity = new int[MAX_V][MAX_V];
    static int[][] flow = new int[MAX_V][MAX_V];
    static int[][] cost = new int[MAX_V][MAX_V];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int employees = scanner.nextInt();
        int jobs = scanner.nextInt();

        for (int i = 0; i < MAX_V; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= employees; i++) {
            capacity[SOURCE][i] = 1;
            adjacencyList[SOURCE].add(i);
            adjacencyList[i].add(SOURCE);
        }

        for (int i = 1; i <= jobs; i++) {
            capacity[i + WORK_OFFSET][SINK] = 1;
            adjacencyList[i + WORK_OFFSET].add(SINK);
            adjacencyList[SINK].add(i + WORK_OFFSET);
        }

        for (int i = 1; i <= employees; i++) {
            int jobCount = scanner.nextInt();
            for (int j = 0; j < jobCount; j++) {
                int jobIndex = scanner.nextInt();
                int jobCost = scanner.nextInt();
                int jobNode = jobIndex + WORK_OFFSET;
                adjacencyList[i].add(jobNode);
                adjacencyList[jobNode].add(i);
                capacity[i][jobNode] = 1;
                cost[i][jobNode] = jobCost;
                cost[jobNode][i] = -jobCost;
            }
        }

        int totalCost = 0;
        int jobsAssigned = 0;

        while (true) {
            int[] previous = new int[MAX_V];
            int[] distances = new int[MAX_V];
            boolean[] inQueue = new boolean[MAX_V];
            Arrays.fill(previous, -1);
            Arrays.fill(distances, INFINITY);
            Queue<Integer> queue = new LinkedList<>();

            distances[SOURCE] = 0;
            inQueue[SOURCE] = true;
            queue.add(SOURCE);

            while (!queue.isEmpty()) {
                int currentNode = queue.poll();
                inQueue[currentNode] = false;

                for (int nextNode : adjacencyList[currentNode]) {
                    if (capacity[currentNode][nextNode] - flow[currentNode][nextNode] > 0 &&
                        distances[nextNode] > distances[currentNode] + cost[currentNode][nextNode]) {
                        distances[nextNode] = distances[currentNode] + cost[currentNode][nextNode];
                        previous[nextNode] = currentNode;
                        if (!inQueue[nextNode]) {
                            queue.add(nextNode);
                            inQueue[nextNode] = true;
                        }
                    }
                }
            }

            if (previous[SINK] == -1) break;

            int additionalFlow = INFINITY;
            for (int i = SINK; i != SOURCE; i = previous[i]) {
                additionalFlow = Math.min(additionalFlow, capacity[previous[i]][i] - flow[previous[i]][i]);
            }

            for (int i = SINK; i != SOURCE; i = previous[i]) {
                totalCost += additionalFlow * cost[previous[i]][i];
                flow[previous[i]][i] += additionalFlow;
                flow[i][previous[i]] -= additionalFlow;
            }

            jobsAssigned++;
        }

        System.out.println(jobsAssigned);
        System.out.println(totalCost);
    }
}