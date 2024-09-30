//Question No: 1913
//Title: 달팽이
//Tier: Silver III
import java.util.*;
import java.io.*;

public class Main {

    static int gridSize, targetNumber;
    static int[][] grid;

    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();

        gridSize = Integer.parseInt(inputReader.readLine());
        targetNumber = Integer.parseInt(inputReader.readLine());

        grid = new int[gridSize][gridSize];

        int directionIndex = 0;
        int currentX = 0;
        int currentY = 0;

        grid[currentX][currentY] = gridSize * gridSize;

        while (directionIndex < 4) {
            int nextX = currentX + moveX[directionIndex];
            int nextY = currentY + moveY[directionIndex];

            if (nextX >= 0 && nextY >= 0 && nextX < gridSize && nextY < gridSize && grid[nextX][nextY] == 0) {
                grid[nextX][nextY] = grid[currentX][currentY] - 1;

                if (grid[nextX][nextY] == 1) break;

                currentX = nextX;
                currentY = nextY;
            } else {
                directionIndex++;
            }

            if (directionIndex >= 4) {
                directionIndex = 0;
            }
        }

        int answerX = 0, answerY = 0;
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                if (grid[i][j] == targetNumber) {
                    answerX = i + 1;
                    answerY = j + 1;
                }
                outputBuilder.append(grid[i][j]).append(" ");
            }
            outputBuilder.append("\n");
        }
        outputBuilder.append(answerX).append(" ").append(answerY);

        System.out.println(outputBuilder);
    }
}