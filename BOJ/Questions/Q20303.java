//Question No: 20303
//Title: 할로윈의 양아치
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] parent;
    static int[] dp;
    static int[] candy;
    static int[] person;

    static void unionParent(int x, int y) {
        x = getParent(x);
        y = getParent(y);

        if (x < y) parent[y] = x;
        else parent[x] = y;
    }

    static int getParent(int x) {
        if (x == parent[x]) return x;
        return parent[x] = getParent(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        dp = new int[k];
        candy = new int[n + 1];
        person = new int[n + 1];

        for (int i = 1; i <= n; i++) parent[i] = i;

        for (int i = 1; i <= n; i++) {
            candy[i] = Integer.parseInt(br.readLine());
            person[i] = 1;
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            unionParent(x, y);
        }

        for (int i = 1; i <= n; i++) {
            if (parent[i] != i) {
                int p = getParent(i);
                candy[p] += candy[i];
                person[p] += person[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if (parent[i] != i) continue;
            for (int j = k - 1; j - person[i] >= 0; j--) {
                dp[j] = Math.max(dp[j], dp[j - person[i]] + candy[i]);
            }
        }

        System.out.println(dp[k - 1]);
    }
}
