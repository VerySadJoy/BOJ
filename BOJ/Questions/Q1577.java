//Question No: 1577
//Title: 도로의 개수
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int columns, rows, closedPaths, startY, startX, endY, endX;
    static long[][] pathCounts;
    static boolean[][][] roadStatus;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        columns = Integer.parseInt(tokenizer.nextToken());
        rows = Integer.parseInt(tokenizer.nextToken());
        closedPaths = Integer.parseInt(inputReader.readLine());
        roadStatus = new boolean[rows + 1][columns + 1][2];

        for (int i = 0; i < closedPaths; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine());
            startY = Integer.parseInt(tokenizer.nextToken());
            startX = Integer.parseInt(tokenizer.nextToken());
            endY = Integer.parseInt(tokenizer.nextToken());
            endX = Integer.parseInt(tokenizer.nextToken());

            if (startY < endY || startX < endX) {
                if (startY < endY) {
                    roadStatus[startX][startY][0] = true;
                } else {
                    roadStatus[startX][startY][1] = true;
                }
            } else {
                if (endY < startY) {
                    roadStatus[endX][endY][0] = true;
                } else {
                    roadStatus[endX][endY][1] = true;
                }
            }
        }

        pathCounts = new long[rows + 1][columns + 1];

        for (int i = 1; i <= columns; i++) {
            if (roadStatus[0][i - 1][0]) break;
            pathCounts[0][i] = 1;
        }

        for (int i = 1; i <= rows; i++) {
            if (roadStatus[i - 1][0][1]) break;
            pathCounts[i][0] = 1;
        }

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= columns; j++) {
                if (!roadStatus[i][j - 1][0]) pathCounts[i][j] += pathCounts[i][j - 1];
                if (!roadStatus[i - 1][j][1]) pathCounts[i][j] += pathCounts[i - 1][j];
            }
        }

        System.out.println(pathCounts[rows][columns]);
    }
}