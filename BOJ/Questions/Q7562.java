//Question No: 7562
//Title: 나이트의 이동
//Tier: Silver I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int boardSize;
    static int startX, startY, endX, endY;
    static int[][] moves;
    static boolean[][] visited;
    static int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
    static int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer;
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 1; i <= testCases; i++) {
            boardSize = Integer.parseInt(reader.readLine());

            moves = new int[boardSize][boardSize];
            visited = new boolean[boardSize][boardSize];

            tokenizer = new StringTokenizer(reader.readLine());
            startX = Integer.parseInt(tokenizer.nextToken());
            startY = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            endX = Integer.parseInt(tokenizer.nextToken());
            endY = Integer.parseInt(tokenizer.nextToken());

            bfs();

            result.append(moves[endX][endY]).append("\n");
        }
        System.out.println(result);
    }

    public static void bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{startX, startY});
        visited[startX][startY] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int currentX = current[0];
            int currentY = current[1];

            for (int i = 0; i < 8; i++) {
                int nextX = currentX + dx[i];
                int nextY = currentY + dy[i];

                if (nextX >= 0 && nextY >= 0 && nextX < boardSize && nextY < boardSize) {
                    if (!visited[nextX][nextY]) {
                        queue.add(new int[]{nextX, nextY});
                        moves[nextX][nextY] = moves[currentX][currentY] + 1;
                        visited[nextX][nextY] = true;
                    }
                }
            }
        }
    }
}