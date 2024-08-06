//Question No: 2873
//Title: 롤러코스터
//Tier: Platinum III
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int rows = Integer.parseInt(tokenizer.nextToken());
        int cols = Integer.parseInt(tokenizer.nextToken());

        StringBuilder result = new StringBuilder();

        if (rows % 2 == 0 && cols % 2 == 0) {
            int minRow = 0, minCol = 0, minValue = Integer.MAX_VALUE;

            for (int i = 0; i < rows; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                for (int j = 0; j < cols; j++) {
                    if ((i + j) % 2 == 1) {
                        int value = Integer.parseInt(tokenizer.nextToken());
                        if (minValue > value) {
                            minValue = value;
                            minRow = i;
                            minCol = j;
                        }
                    } else {
                        tokenizer.nextToken();
                    }
                }
            }
            result.append(generateGreedyZigZag(cols, rows, minCol, minRow));
        } else {
            if (rows % 2 == 1) {
                result.append(generateZigZag('R', 'L', 'D', cols, rows));
            } else {
                result.append(generateZigZag('D', 'U', 'R', rows, cols));
            }
        }

        System.out.println(result.deleteCharAt(result.length() - 1).toString());
    }

    static StringBuilder generateGreedyZigZag(int cols, int rows, int excludeCol, int excludeRow) {
        StringBuilder result = new StringBuilder();
        int upperRows = excludeRow / 2 * 2;
        result.append(generateZigZag('R', 'L', 'D', cols, upperRows));

        for (int i = 0; i < excludeCol; i++) {
            if (i % 2 == 0) {
                result.append("DR");
            } else {
                result.append("UR");
            }
        }
        for (int i = excludeCol; i < cols - 1; i++) {
            if (i % 2 == 0) {
                result.append("RD");
            } else {
                result.append("RU");
            }
        }
        result.append("D");
        result.append(generateZigZag('L', 'R', 'D', cols, rows - upperRows - 2));
        return result;
    }

    static StringBuilder generateZigZag(char forward, char backward, char down, int cols, int rows) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols - 1; j++) {
                if (i % 2 == 0) {
                    result.append(forward);
                } else {
                    result.append(backward);
                }
            }
            result.append(down);
        }
        return result;
    }
}