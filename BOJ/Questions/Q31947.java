//Question No: 31947
//Title: 사다리 게임 만들기
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int numberOfVerticalLines = Integer.parseInt(tokenizer.nextToken());
        int numberOfHorizontalLines = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int startLine = Integer.parseInt(tokenizer.nextToken()) - 1;
        int endLine = Integer.parseInt(tokenizer.nextToken()) - 1;

        double[][] probabilities = new double[numberOfVerticalLines][numberOfHorizontalLines + 1];
        probabilities[endLine][0] = 1.0;

        for (int j = 1; j <= numberOfHorizontalLines; j++) {
            for (int i = 0; i < numberOfVerticalLines; i++) {
                if (i == 0) {
                    probabilities[i][j] = (probabilities[i + 1][j - 1] + (numberOfVerticalLines - 2) * probabilities[i][j - 1]) / (numberOfVerticalLines - 1);
                } else if (i == numberOfVerticalLines - 1) {
                    probabilities[i][j] = (probabilities[i - 1][j - 1] + (numberOfVerticalLines - 2) * probabilities[i][j - 1]) / (numberOfVerticalLines - 1);
                } else {
                    probabilities[i][j] = (probabilities[i + 1][j - 1] + (numberOfVerticalLines - 3) * probabilities[i][j - 1] + probabilities[i - 1][j - 1]) / (numberOfVerticalLines - 1);
                }
            }
        }

        System.out.println(probabilities[startLine][numberOfHorizontalLines]);
    }
}