//Question No: 14391
//Title: 종이 조각
//Tier: Gold III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    public static int maxSum = -1;
    public static int rows;
    public static int cols;
    public static int[][] numberGrid;
    public static boolean[][] sliceGrid;

    public static void main(String[] args) throws Exception {
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        String[] dimensions = inputReader.readLine().split(" ");
        rows = Integer.parseInt(dimensions[0]);
        cols = Integer.parseInt(dimensions[1]);

        numberGrid = new int[rows][cols];
        sliceGrid = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            char[] line = inputReader.readLine().toCharArray();
            for (int j = 0; j < cols; j++) {
                numberGrid[i][j] = Integer.parseInt(String.valueOf(line[j]));
            }
        }

        calculateMaxSum(0, 0);
        outputWriter.write(maxSum + "\n");

        outputWriter.flush();
        outputWriter.close();
        inputReader.close();
    }

    public static void calculateMaxSum(int x, int y) {
        if (x == rows) {
            calculateSum();
            return;
        }
        if (y == cols) {
            calculateMaxSum(x + 1, 0);
            return;
        }
        sliceGrid[x][y] = true;
        calculateMaxSum(x, y + 1);
        sliceGrid[x][y] = false;
        calculateMaxSum(x, y + 1);
    }

    public static void calculateSum() {
        int totalSum = 0;

        for (int i = 0; i < rows; i++) {
            int horizontalSum = 0;
            for (int j = 0; j < cols; j++) {
                if (sliceGrid[i][j]) {
                    horizontalSum = horizontalSum * 10 + numberGrid[i][j];
                } else {
                    totalSum += horizontalSum;
                    horizontalSum = 0;
                }
            }
            totalSum += horizontalSum;
        }

        for (int i = 0; i < cols; i++) {
            int verticalSum = 0;
            for (int j = 0; j < rows; j++) {
                if (!sliceGrid[j][i]) {
                    verticalSum = verticalSum * 10 + numberGrid[j][i];
                } else {
                    totalSum += verticalSum;
                    verticalSum = 0;
                }
            }
            totalSum += verticalSum;
        }

        maxSum = Math.max(maxSum, totalSum);
    }
}