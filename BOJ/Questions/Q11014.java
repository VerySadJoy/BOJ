//Question No: 11014
//Title: 컨닝 2
//Tier: Platinum II
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 83;
    static int N, M;
    static int[] d;
    static char[][] grid;
    static List<Integer>[] adj;
    static boolean[] used, able;

    static boolean dfs(int cur) {
        for (int next : adj[cur]) {
            if (used[next]) continue;
            used[next] = true;
            if (d[next] == -1 || dfs(d[next])) {
                d[next] = cur;
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            adj = new ArrayList[MAX * MAX];
            d = new int[MAX * MAX];
            used = new boolean[MAX * MAX];
            able = new boolean[MAX * MAX];
            grid = new char[MAX][MAX];

            for (int i = 0; i < MAX * MAX; i++) {
                adj[i] = new ArrayList<>();
                d[i] = -1;
                able[i] = false;
            }

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            M = Integer.parseInt(tokenizer.nextToken());

            int totalCells = N * M;
            int ans = totalCells;
            int res = 0;

            for (int i = 0; i < N; i++) {
                String line = reader.readLine();
                for (int j = 0; j < M; j++) {
                    grid[i][j] = line.charAt(j);
                    int index = i * M + j;
                    if (grid[i][j] == 'x') {
                        ans--;
                    } else {
                        able[index] = true;
                    }
                }
            }

            for (int j = 0; j < M; j += 2) {
                for (int i = 0; i < N; i++) {
                    int cur = i * M + j;
                    if (able[cur]) {
                        int left = cur - 1;
                        int right = cur + 1;
                        int downLeft = left + M;
                        int downRight = right + M;
                        int upLeft = left - M;
                        int upRight = right - M;

                        if (j > 0 && able[left]) adj[cur].add(left);
                        if (j < M - 1 && able[right]) adj[cur].add(right);
                        if (i < N - 1 && j > 0 && able[downLeft]) adj[cur].add(downLeft);
                        if (i < N - 1 && j < M - 1 && able[downRight]) adj[cur].add(downRight);
                        if (i > 0 && j > 0 && able[upLeft]) adj[cur].add(upLeft);
                        if (i > 0 && j < M - 1 && able[upRight]) adj[cur].add(upRight);
                    }
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    int cur = i * M + j;
                    Arrays.fill(used, false);
                    if (dfs(cur)) res++;
                }
            }

            output.append(ans - res).append("\n");
        }

        System.out.print(output);
    }
}