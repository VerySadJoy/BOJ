//Question No: 14503
//Title: 로봇 청소기
//Tier: Gold V
import java.util.Scanner;

public class Main {    

    static int rows, columns, startX, startY, direction;
    static int[][] grid;
    static int cleanedCount = 1;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        rows = scanner.nextInt();
        columns = scanner.nextInt();
        startX = scanner.nextInt();
        startY = scanner.nextInt();
        direction = scanner.nextInt();

        grid = new int[rows][columns];
        for(int i = 0; i < rows; i++) {
            for(int j = 0; j < columns; j++) {
                grid[i][j] = scanner.nextInt();
            }
        }

        cleanRoom(startX, startY, direction);
        System.out.println(cleanedCount);
    }    

    public static void cleanRoom(int x, int y, int currentDirection) {
        grid[x][y] = -1; 

        for(int i = 0; i < 4; i++) {
            currentDirection = (currentDirection + 3) % 4;

            int nextX = x + dx[currentDirection];
            int nextY = y + dy[currentDirection];
            if(nextX >= 0 && nextY >= 0 && nextX < rows && nextY < columns) {
                if(grid[nextX][nextY] == 0) {
                    cleanedCount++;
                    cleanRoom(nextX, nextY, currentDirection);
                    return;
                }
            }
        }

        int backwardDirection = (currentDirection + 2) % 4;
        int backX = x + dx[backwardDirection];
        int backY = y + dy[backwardDirection];
        if(backX >= 0 && backY >= 0 && backX < rows && backY < columns && grid[backX][backY] != 1) {
            cleanRoom(backX, backY, currentDirection);
        }
    }
}