//Question No: 2580
//Title: 스도쿠
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static final int SIZE = 9;
    private static final int[][] board = new int[SIZE][SIZE];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        for (int row = 0; row < SIZE; row++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int col = 0; col < SIZE; col++) {
                board[row][col] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        solveSudoku(0, 0);
    }

    private static void solveSudoku(int row, int col) {
        if (col == SIZE) {
            solveSudoku(row + 1, 0);
            return;
        }

        if (row == SIZE) {
            printBoard();
            System.exit(0);
        }

        if (board[row][col] == 0) {
            for (int num = 1; num <= SIZE; num++) {
                if (isValidPlacement(row, col, num)) {
                    board[row][col] = num;
                    solveSudoku(row, col + 1);
                }
            }
            board[row][col] = 0;
            return;
        }

        solveSudoku(row, col + 1);
    }

    private static boolean isValidPlacement(int row, int col, int num) {
        for (int i = 0; i < SIZE; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }

    private static void printBoard() {
        StringBuilder output = new StringBuilder();
        for (int row = 0; row < SIZE; row++) {
            for (int col = 0; col < SIZE; col++) {
                output.append(board[row][col]).append(' ');
            }
            output.append('\n');
        }
        System.out.print(output);
    }
}