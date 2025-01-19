//Question No: 31404
//Title: 아리스, 청소합니다! (Easy)
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 65;
    static int height, width, startRow, startCol, startDir;
    static int[][] map = new int[MAX][MAX];
    static int[][] matrixA = new int[MAX][MAX];
    static int[][] matrixB = new int[MAX][MAX];
    static boolean[][][] visited = new boolean[MAX][MAX][4];
    static int[] moveY = {-1, 0, 1, 0};
    static int[] moveX = {0, 1, 0, -1};
    static int answer;

    static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        height = Integer.parseInt(tokenizer.nextToken());
        width = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        startRow = Integer.parseInt(tokenizer.nextToken());
        startCol = Integer.parseInt(tokenizer.nextToken());
        startDir = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < height; i++) {
            String row = reader.readLine();
            for (int j = 0; j < width; j++) {
                matrixA[i][j] = row.charAt(j) - '0';
            }
        }

        for (int i = 0; i < height; i++) {
            String row = reader.readLine();
            for (int j = 0; j < width; j++) {
                matrixB[i][j] = row.charAt(j) - '0';
            }
        }
    }

    static void initializeVisited() {
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                Arrays.fill(visited[i][j], false);
            }
        }
    }

    static void processSettings() {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(startRow, startCol, startDir, 0, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (map[current.row][current.col] == 0) {
                map[current.row][current.col] = 1;
                initializeVisited();
                int nextDir = (current.direction + matrixA[current.row][current.col]) % 4;
                int nextRow = current.row + moveY[nextDir];
                int nextCol = current.col + moveX[nextDir];

                if (isOutOfBounds(nextRow, nextCol)) {
                    answer = current.time + 1;
                    return;
                }

                queue.add(new Node(nextRow, nextCol, nextDir, current.time + 1, 0));
            } else {
                if (!visited[current.row][current.col][current.direction]) {
                    visited[current.row][current.col][current.direction] = true;
                    int nextDir = (current.direction + matrixB[current.row][current.col]) % 4;
                    int nextRow = current.row + moveY[nextDir];
                    int nextCol = current.col + moveX[nextDir];

                    if (isOutOfBounds(nextRow, nextCol)) {
                        answer = current.time - current.loopCount;
                        return;
                    }

                    queue.add(new Node(nextRow, nextCol, nextDir, current.time + 1, current.loopCount + 1));
                } else {
                    answer = current.time - current.loopCount;
                    return;
                }
            }
        }
    }

    static boolean isOutOfBounds(int row, int col) {
        return row < 0 || row >= height || col < 0 || col >= width;
    }

    static void findAnswer() {
        System.out.println(answer);
    }

    public static void main(String[] args) throws IOException {
        input();
        processSettings();
        findAnswer();
    }

    static class Node {
        int row, col, direction, time, loopCount;

        Node(int row, int col, int direction, int time, int loopCount) {
            this.row = row;
            this.col = col;
            this.direction = direction;
            this.time = time;
            this.loopCount = loopCount;
        }
    }
}