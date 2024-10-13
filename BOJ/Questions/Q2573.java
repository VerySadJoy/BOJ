//Question No: 2573
//Title: 빙산
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Iceberg {
    int row;
    int column;

    Iceberg(int row, int column) {
        this.row = row;
        this.column = column;
    }
}

public class Main {
    static int[] rowOffsets = { -1, 0, 1, 0 };
    static int[] columnOffsets = { 0, 1, 0, -1 };

    static int rows, columns;
    static int[][] grid;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());

        grid = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        int timeElapsed = 0;
        int icebergCount = 0;

        while ((icebergCount = countIcebergs()) < 2) {
            if (icebergCount == 0) {
                timeElapsed = 0;
                break;
            }

            meltIcebergs();
            timeElapsed++;
        }

        writer.write(timeElapsed + "\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int countIcebergs() {
        boolean[][] visited = new boolean[rows][columns];
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    depthFirstSearch(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    public static void depthFirstSearch(int row, int column, boolean[][] visited) {
        visited[row][column] = true;

        for (int i = 0; i < 4; i++) {
            int newRow = row + rowOffsets[i];
            int newColumn = column + columnOffsets[i];

            if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns) {
                continue;
            }

            if (grid[newRow][newColumn] != 0 && !visited[newRow][newColumn]) {
                depthFirstSearch(newRow, newColumn, visited);
            }
        }
    }

    public static void meltIcebergs() {
        Queue<Iceberg> queue = new LinkedList<>();
        boolean[][] visited = new boolean[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] != 0) {
                    queue.offer(new Iceberg(i, j));
                    visited[i][j] = true;
                }
            }
        }

        while (!queue.isEmpty()) {
            Iceberg iceberg = queue.poll();
            int seaCount = 0;

            for (int i = 0; i < 4; i++) {
                int newRow = iceberg.row + rowOffsets[i];
                int newColumn = iceberg.column + columnOffsets[i];

                if (newRow < 0 || newColumn < 0 || newRow >= rows || newColumn >= columns) {
                    continue;
                }

                if (!visited[newRow][newColumn] && grid[newRow][newColumn] == 0) {
                    seaCount++;
                }
            }

            if (grid[iceberg.row][iceberg.column] - seaCount < 0) {
                grid[iceberg.row][iceberg.column] = 0;
            } else {
                grid[iceberg.row][iceberg.column] -= seaCount;
            }
        }
    }
}