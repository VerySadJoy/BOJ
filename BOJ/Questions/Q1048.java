//Question No: 1048
//Title: 유니콘
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in), 1 << 16);
    private static final int MODULO = 1_000_000_007;
    private int rows, columns;

    public static void main(String[] args) throws Exception {
        new Main().run();
    }

    public void run() throws Exception {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());
        int maxCharValue = Integer.parseInt(tokenizer.nextToken());

        String targetString = reader.readLine();
        int targetLength = targetString.length();
        if (isInvalidTarget(maxCharValue, targetString, targetLength)) {
            System.out.println(0);
            return;
        }

        long[][][] dpTable = new long[targetLength][rows + 1][columns + 1];
        char[][] grid = new char[rows + 1][columns + 1];
        initializeGrid(rows, columns, targetString, dpTable, grid);

        for (int k = 1; k < targetLength; k++) {
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= columns; col++) {
                    if (grid[row][col] != targetString.charAt(k)) continue;
                    dpTable[k][row][col] = computeCases(dpTable[k - 1], row, col);
                }
            }

            // Compute prefix sums
            for (int row = 1; row <= rows; row++) {
                for (int col = 1; col <= columns; col++) {
                    dpTable[k][row][col] += dpTable[k][row - 1][col] + dpTable[k][row][col - 1] - dpTable[k][row - 1][col - 1];
                    dpTable[k][row][col] = mod(dpTable[k][row][col]);
                }
            }
        }
        System.out.println(dpTable[targetLength - 1][rows][columns]);
    }

    private boolean isInvalidTarget(int maxCharValue, String target, int length) {
        for (int i = 0; i < length; i++) {
            if (target.charAt(i) - 'A' + 1 > maxCharValue) {
                return true;
            }
        }
        return false;
    }

    private void initializeGrid(int rows, int cols, String target, long[][][] dpTable, char[][] grid) throws Exception {
        for (int i = 0; i < rows; i++) {
            String rowInput = reader.readLine();
            for (int j = 0; j < cols; j++) {
                grid[i + 1][j + 1] = rowInput.charAt(j);
                dpTable[0][i + 1][j + 1] = (grid[i + 1][j + 1] == target.charAt(0) ? 1 : 0)
                        + dpTable[0][i][j + 1] + dpTable[0][i + 1][j] - dpTable[0][i][j];
            }
        }
    }

    private long computeCases(long[][] previousDp, int row, int col) {
        long result = previousDp[rows][columns];
        result -= computeRangeSum(previousDp, row - 1, 1, row + 1, columns);
        result -= computeRangeSum(previousDp, 1, col - 1, rows, col + 1);
        result += computeRangeSum(previousDp, row - 1, col - 1, row + 1, col + 1);

        result -= computeRangeSum(previousDp, row - 2, col - 2, row - 2, col - 2);
        result -= computeRangeSum(previousDp, row + 2, col - 2, row + 2, col - 2);
        result -= computeRangeSum(previousDp, row - 2, col + 2, row - 2, col + 2);
        result -= computeRangeSum(previousDp, row + 2, col + 2, row + 2, col + 2);

        return mod(result);
    }

    private long computeRangeSum(long[][] arr, int rowStart, int colStart, int rowEnd, int colEnd) {
        if (rowStart == rowEnd && colStart == colEnd && (rowStart <= 0 || rowStart > rows || colStart <= 0 || colStart > columns)) {
            return 0;
        }

        if (rowStart == 0) rowStart = 1;
        if (rowStart == rows + 1) rowStart = rows;
        if (rowEnd == 0) rowEnd = 1;
        if (rowEnd == rows + 1) rowEnd = rows;
        if (colStart == 0) colStart = 1;
        if (colStart == columns + 1) colStart = columns;
        if (colEnd == 0) colEnd = 1;
        if (colEnd == columns + 1) colEnd = columns;

        long result = arr[rowEnd][colEnd] - arr[rowStart - 1][colEnd] - arr[rowEnd][colStart - 1] + arr[rowStart - 1][colStart - 1];
        return mod(result);
    }

    private long mod(long value) {
        while (value < 0) value += MODULO;
        return value % MODULO;
    }
}