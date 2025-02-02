//Question No: 11378
//Title: 열혈강호 4
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static int[] matched;
    static boolean[] visited;
    static int[][] edges;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        matched = new int[m + 1];
        Arrays.fill(matched, -1);
        visited = new boolean[m + 1];
        edges = new int[n + 1][];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            edges[i] = new int[a];
            for (int j = 0; j < a; j++) {
                edges[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int sum = 0;
        for (int i = 1; i <= n && sum < m; i++) {
            Arrays.fill(visited, false);
            if (matching(i)) {
                sum++;
            }
        }

        while (k > 0) {
            int tmp = 0;
            for (int i = 1; i <= n && sum < m && k > 0; i++) {
                Arrays.fill(visited, false);
                if (matching(i)) {
                    tmp++;
                    k--;
                }
            }
            sum += tmp;
            if (tmp == 0 || sum >= m || k == 0) break;
        }
        System.out.println(sum);
    }

    private static boolean matching(int cur) {
        for (int next : edges[cur]) {
            if (visited[next]) continue;
            visited[next] = true;
            if (matched[next] == -1 || matching(matched[next])) {
                matched[next] = cur;
                return true;
            }
        }
        return false;
    }
}