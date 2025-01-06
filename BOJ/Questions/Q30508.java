//Question No: 30508
//Title: 고인물이싫어
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int rows, cols, height, width;
    static int[][] grid;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rows = Integer.parseInt(tokenizer.nextToken());
        cols = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());

        grid = new int[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int obstacleCount = Integer.parseInt(reader.readLine());
        Queue<Node> queue = new ArrayDeque<>();

        for (int i = 0; i < obstacleCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken()) - 1;
            int y = Integer.parseInt(tokenizer.nextToken()) - 1;
            queue.add(new Node(x, y));
            visited[x][y] = true;
        }

        bfs(queue);

        int result = 0;
        for (int i = 0; i <= rows - height; i++) {
            for (int j = 0; j <= cols - width; j++) {
                if (isValidArea(i, j)) {
                    result++;
                }
            }
        }

        System.out.println(result);
    }

    private static void bfs(Queue<Node> queue) {
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX >= 0 && nextX < rows && nextY >= 0 && nextY < cols && !visited[nextX][nextY]) {
                    if (grid[current.x][current.y] <= grid[nextX][nextY]) {
                        visited[nextX][nextY] = true;
                        queue.add(new Node(nextX, nextY));
                    }
                }
            }
        }
    }

    private static boolean isValidArea(int startX, int startY) {
        for (int x = 0; x < height; x++) {
            for (int y = 0; y < width; y++) {
                if (!visited[startX + x][startY + y]) {
                    return false;
                }
            }
        }
        return true;
    }

    static class Node {
        int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}