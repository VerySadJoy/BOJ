//Question No: 12851
//Title: 숨바꼭질 2
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static int[] dist = new int[MAX + 1];
    static int[] count = new int[MAX + 1];
    
    static boolean[] visited = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        bfs(N, K);

        System.out.println(dist[K]);
        System.out.println(count[K]);
    }

    static void bfs(int start, int target) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        visited[start] = true;
        count[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            int[] nextPositions = {current - 1, current + 1, current * 2};

            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX) {
                    if (!visited[next]) {
                        visited[next] = true;
                        dist[next] = dist[current] + 1;
                        count[next] = count[current];
                        queue.offer(next);
                    } else if (dist[next] == dist[current] + 1) {
                        count[next] += count[current];
                    }
                }
            }
        }
    }
}
