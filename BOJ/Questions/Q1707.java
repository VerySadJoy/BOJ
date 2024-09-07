//Question No: 1707
//Title: 이분 그래프
//Tier: Gold IV
import java.util.*;

public class Main {
    static final int MAX_SIZE = 20001;
    static final int RED = 1;
    static final int BLUE = 2;

    static int testCases, numVertices, numEdges;
    static List<Integer>[] graph = new ArrayList[MAX_SIZE];
    static int[] visited = new int[MAX_SIZE];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        testCases = scanner.nextInt();

        for (int i = 0; i < MAX_SIZE; i++) {
            graph[i] = new ArrayList<>();
        }

        while (testCases-- > 0) {
            numVertices = scanner.nextInt();
            numEdges = scanner.nextInt();

            for (int i = 0; i < numEdges; i++) {
                int from = scanner.nextInt();
                int to = scanner.nextInt();
                graph[from].add(to);
                graph[to].add(from);
            }

            for (int i = 1; i <= numVertices; i++) {
                if (visited[i] == 0) {
                    bfs(i);
                }
            }

            if (isBipartiteGraph()) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }

            for (int i = 0; i <= numVertices; i++) {
                graph[i].clear();
            }
            Arrays.fill(visited, 0);
        }
    }

    static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        visited[start] = RED;
        queue.add(start);

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int color = visited[current] == RED ? BLUE : RED;

            for (int neighbor : graph[current]) {
                if (visited[neighbor] == 0) {
                    visited[neighbor] = color;
                    queue.add(neighbor);
                }
            }
        }
    }

    static boolean isBipartiteGraph() {
        for (int i = 1; i <= numVertices; i++) {
            for (int neighbor : graph[i]) {
                if (visited[i] == visited[neighbor]) {
                    return false;
                }
            }
        }
        return true;
    }
}