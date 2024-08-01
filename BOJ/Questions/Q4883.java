//Question No: 4883
//Title: 삼각 그래프
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    static final int MAX = 100010;
    static int[][] graph = new int[MAX][3];
    static int[][] cost = new int[MAX][3];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int testCase = 1;
        while (true) {
            int rows = Integer.parseInt(br.readLine().trim());
            if (rows == 0) break;

            for (int i = 0; i < rows; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 3; j++) {
                    graph[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            Arrays.fill(cost[0], Integer.MAX_VALUE);
            cost[0][1] = graph[0][1];
            cost[0][2] = graph[0][1] + graph[0][2];

            for (int i = 1; i < rows; i++) {
                cost[i][0] = Math.min(cost[i - 1][0], cost[i - 1][1]) + graph[i][0];
                cost[i][1] = Math.min(Math.min(cost[i - 1][0], cost[i - 1][1]), Math.min(cost[i - 1][2], cost[i][0])) + graph[i][1];
                cost[i][2] = Math.min(Math.min(cost[i - 1][1], cost[i - 1][2]), cost[i][1]) + graph[i][2];
            }

            System.out.println(testCase++ + ". " + cost[rows - 1][1]);
        }
    }
}