//Question No: 1388
//Title: 바닥 장식
//Tier: Silver IV
import java.util.Scanner;

public class Main {
    static int rows, cols;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();

        grid = new char[rows][cols];
        for (int i = 0; i < rows; i++) {
            grid[i] = scanner.nextLine().toCharArray();
        }

        int regionCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '-' || grid[i][j] == '|') {
                    exploreRegion(i, j);
                    regionCount++;
                }
            }
        }

        System.out.println(regionCount);
        scanner.close();
    }

    private static void exploreRegion(int x, int y) {
        if (grid[x][y] == '-') {
            grid[x][y] = '1';
            for (int offsetY : new int[]{1, -1}) {
                int newY = y + offsetY;
                if (newY >= 0 && newY < cols && grid[x][newY] == '-') {
                    exploreRegion(x, newY);
                }
            }
        } else if (grid[x][y] == '|') {
            grid[x][y] = '1';
            for (int offsetX : new int[]{1, -1}) {
                int newX = x + offsetX;
                if (newX >= 0 && newX < rows && grid[newX][y] == '|') {
                    exploreRegion(newX, y);
                }
            }
        }
    }
}