//Question No: 1531
//Title: 투명
//Tier: Silver V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        int numberOfSheets = Integer.parseInt(tokenizer.nextToken());
        int maxOverlaps = Integer.parseInt(tokenizer.nextToken());

        int[][] canvas = new int[100][100];
        for (int[] row : canvas) {
            Arrays.fill(row, 0);
        }

        for (int i = 0; i < numberOfSheets; i++) {
            StringTokenizer paper = new StringTokenizer(inputReader.readLine());
            int x1 = Integer.parseInt(paper.nextToken()) - 1;
            int y1 = Integer.parseInt(paper.nextToken()) - 1;
            int x2 = Integer.parseInt(paper.nextToken()) - 1;
            int y2 = Integer.parseInt(paper.nextToken()) - 1;
            for (int j = y1; j <= y2; j++) {
                for (int k = x1; k <= x2; k++) {
                    canvas[j][k]++;
                }
            }
        }

        int overlapCount = 0;
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                if (canvas[i][j] > maxOverlaps) {
                    overlapCount++;
                }
            }
        }
        System.out.println(overlapCount);
    }
}