//Question No: 1799
//Title: 비숍
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    public static BufferedReader reader;
    public static BufferedWriter writer;
    public static int size, tempResult;
    public static int[][] board;
    public static int[] dx = {-1, 1, 1, -1};
    public static int[] dy = {1, 1, -1, -1};

    public static boolean isSafe(int x, int y) {
        for (int d = 0; d < 4; d++) {
            int amount = 1;
            while(true) {
                int X = x + amount * dx[d];
                int Y = y + amount * dy[d];
                if (X < 0 || Y < 0 || X >= size || Y >= size)
                    break;
                if (board[X][Y] == 2) return false;
                amount++;
            }
        }
        return true;
    }

    public static int calculateIncrement(int index) {
        if (size % 2 == 1) return 2;
        if (index % size == size - 1) return 1;
        else if (index % size == size - 2) return 3;
        else return 2;
    }

    public static void dfs(int index, int count) {
        if (index >= size * size) {
            tempResult = Math.max(tempResult, count);
            return;
        }
        int y = index % size;
        int x = index / size;
        int increment = calculateIncrement(index);

        if (board[x][y] == 0) {
            dfs(index + increment, count);
            return;
        }

        if (isSafe(x, y)) {
            board[x][y] = 2;
            dfs(index + increment, count + 1);
            board[x][y] = 1;
        }
        dfs(index + increment, count);
    }


    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        writer = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(reader.readLine());
        board = new int[size][size];
        for (int i = 0; i < size; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int result = 0;
        tempResult = 0;
        dfs(0, 0);
        result += tempResult;
        tempResult = 0;
        dfs(1, 0);
        result += tempResult;
        writer.write(result + "\n");
        writer.flush();
    }
}
