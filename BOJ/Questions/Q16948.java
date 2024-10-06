//Question No: 16948
//Title: 데스 나이트
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid;
    static int[] moveX = {-1, 1, -2, 2, -1, 1};
    static int[] moveY = {-2, -2, 0, 0, 2, 2};
    static boolean[][] visited;
    static Position targetPosition;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        int gridSize = Integer.parseInt(inputReader.readLine());

        grid = new int[gridSize][gridSize];
        visited = new boolean[gridSize][gridSize];

        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        Position startPosition = new Position(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));
        targetPosition = new Position(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken()));

        performBFS(startPosition);
    }

    public static void performBFS(Position startPosition) {
        Queue<Position> queue = new LinkedList<>();
        queue.add(startPosition);
        visited[startPosition.y][startPosition.x] = true;

        while (!queue.isEmpty()) {
            Position currentPosition = queue.poll();

            for (int i = 0; i < 6; i++) {
                int nextX = currentPosition.x + moveX[i];
                int nextY = currentPosition.y + moveY[i];

                if (nextX >= 0 && nextX < grid.length && nextY >= 0 && nextY < grid.length && !visited[nextY][nextX]) {
                    if (nextX == targetPosition.x && nextY == targetPosition.y) {
                        System.out.println(grid[currentPosition.y][currentPosition.x] + 1);
                        return;
                    }
                    visited[nextY][nextX] = true;
                    queue.add(new Position(nextY, nextX));
                    grid[nextY][nextX] = grid[currentPosition.y][currentPosition.x] + 1;
                }
            }
        }
        System.out.println("-1");
    }
}

class Position {
    int x;
    int y;

    public Position(int y, int x) {
        this.x = x;
        this.y = y;
    }
}