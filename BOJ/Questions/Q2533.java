//Question No: 2533
//Title: 사회망 서비스(SNS)
//Tier: Gold III
import java.util.*;

public class Main {
    static int n;
    static List<Integer>[] e;
    static int[][] dp;
    static boolean[] visited;

    public static void find(int x) {
        visited[x] = true;
        dp[x][0] = 1;
        for (int i = 0; i < e[x].size(); i++) {
            int child = e[x].get(i);
            if (visited[child]) continue;
            find(child);
            dp[x][1] += dp[child][0];
            dp[x][0] += Math.min(dp[child][1], dp[child][0]);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        e = new List[n + 1];
        dp = new int[n + 1][2];
        visited = new boolean[n + 1];

        for (int i = 1; i <= n; i++) {
            e[i] = new ArrayList<>();
        }

        int u, v;
        for (int i = 0; i < n - 1; i++) {
            u = sc.nextInt();
            v = sc.nextInt();
            e[u].add(v);
            e[v].add(u);
        }

        find(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
