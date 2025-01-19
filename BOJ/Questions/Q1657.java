//Question No: 1657
//Title: 두부장수 장홍준
//Tier: Platinum III
import java.util.*;
import java.io.*;

public class Main {
    static int rows, cols;
    static char[] tofuBoard;
    static int[][] scoreBoard;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        rows = Integer.parseInt(tokenizer.nextToken());
        cols = Integer.parseInt(tokenizer.nextToken());
        tofuBoard = new char[rows * cols];

        int index = 0;
        for (int i = 0; i < rows; i++) {
            String line = reader.readLine();
            for (int j = 0; j < cols; j++) {
                tofuBoard[index++] = line.charAt(j);
            }
        }

        initializeScoreBoard();
        initializeDP();

        System.out.println(recursiveSolve(0, 0));
    }

    public static int recursiveSolve(int current, int state) {
        if (current >= rows * cols) return 0;
        if (dp[current][state] != -1) return dp[current][state];
        if ((state & 1) != 0) return recursiveSolve(current + 1, state >> 1);

        int maxScore = 0;

        // Skip current cell
        maxScore = Math.max(maxScore, recursiveSolve(current + 1, state >> 1));

        // Place a 2x1 block
        if (current + cols < rows * cols) {
            maxScore = Math.max(maxScore, 
                scoreBoard[tofuBoard[current] - 'A'][tofuBoard[current + cols] - 'A'] + 
                recursiveSolve(current + 1, (state >> 1) | (1 << (cols - 1))));
        }

        // Place a 1x2 block
        if (current % cols != cols - 1 && (state & (1 << 1)) == 0) {
            maxScore = Math.max(maxScore, 
                scoreBoard[tofuBoard[current] - 'A'][tofuBoard[current + 1] - 'A'] + 
                recursiveSolve(current + 2, state >> 2));
        }

        dp[current][state] = maxScore;
        return maxScore;
    }

    private static void initializeDP() {
        dp = new int[rows * cols][1 << cols];
        for (int i = 0; i < rows * cols; i++) {
            Arrays.fill(dp[i], -1);
        }
    }

    private static void initializeScoreBoard() {
        scoreBoard = new int[6][6];
        scoreBoard[0] = new int[]{10, 8, 7, 5, 0, 1};
        scoreBoard[1] = new int[]{8, 6, 4, 3, 0, 1};
        scoreBoard[2] = new int[]{7, 4, 3, 2, 0, 1};
        scoreBoard[3] = new int[]{5, 3, 2, 2, 0, 1};
        scoreBoard[4] = new int[]{0, 0, 0, 0, 0, 0};
        scoreBoard[5] = new int[]{1, 1, 1, 1, 0, 0};
    }
}