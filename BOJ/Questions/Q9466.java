//Question No: 9466
//Title: 텀 프로젝트
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    static int[] students;
    static boolean[] visited;
    static boolean[] finished;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCase = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCase; t++) {
            int n = Integer.parseInt(br.readLine());
            students = new int[n + 1];
            visited = new boolean[n + 1];
            finished = new boolean[n + 1];
            count = 0;

            String[] input = br.readLine().split(" ");
            for (int i = 1; i <= n; i++) {
                students[i] = Integer.parseInt(input[i - 1]);
            }

            for (int i = 1; i <= n; i++) {
                if (!visited[i]) {
                    dfs(i);
                }
            }
            System.out.println(n - count);
        }
    }

    static void dfs(int current) {
        visited[current] = true;
        int next = students[current];

        if (!visited[next]) {
            dfs(next);
        } else {
            if (!finished[next]) {
                for (int i = next; i != current; i = students[i]) {
                    count++;
                }
                count++;
            }
        }
        finished[current] = true;
    }
}
