//Question No: 16946
//Title: 벽 부수고 이동하기 4
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] group;
    static int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};
    static int[][] visited;
    static HashMap<Integer, Integer> groupSize = new HashMap<>();

    static void dfs(int x, int y, int g) {
        visited[x][y] = g;
        groupSize.put(g, groupSize.getOrDefault(g, 0) + 1);
        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];
            if (nx >= 0 && nx < N && ny >= 0 && ny < M && map[nx][ny] == 0 && visited[nx][ny] == 0) {
                dfs(nx, ny, g);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        int groupIdx = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0 && visited[i][j] == 0) {
                    dfs(i, j, groupIdx++);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) {
                    HashSet<Integer> groups = new HashSet<>();
                    int sum = 1;
                    for (int[] dir : dirs) {
                        int ni = i + dir[0];
                        int nj = j + dir[1];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < M && map[ni][nj] == 0) {
                            int g = visited[ni][nj];
                            if (!groups.contains(g)) {
                                sum += groupSize.get(g);
                                groups.add(g);
                            }
                        }
                    }
                    sb.append(sum % 10);
                } else {
                    sb.append(0);
                }
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());
    }
}
