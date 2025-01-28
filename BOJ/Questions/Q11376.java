//Question No: 11376
//Title: 열혈강호 2
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {

    static List<Integer>[] adjacencyList;
    static int[] assignedTask;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int workers = Integer.parseInt(tokenizer.nextToken());
        int tasks = Integer.parseInt(tokenizer.nextToken());

        adjacencyList = new ArrayList[workers + 1];
        for (int i = 1; i <= workers; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        assignedTask = new int[tasks + 1];
        visited = new boolean[tasks + 1];

        for (int i = 1; i <= workers; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int taskCount = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < taskCount; j++) {
                adjacencyList[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }

        int assignments = 0;
        for (int i = 1; i <= workers; i++) {
            for (int attempt = 0; attempt < 2; attempt++) {
                Arrays.fill(visited, false);
                if (performDFS(i)) {
                    assignments++;
                }
            }
        }

        System.out.println(assignments);
    }

    static boolean performDFS(int worker) {
        for (int task : adjacencyList[worker]) {
            if (visited[task]) continue;

            visited[task] = true;

            if (assignedTask[task] == 0 || performDFS(assignedTask[task])) {
                assignedTask[task] = worker;
                return true;
            }
        }

        return false;
    }
}