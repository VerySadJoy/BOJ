//Question No: 24725
//Title: 엠비티아이
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int MAX_SIZE = 201;
    static int rows, columns;
    static char[][] grid = new char[MAX_SIZE][MAX_SIZE];
    static int[] deltaY = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] deltaX = {-1, 0, 1, -1, 1, -1, 0, 1};

    static int findPattern(int y, int x) {
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int newY = y + deltaY[i];
            int newX = x + deltaX[i];
            if (newY < 0 || newX < 0 || newY >= rows || newX >= columns) continue;

            if (grid[newY][newX] == 'N' || grid[newY][newX] == 'S') {
                newY += deltaY[i];
                newX += deltaX[i];
                if (newY < 0 || newX < 0 || newY >= rows || newX >= columns) continue;

                if (grid[newY][newX] == 'F' || grid[newY][newX] == 'T') {
                    newY += deltaY[i];
                    newX += deltaX[i];
                    if (newY < 0 || newX < 0 || newY >= rows || newX >= columns) continue;

                    if (grid[newY][newX] == 'P' || grid[newY][newX] == 'J') {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        int result = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 'E' || grid[i][j] == 'I') {
                    result += findPattern(i, j);
                }
            }
        }

        System.out.println(result);
    }
}