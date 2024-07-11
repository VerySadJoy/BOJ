//Question No: 14939
//Title: 불 끄기
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    private static final int MAX = 10;
    private static final int INF = 1000000000;
    private static boolean[][] arr = new boolean[MAX][MAX];
    private static int[] dx = {0, 0, 1, -1};
    private static int[] dy = {1, -1, 0, 0};
    private static int minSteps = INF;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < MAX; i++) {
            String line = reader.readLine();
            for (int j = 0; j < MAX; j++) {
                arr[i][j] = line.charAt(j) == 'O';
            }
        }
        solveFirstLine(0, 0, arr);
        System.out.println(minSteps == INF ? -1 : minSteps);
    }

    private static boolean isOutOfRange(int x, int y) {
        return x < 0 || x >= MAX || y < 0 || y >= MAX;
    }

    private static void toggle(int x, int y, boolean[][] tempArr) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (!isOutOfRange(nx, ny)) {
                tempArr[nx][ny] = !tempArr[nx][ny];
            }
        }
        tempArr[x][y] = !tempArr[x][y];
    }

    private static boolean isLightOn(boolean[][] tempArr) {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (tempArr[i][j]) {
                    return true;
                }
            }
        }
        return false;
    }

    private static void copyArray(boolean[][] source, boolean[][] dest1, boolean[][] dest2) {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                dest1[i][j] = source[i][j];
                dest2[i][j] = source[i][j];
            }
        }
    }

    private static void solveFirstLine(int x, int sum, boolean[][] tempArr) {
        if (x == MAX) {
            boolean[][] tempArrCopy = new boolean[MAX][MAX];
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    tempArrCopy[i][j] = tempArr[i][j];
                }
            }

            for (int i = 1; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    if (tempArrCopy[i - 1][j]) {
                        toggle(i, j, tempArrCopy);
                        sum++;
                    }
                }
            }

            if (!isLightOn(tempArrCopy)) {
                minSteps = Math.min(minSteps, sum);
            }
            return;
        }

        boolean[][] tempArr1 = new boolean[MAX][MAX];
        boolean[][] tempArr2 = new boolean[MAX][MAX];
        copyArray(tempArr, tempArr1, tempArr2);

        solveFirstLine(x + 1, sum, tempArr1);

        toggle(0, x, tempArr2);
        solveFirstLine(x + 1, sum + 1, tempArr2);
    }
}
