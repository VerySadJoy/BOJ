//Question No: 17265
//Title: 나의 인생에는 수학과 함께
//Tier: Gold V
import java.util.Scanner;

public class Main {
    static int N;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};
    static int minValue = Integer.MAX_VALUE;
    static int maxValue = Integer.MIN_VALUE;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        grid = new char[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = scanner.next().charAt(0);
            }
        }

        solve(0, 0, grid[0][0] - '0');
        System.out.println(maxValue + " " + minValue);
    }

    public static void solve(int y, int x, int value) {
        if (y == N - 1 && x == N - 1) {
            minValue = Math.min(minValue, value);
            maxValue = Math.max(maxValue, value);
            return;
        }

        for (int i = 0; i < 2; i++) {
            int newY = y + dy[i];
            int newX = x + dx[i];
            if (newY >= N || newX >= N) continue;
            int newValue = value;
            if (grid[y][x] == '-') {
                newValue -= grid[newY][newX] - '0';
            } else if (grid[y][x] == '+') {
                newValue += grid[newY][newX] - '0';
            } else if (grid[y][x] == '*') {
                newValue *= grid[newY][newX] - '0';
            }
            solve(newY, newX, newValue);
        }
    }
}
