//Question No: 9291
//Title: 스도쿠 채점
//Tier: Silver IV
import java.io.DataInputStream;
import java.io.IOException;

public class Main {
    private static boolean checkRowsAndColumns(int[][] grid) {
        for (int i = 0; i < 9; i++) {
            boolean[] rowCheck = new boolean[10];
            boolean[] colCheck = new boolean[10];
            for (int j = 0; j < 9; j++) {
                if (rowCheck[grid[i][j]]) return false;
                rowCheck[grid[i][j]] = true;
                if (colCheck[grid[j][i]]) return false;
                colCheck[grid[j][i]] = true;
            }
        }
        return true;
    }

    private static boolean checkSubgrids(int[][] grid) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                boolean[] check = new boolean[10];
                for (int i = row * 3; i < row * 3 + 3; i++) {
                    for (int j = col * 3; j < col * 3 + 3; j++) {
                        if (check[grid[i][j]]) return false;
                        check[grid[i][j]] = true;
                    }
                }
            }
        }
        return true;
    }

    private static void processSudokuCases() throws Exception {
        int testCases = nextInt();
        StringBuilder resultBuilder = new StringBuilder();
        for (int t = 1; t <= testCases; t++) {
            int[][] grid = new int[9][9];
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    grid[i][j] = nextInt();
                }
            }
            resultBuilder.append("Case ").append(t).append(": ");
            if (!checkRowsAndColumns(grid) || !checkSubgrids(grid)) {
                resultBuilder.append("INCORRECT\n");
            } else {
                resultBuilder.append("CORRECT\n");
            }
        }
        System.out.print(resultBuilder);
    }

    public static void main(String[] args) throws Exception {
        initializeInput();
        processSudokuCases();
    }

    private static final int BUFFER_SIZE = 1 << 16;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int currentIndex, maxIndex;

    private static void initializeInput() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[BUFFER_SIZE];
        currentIndex = maxIndex = 0;
    }

    private static int nextInt() throws IOException {
        int number = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean negative = (c == '-');
        if (negative) c = read();
        do {
            number = number * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
        if (negative) return -number;
        return number;
    }

    private static byte read() throws IOException {
        if (currentIndex == maxIndex) {
            maxIndex = inputStream.read(buffer, currentIndex = 0, BUFFER_SIZE);
            if (maxIndex == -1) buffer[0] = -1;
        }
        return buffer[currentIndex++];
    }
}
