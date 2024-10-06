//Question No: 25682
//Title: 체스판 다시 칠하기 2
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {
    static int totalRows, totalColumns, squareSize, maxBlack = Integer.MIN_VALUE, minBlack = Integer.MAX_VALUE;
    static int[][] colorBoard;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine(), " ");

        totalRows = Integer.parseInt(tokenizer.nextToken());
        totalColumns = Integer.parseInt(tokenizer.nextToken());
        squareSize = Integer.parseInt(tokenizer.nextToken());

        colorBoard = new int[totalRows + 1][totalColumns + 1];
        boolean isBlack = false;

        for (int i = 1; i <= totalRows; i++) {
            String line = inputReader.readLine();
            for (int j = 1; j <= totalColumns; j++) {
                char currentColor = line.charAt(j - 1);
                if (!isBlack && currentColor == 'W') {
                    colorBoard[i][j] = 1;
                } else if (isBlack && currentColor == 'B') {
                    colorBoard[i][j] = 1;
                }
                isBlack = !isBlack;
            }
            if (totalColumns % 2 == 0) {
                isBlack = !isBlack;
            }
        }

        for (int i = 1; i <= totalRows; i++) {
            int rowSum = colorBoard[i][1];
            for (int j = 2; j <= totalColumns; j++) {
                rowSum += colorBoard[i][j];
                colorBoard[i][j] = rowSum;
            }
        }

        for (int i = 1; i <= totalColumns; i++) {
            int colSum = colorBoard[1][i];
            for (int j = 2; j <= totalRows; j++) {
                colSum += colorBoard[j][i];
                colorBoard[j][i] = colSum;
            }
        }

        for (int i = squareSize; i <= totalRows; i++) {
            for (int j = squareSize; j <= totalColumns; j++) {
                int currentSum = colorBoard[i][j] - (colorBoard[i - squareSize][j] + colorBoard[i][j - squareSize] - colorBoard[i - squareSize][j - squareSize]);
                minBlack = Math.min(minBlack, currentSum);
                maxBlack = Math.max(maxBlack, currentSum);
            }
        }

        int result = Math.min(minBlack, squareSize * squareSize - maxBlack);
        outputWriter.write(result + "");
        outputWriter.flush();
        outputWriter.close();
        inputReader.close();
    }
}