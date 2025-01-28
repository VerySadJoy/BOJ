//Question No: 1867
//Title: 돌멩이 제거
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    int[] matched;
    boolean[] visited;
    ArrayList<Integer>[] edges;

    private boolean matching(int node) {
        for (int neighbor : edges[node]) {
            if (visited[neighbor]) continue;
            visited[neighbor] = true;
            if (matched[neighbor] == -1 || matching(matched[neighbor])) {
                matched[neighbor] = node;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        ArrayList<Integer>[] edges = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            edges[i] = new ArrayList<>();
        }

        for (int i = 0; i < k; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            edges[a].add(b);
        }

        int[] matched = new int[n + 1];
        Arrays.fill(matched, -1);

        int count = 0;
        for (int i = 1; i <= n; i++) {
            boolean[] visited = new boolean[n + 1];
            Main helper = new Main();
            helper.matched = matched;
            helper.visited = visited;
            helper.edges = edges;
            if (helper.matching(i)) {
                count++;
            }
        }

        System.out.println(count);
    }
}