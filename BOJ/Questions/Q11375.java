//Question No: 11375
//Title: 열혈강호
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1001;
    static int numWorkers, numWorks;
    static List<Integer>[] works = new ArrayList[MAX];
    static int[] owner = new int[MAX];
    static boolean[] visited = new boolean[MAX];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numWorkers = Integer.parseInt(tokenizer.nextToken());
        numWorks = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < MAX; i++) {
            works[i] = new ArrayList<>();
        }

        for (int i = 1; i <= numWorkers; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int numAssignments = Integer.parseInt(tokenizer.nextToken());
            for (int j = 0; j < numAssignments; j++) {
                int work = Integer.parseInt(tokenizer.nextToken());
                works[i].add(work);
            }
        }

        System.out.println(maxBipartiteMatch());
    }

    static boolean depthFirstSearch(int worker) {
        if (visited[worker]) return false;
        visited[worker] = true;

        for (int work : works[worker]) {
            if (owner[work] == 0 || depthFirstSearch(owner[work])) {
                owner[work] = worker;
                return true;
            }
        }
        return false;
    }

    static int maxBipartiteMatch() {
        int matches = 0;
        for (int worker = 1; worker <= numWorkers; worker++) {
            Arrays.fill(visited, false);
            if (depthFirstSearch(worker)) {
                matches++;
            }
        }
        return matches;
    }
}