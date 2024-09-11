//Question No: 6186
//Title: Best Grass
//Tier: Silver V
import java.util.Scanner;

public class Main {
    static int rows, cols;
    static char[][] pasture;
    static boolean[][] visited;
    static int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int count = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        rows = scanner.nextInt();
        cols = scanner.nextInt();
        scanner.nextLine();

        pasture = new char[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            pasture[i] = scanner.nextLine().toCharArray();
        }

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < cols; y++) {
                if (!visited[x][y] && pasture[x][y] == '#') {
                    dfs(x, y);
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void dfs(int x, int y) {
        visited[x][y] = true;
        for (int[] direction : directions) {
            int newX = x + direction[0];
            int newY = y + direction[1];
            if (newX >= 0 && newX < rows && newY >= 0 && newY < cols) {
                if (!visited[newX][newY] && pasture[newX][newY] == '#') {
                    dfs(newX, newY);
                }
            }
        }
    }
}