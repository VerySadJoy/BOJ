//Question No: 1926
//Title: 그림
//Tier: Silver I
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n][m];
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        int maxArea = 0;
        int numPictures = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || arr[i][j] == 0) {
                    continue;
                }

                visited[i][j] = true;
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{i, j});
                int area = 0;
                numPictures++;

                while (!queue.isEmpty()) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];
                    area++;

                    for (int dir = 0; dir < 4; dir++) {
                        int nx = x + dx[dir];
                        int ny = y + dy[dir];

                        if (nx < 0 || nx >= n || ny < 0 || ny >= m) {
                            continue;
                        }

                        if (visited[nx][ny] || arr[nx][ny] == 0) {
                            continue;
                        }

                        visited[nx][ny] = true;
                        queue.add(new int[]{nx, ny});
                    }
                }

                if (maxArea < area) {
                    maxArea = area;
                }
            }
        }

        System.out.println(numPictures);
        System.out.println(maxArea);
    }
}