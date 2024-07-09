//Question No: 1325
//Title: 효율적인 해킹
//Tier: Silver I
import java.io.*;
import java.util.*;

public class Main {
    static int numComputers, numRelations;
    static List<Integer>[] trustGraph;
    static int[] hackCounts;
    static boolean[] visited;
    static Queue<Integer> queue = new LinkedList<>();

    static void bfs() {
        while (!queue.isEmpty()) {
            int currentComputer = queue.remove();

            for (int nextComputer : trustGraph[currentComputer]) {
                if (!visited[nextComputer]) {
                    visited[nextComputer] = true;
                    hackCounts[nextComputer]++;
                    queue.add(nextComputer);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numComputers = Integer.parseInt(tokenizer.nextToken());
        numRelations = Integer.parseInt(tokenizer.nextToken());

        trustGraph = new List[numComputers + 1];
        hackCounts = new int[numComputers + 1];
        for (int i = 1; i <= numComputers; i++) {
            trustGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < numRelations; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int start = Integer.parseInt(tokenizer.nextToken());
            int end = Integer.parseInt(tokenizer.nextToken());

            trustGraph[start].add(end);
        }

        for (int i = 1; i <= numComputers; i++) {
            visited = new boolean[numComputers + 1];

            visited[i] = true;
            hackCounts[i]++;
            queue.add(i);

            bfs();
        }

        int maxHackCount = 0;
        for (int i = 1; i <= numComputers; i++) {
            maxHackCount = Math.max(maxHackCount, hackCounts[i]);
        }

        StringBuilder result = new StringBuilder();
        for (int i = 1; i <= numComputers; i++) {
            if (hackCounts[i] == maxHackCount) {
                result.append(i).append(" ");
            }
        }
        System.out.println(result);
    }
}
