//Question No: 14169
//Title: Lasers and Mirrors
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    static final int MAXN = 100005;
    static int N, a, b, c, d;
    static List<int[]> xy = new ArrayList<>();
    static List<int[]>[] adj = new ArrayList[MAXN];
    static int[] visited = new int[MAXN];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        Arrays.fill(visited, Integer.MAX_VALUE);
        for (int i = 0; i < MAXN; i++) adj[i] = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(reader.readLine());
        N = Integer.parseInt(st.nextToken());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        xy.add(new int[]{a, b, N});
        xy.add(new int[]{c, d, N + 1});

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            xy.add(new int[]{x, y, i});
        }

        xy.sort(Comparator.comparingInt(o -> o[0]));
        for (int i = 0; i < N + 1; i++) {
            int[] current = xy.get(i);
            int[] next = xy.get(i + 1);
            if (current[0] == next[0]) {
                adj[current[2]].add(new int[]{next[2], 1});
                adj[next[2]].add(new int[]{current[2], 1});
            }
        }

        xy.sort((a, b) -> {
            if (a[1] == b[1]) return Integer.compare(a[0], b[0]);
            return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < N + 1; i++) {
            int[] current = xy.get(i);
            int[] next = xy.get(i + 1);
            if (current[1] == next[1]) {
                adj[current[2]].add(new int[]{next[2], 0});
                adj[next[2]].add(new int[]{current[2], 0});
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        queue.add(new int[]{N, 1});
        visited[N] = 0;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int here = current[0], dir = current[1];

            for (int[] neighbor : adj[here]) {
                int there = neighbor[0], tdir = neighbor[1];
                if (visited[there] < visited[here] + 1) continue;

                visited[there] = Math.min(visited[there], visited[here] + (dir ^ tdir));
                int newDir = (tdir == dir ? dir : 1 - dir);
                queue.add(new int[]{there, newDir});
            }
        }

        writer.println(visited[N + 1] == Integer.MAX_VALUE ? -1 : visited[N + 1]);
        writer.flush();
        writer.close();
        reader.close();
    }
}