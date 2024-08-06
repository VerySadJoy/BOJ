//Question No: 11377
//Title: 열혈강호 3
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Main {

    static List<Integer>[] adjacencyList;
    static int[] assignedTasks;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numEmployees = Integer.parseInt(tokenizer.nextToken());
        int numTasks = Integer.parseInt(tokenizer.nextToken());
        int extraAssignments = Integer.parseInt(tokenizer.nextToken());

        adjacencyList = new ArrayList[numEmployees + 1];
        for (int i = 1; i <= numEmployees; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        assignedTasks = new int[numTasks + 1];
        visited = new boolean[numTasks + 1];

        for (int i = 1; i <= numEmployees; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int numPreferences = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < numPreferences; j++) {
                adjacencyList[i].add(Integer.parseInt(tokenizer.nextToken()));
            }
        }

        int totalAssignments = 0;
        for (int i = 1; i <= 2 * numEmployees; i++) {
            Arrays.fill(visited, false);
            if (i <= numEmployees) {
                if (depthFirstSearch(i)) totalAssignments++;
            } else {
                if (depthFirstSearch(i - numEmployees) && extraAssignments > 0) {
                    extraAssignments--;
                    totalAssignments++;
                }
            }
        }
        System.out.println(totalAssignments);
    }

    static boolean depthFirstSearch(int current) {
        for (int nextTask : adjacencyList[current]) {
            if (visited[nextTask]) continue;

            visited[nextTask] = true;

            if (assignedTasks[nextTask] == 0 || depthFirstSearch(assignedTasks[nextTask])) {
                assignedTasks[nextTask] = current;
                return true;
            }
        }
        return false;
    }
}