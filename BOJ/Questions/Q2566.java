//Question No: 2566
//Title: 최댓값
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int row, col;
        int maxValue = 0;
        int maxRow = 1, maxCol = 1;

        int[][] grid = new int[9][9];

        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                grid[row][col] = scanner.nextInt();
            }
        }

        for (row = 0; row < 9; row++) {
            for (col = 0; col < 9; col++) {
                if (grid[row][col] > maxValue) {
                    maxValue = grid[row][col];
                    maxRow = row + 1;
                    maxCol = col + 1;
                }
            }
        }
        scanner.close();

        System.out.println(maxValue);
        System.out.println(maxRow + " " + maxCol);
    }
}