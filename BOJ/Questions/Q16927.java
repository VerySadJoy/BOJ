//Question No: 16927
//Title: 배열 돌리기 2
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int totalRows, totalColumns, rotations;
    static int[][] matrix;
    static int[] moveX = {1, 0, -1, 0};
    static int[] moveY = {0, 1, 0, -1};
    static StringTokenizer tokenizer;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        tokenizer = new StringTokenizer(inputReader.readLine());
        totalRows = Integer.parseInt(tokenizer.nextToken());
        totalColumns = Integer.parseInt(tokenizer.nextToken());
        rotations = Integer.parseInt(tokenizer.nextToken());

        matrix = new int[totalRows][totalColumns];

        for (int i = 0; i < totalRows; i++) {
            tokenizer = new StringTokenizer(inputReader.readLine());
            for (int j = 0; j < totalColumns; j++) {
                matrix[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        rotateMatrix();
        printMatrix();
    }

    static void rotateMatrix() {
        int layers = Math.min(totalRows, totalColumns) / 2;

        for (int i = 0; i < layers; i++) {
            int effectiveRotations = rotations % (((totalRows - 2 * i) + (totalColumns - 2 * i)) * 2 - 4);
            rotateLayer(i, effectiveRotations);
        }
    }

    static void rotateLayer(int layerIndex, int rotationCount) {
        for (int r = 0; r < rotationCount; r++) {
            int currentX = layerIndex;
            int currentY = layerIndex;
            int tempValue = matrix[currentY][currentX];

            int direction = 0;

            while (direction < 4) {
                int nextX = currentX + moveX[direction];
                int nextY = currentY + moveY[direction];

                if (nextX < layerIndex || nextY < layerIndex || nextX >= totalColumns - layerIndex || nextY >= totalRows - layerIndex) {
                    direction++;
                    continue;
                }

                matrix[currentY][currentX] = matrix[nextY][nextX];
                currentY = nextY;
                currentX = nextX;
            }
            matrix[layerIndex + 1][layerIndex] = tempValue;
        }
    }

    static void printMatrix() {
        StringBuilder outputBuilder = new StringBuilder();
        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumns; j++) {
                outputBuilder.append(matrix[i][j]).append(" ");
            }
            outputBuilder.append("\n");
        }
        System.out.println(outputBuilder);
    }
}