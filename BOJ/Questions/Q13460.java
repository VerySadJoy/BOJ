//Question No: 13460
//Title: 구슬 탈출 2
//Tier: Gold I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {0, 0, -1, 1}; 
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Point> queue = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        Point red = null;
        Point blue = null;

        for (int i = 0; i < N; i++) {
            String row = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = row.charAt(j);
                if (board[i][j] == 'R') red = new Point(i, j);
                if (board[i][j] == 'B') blue = new Point(i, j);
            }
        }

        queue.offer(new Point(red, blue, 0));
        visited[red.x][red.y][blue.x][blue.y] = true;

        System.out.println(bfs());
    }

    static int bfs() {
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            Point red = cur.red;
            Point blue = cur.blue;
            int count = cur.count;

            if (count >= 10) break;

            for (int i = 0; i < 4; i++) {
                Point nextRed = move(red, i);
                Point nextBlue = move(blue, i);

                if (board[nextBlue.x][nextBlue.y] == 'O') continue;
                if (board[nextRed.x][nextRed.y] == 'O') return count + 1;

                if (nextRed.x == nextBlue.x && nextRed.y == nextBlue.y) {
                    switch (i) {
                        case 0: if (red.x > blue.x) nextRed = new Point(nextRed.x + 1, nextRed.y);
                                else nextBlue = new Point(nextBlue.x + 1, nextBlue.y);
                                break;
                        case 1: if (red.x < blue.x) nextRed = new Point(nextRed.x - 1, nextRed.y);
                                else nextBlue = new Point(nextBlue.x - 1, nextBlue.y);
                                break;
                        case 2: if (red.y > blue.y) nextRed = new Point(nextRed.x, nextRed.y + 1);
                                else nextBlue = new Point(nextBlue.x, nextBlue.y + 1);
                                break;
                        case 3: if (red.y < blue.y) nextRed = new Point(nextRed.x, nextRed.y - 1);
                                else nextBlue = new Point(nextBlue.x, nextBlue.y - 1);
                                break;
                    }
                }

                if (!visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y]) {
                    queue.offer(new Point(nextRed, nextBlue, count + 1));
                    visited[nextRed.x][nextRed.y][nextBlue.x][nextBlue.y] = true;
                }
            }
        }

        return -1;
    }

    static Point move(Point ball, int direction) {
        int x = ball.x;
        int y = ball.y;

        while (true) {
            int nx = x + dx[direction];
            int ny = y + dy[direction];
            if (board[nx][ny] == '#' || board[nx][ny] == 'O') break;
            x = nx;
            y = ny;
        }

        return new Point(x, y);
    }

    static class Point {
        int x, y, count;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Point(Point red, Point blue, int count) {
            this.x = red.x;
            this.y = red.y;
            this.count = count;
        }
    }
}
