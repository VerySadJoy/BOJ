//Question No: 1520
//Title: 내리막 길
//Tier: Gold III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int rows, columns;
    static int[][] heightMatrix, pathCountMatrix;
    static int[] deltaX = { -1, 0, 1, 0 };
    static int[] deltaY = { 0, 1, 0, -1 };

    public static void main(String[] args) throws NumberFormatException, IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out))) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            
            rows = Integer.parseInt(stringTokenizer.nextToken());
            columns = Integer.parseInt(stringTokenizer.nextToken());
            
            heightMatrix = new int[rows + 1][columns + 1];
            for (int i = 1; i <= rows; i++) {
                stringTokenizer = new StringTokenizer(bufferedReader.readLine());
                for (int j = 1; j <= columns; j++) {
                    heightMatrix[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                }
            }
            
            pathCountMatrix = new int[rows + 1][columns + 1];
            for (int i = 1; i <= rows; i++) {
                for (int j = 1; j <= columns; j++) {
                    pathCountMatrix[i][j] = -1;
                }
            }
            
            bufferedWriter.write(findPaths(1, 1) + "\n");
            bufferedWriter.flush();
        }
    }

    public static int findPaths(int x, int y) {
        if (x == rows && y == columns) {
            return 1;
        }

        if (pathCountMatrix[x][y] != -1) {
            return pathCountMatrix[x][y];
        }

        pathCountMatrix[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + deltaX[i];
            int nextY = y + deltaY[i];

            if (nextX < 1 || nextY < 1 || nextX > rows || nextY > columns) {
                continue;
            }

            if (heightMatrix[x][y] > heightMatrix[nextX][nextY]) {
                pathCountMatrix[x][y] += findPaths(nextX, nextY);
            }
        }

        return pathCountMatrix[x][y];
    }
}