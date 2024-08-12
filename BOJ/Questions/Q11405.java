//Question No: 11405
//Title: 책 구매하기
//Tier: Platinum III
import java.util.*;

public class Main {
    static final int SOURCE = 200, SINK = 201, MAX = 202, MAX_VALUE = 987654321;
    static int numPeople, numStores, result = 0;
    static int[][] capacity = new int[MAX][MAX];
    static int[][] flow = new int[MAX][MAX];
    static int[][] cost = new int[MAX][MAX];
    static int[] previousNode = new int[MAX];
    static int[] distance = new int[MAX];
    static boolean[] inQueue = new boolean[MAX];
    static List<Integer>[] graph = new ArrayList[MAX];
    static Queue<Integer> queue = new LinkedList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numPeople = scanner.nextInt();
        numStores = scanner.nextInt();

        for (int i = 0; i < MAX; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = numStores; i < numPeople + numStores; i++) {
            capacity[i][SINK] = scanner.nextInt();
            graph[i].add(SINK);
            graph[SINK].add(i);
        }

        for (int i = 0; i < numStores; i++) {
            capacity[SOURCE][i] = scanner.nextInt();
            graph[SOURCE].add(i);
            graph[i].add(SOURCE);
        }

        for (int store = 0; store < numStores; store++) {
            for (int person = numStores; person < numPeople + numStores; person++) {
                cost[store][person] = scanner.nextInt();
                cost[person][store] = -cost[store][person];
                capacity[store][person] = MAX_VALUE;
                graph[store].add(person);
                graph[person].add(store);
            }
        }

        while (findShortestPath()) {
            result += updateFlow(findMinimumFlow());
        }

        System.out.println(result);
        scanner.close();
    }

    static boolean findShortestPath() {
        initialize();
        while (!queue.isEmpty()) {
            int current = queue.poll();
            inQueue[current] = false;

            for (int next : graph[current]) {
                int newDistance = distance[current] + cost[current][next];
                if (capacity[current][next] > flow[current][next] && distance[next] > newDistance) {
                    distance[next] = newDistance;
                    previousNode[next] = current;

                    if (!inQueue[next]) {
                        inQueue[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return distance[SINK] != MAX_VALUE;
    }

    static int findMinimumFlow() {
        int minFlow = MAX_VALUE;
        for (int dest = SINK, start = previousNode[dest]; dest != SOURCE; dest = previousNode[dest], start = previousNode[dest]) {
            minFlow = Math.min(minFlow, capacity[start][dest] - flow[start][dest]);
        }
        return minFlow;
    }

    static int updateFlow(int value) {
        int totalCost = 0;
        for (int dest = SINK, start = previousNode[dest]; dest != SOURCE; dest = previousNode[dest], start = previousNode[dest]) {
            totalCost += value * cost[start][dest];
            flow[start][dest] += value;
            flow[dest][start] -= value;
        }
        return totalCost;
    }

    static void initialize() {
        Arrays.fill(previousNode, -1);
        Arrays.fill(distance, MAX_VALUE);
        distance[SOURCE] = 0;
        queue.add(SOURCE);
        inQueue[SOURCE] = true;
    }
}