//Question No: 1559
//Title: 놀라운 미로
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int rows, cols, boxesCount;
    static int[] directionMap = new int[128];
    static int[][] doors = new int[100][100], boxes = new int[100][100];
    static int[][][][] visited = new int[4][256][100][100];
    static int[] rowMove = {-1, 0, 1, 0}, colMove = {0, 1, 0, -1};

    static class Node {
        int row, col, collected;
        Node(int row, int col, int collected) {
            this.row = row;
            this.col = col;
            this.collected = collected;
        }
    }

    public static void main(String[] args) throws IOException {
        directionMap['N'] = 0;
        directionMap['E'] = 1;
        directionMap['S'] = 2;
        directionMap['W'] = 3;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        for (int testCase = 1; ; testCase++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            rows = Integer.parseInt(tokenizer.nextToken());
            cols = Integer.parseInt(tokenizer.nextToken());

            if (rows == 0 && cols == 0) break;

            for (int r = 0; r < rows; r++) {
                String line = reader.readLine();
                for (int c = 0; c < cols; c++) {
                    doors[r][c] = directionMap[line.charAt(c)];
                }
            }

            for (int[] row : boxes) Arrays.fill(row, -1);
            boxesCount = Integer.parseInt(reader.readLine());
            for (int k = 0; k < boxesCount; k++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int boxRow = Integer.parseInt(tokenizer.nextToken()) - 1;
                int boxCol = Integer.parseInt(tokenizer.nextToken()) - 1;
                boxes[boxRow][boxCol] = k;
            }

            int time = 0;
            visited[3][0][0][0] = testCase;
            Queue<Node> queue = new LinkedList<>();
            queue.add(new Node(0, 0, 0));

            while (!queue.isEmpty()) {
                int queueSize = queue.size();
                while (queueSize-- > 0) {
                    Node current = queue.poll();
                    int row = current.row, col = current.col, collected = current.collected;

                    if (boxes[row][col] >= 0) {
                        collected |= (1 << boxes[row][col]);
                    }
                    if (collected == (1 << boxesCount) - 1 && row == rows - 1 && col == cols - 1) {
                        output.append(time).append("\n");
                        queue.clear();
                        break;
                    }

                    if (visited[time % 4][collected][row][col] != testCase) {
                        visited[time % 4][collected][row][col] = testCase;
                        queue.add(new Node(row, col, collected));
                    }

                    int newRow = row + rowMove[(doors[row][col] + time) % 4];
                    int newCol = col + colMove[(doors[row][col] + time) % 4];

                    if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols) {
                        if (visited[time % 4][collected][newRow][newCol] != testCase) {
                            visited[time % 4][collected][newRow][newCol] = testCase;
                            queue.add(new Node(newRow, newCol, collected));
                        }
                    }
                }
                time++;
            }
        }

        System.out.print(output);
    }
}