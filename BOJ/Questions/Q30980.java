//Question No: 30980
//Title: 여중생 파댕이와 공부를
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int HEIGHT_GAP = 3;
    static final int WIDTH_GAP = 8;
    static int rows, cols;
    static char[][] grid;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken()) * HEIGHT_GAP;
        cols = Integer.parseInt(tokenizer.nextToken()) * WIDTH_GAP;

        grid = new char[rows][cols];

        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            for (int j = 0; j < cols; j++) {
                grid[i][j] = line.charAt(j);
            }
        }

        for (int row = 0; row < rows; row += HEIGHT_GAP) {
            for (int col = 0; col < cols; col += WIDTH_GAP) {
                int a = grid[row + 1][col + 1] - '0';
                int b = grid[row + 1][col + 3] - '0';
                int c = grid[row + 1][col + 5] - '0';
                if (grid[row + 1][col + 6] != '.') {
                    c = c * 10 + (grid[row + 1][col + 6] - '0');
                }

                if (a + b == c) {
                    int length = (c >= 10 ? 7 : 6);
                    grid[row + 1][col] = '*';
                    grid[row + 1][col + length] = '*';
                    for (int i = 1; i < length; i++) {
                        grid[row][col + i] = '*';
                        grid[row + 2][col + i] = '*';
                    }
                } else {
                    for (int i = 0; i < 3; i++) {
                        grid[row + i][col + 3 - i] = '/';
                    }
                }
            }
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                output.append(grid[i][j]);
            }
            output.append("\n");
        }

        System.out.print(output.toString());
    }
}