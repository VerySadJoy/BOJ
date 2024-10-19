//Question No: 14890
//Title: 경사로
//Tier: Gold III
import java.util.Scanner;

public class Main {

    static int gridSize, slopeLength;
    static int[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        gridSize = scanner.nextInt();
        slopeLength = scanner.nextInt();

        grid = new int[gridSize][gridSize];
        for (int i = 0; i < gridSize; i++) {
            for (int j = 0; j < gridSize; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        int pathCount = 0;
        for (int i = 0; i < gridSize; i++) {
            if (checkRow(i)) pathCount++;
            if (checkColumn(i)) pathCount++;
        }
        System.out.println(pathCount);
    }

    public static boolean checkRow(int row) {
        boolean[] slopeInstalled = new boolean[gridSize];

        for (int i = 0; i < gridSize - 1; i++) {
            int heightDifference = grid[row][i] - grid[row][i + 1];

            if (heightDifference > 1 || heightDifference < -1) return false;
            else if (heightDifference == -1) {
                for (int j = 0; j < slopeLength; j++) {
                    if (i - j < 0 || slopeInstalled[i - j]) return false;
                    if (grid[row][i] != grid[row][i - j]) return false;
                    slopeInstalled[i - j] = true;
                }
            } else if (heightDifference == 1) {
                for (int j = 1; j <= slopeLength; j++) {
                    if (i + j >= gridSize || slopeInstalled[i + j]) return false;
                    if (grid[row][i] - 1 != grid[row][i + j]) return false;
                    slopeInstalled[i + j] = true;
                }
            }
        }
        return true;
    }

    public static boolean checkColumn(int column) {
        boolean[] slopeInstalled = new boolean[gridSize];

        for (int i = 0; i < gridSize - 1; i++) {
            int heightDifference = grid[i][column] - grid[i + 1][column];

            if (heightDifference > 1 || heightDifference < -1) return false;
            else if (heightDifference == -1) {
                for (int j = 0; j < slopeLength; j++) {
                    if (i - j < 0 || slopeInstalled[i - j]) return false;
                    if (grid[i][column] != grid[i - j][column]) return false;
                    slopeInstalled[i - j] = true;
                }
            } else if (heightDifference == 1) {
                for (int j = 1; j <= slopeLength; j++) {
                    if (i + j >= gridSize || slopeInstalled[i + j]) return false;
                    if (grid[i][column] - 1 != grid[i + j][column]) return false;
                    slopeInstalled[i + j] = true;
                }
            }
        }
        return true;
    }
}