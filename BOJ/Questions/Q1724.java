//Question No: 1724
//Title: 그림판
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    private static class Position {
        public int row, col;

        public Position(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int rows = Integer.parseInt(tokenizer.nextToken());
        int cols = Integer.parseInt(tokenizer.nextToken());

        boolean[][] grid = new boolean[2 * rows + 1][2 * cols + 1];
        int lineCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < lineCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int startRow = Integer.parseInt(tokenizer.nextToken());
            int startCol = Integer.parseInt(tokenizer.nextToken());
            int endRow = Integer.parseInt(tokenizer.nextToken());
            int endCol = Integer.parseInt(tokenizer.nextToken());

            markGrid(grid, startRow, startCol, endRow, endCol);
        }

        boolean[][] visited = new boolean[2 * rows + 1][2 * cols + 1];
        int largestRoom = 0;
        int smallestRoom = rows * cols;

        for (int r = 0; r <= 2 * rows; r++) {
            for (int c = 0; c <= 2 * cols; c++) {
                if (!visited[r][c] && !grid[r][c]) {
                    int roomSize = exploreRoom(grid, visited, r, c, rows, cols);
                    largestRoom = Math.max(largestRoom, roomSize);
                    smallestRoom = Math.min(smallestRoom, roomSize);
                }
            }
        }

        System.out.println(largestRoom);
        System.out.println(smallestRoom);
    }

    private static void markGrid(boolean[][] grid, int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow) {
            for (int col = Math.min(startCol, endCol) * 2; col <= Math.max(startCol, endCol) * 2; col++) {
                grid[startRow * 2][col] = true;
            }
        } else if (startCol == endCol) {
            for (int row = Math.min(startRow, endRow) * 2; row <= Math.max(startRow, endRow) * 2; row++) {
                grid[row][startCol * 2] = true;
            }
        }
    }

    private static int exploreRoom(boolean[][] grid, boolean[][] visited, int startRow, int startCol, int rows, int cols) {
        int[] rowDir = { -1, 1, 0, 0 };
        int[] colDir = { 0, 0, -1, 1 };
        Queue<Position> queue = new LinkedList<>();
        queue.add(new Position(startRow, startCol));
        visited[startRow][startCol] = true;

        int roomSize = 0;

        while (!queue.isEmpty()) {
            Position current = queue.poll();

            if (current.row % 2 == 1 && current.col % 2 == 1) {
                roomSize++;
            }

            for (int d = 0; d < 4; d++) {
                int nextRow = current.row + rowDir[d];
                int nextCol = current.col + colDir[d];

                if (isInBounds(nextRow, nextCol, rows, cols) && !visited[nextRow][nextCol] && !grid[nextRow][nextCol]) {
                    visited[nextRow][nextCol] = true;
                    queue.add(new Position(nextRow, nextCol));
                }
            }
        }

        return roomSize;
    }

    private static boolean isInBounds(int row, int col, int rows, int cols) {
        return row >= 0 && row <= 2 * rows && col >= 0 && col <= 2 * cols;
    }
}