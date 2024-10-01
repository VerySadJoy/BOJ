//Question No: 16139
//Title: 인간-컴퓨터 상호작용
//Tier: Silver I
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;
        String givenString = inputReader.readLine();
        int numberOfQueries = Integer.parseInt(inputReader.readLine());

        int[][] characterFrequency = new int[givenString.length() + 1][26];

        for (int i = 1; i <= givenString.length(); i++) {
            int currentCharacter = givenString.charAt(i - 1) - 'a';

            for (int j = 0; j < 26; j++) {
                int previousValue = characterFrequency[i - 1][j];
                characterFrequency[i][j] = (j == currentCharacter) ? previousValue + 1 : previousValue;
            }
        }

        while (numberOfQueries-- > 0) {
            tokenizer = new StringTokenizer(inputReader.readLine());

            int characterIndex = tokenizer.nextToken().charAt(0) - 'a';
            int startIndex = Integer.parseInt(tokenizer.nextToken()) + 1;
            int endIndex = Integer.parseInt(tokenizer.nextToken()) + 1;

            outputWriter.write((characterFrequency[endIndex][characterIndex] - characterFrequency[startIndex - 1][characterIndex]) + "\n");
        }

        inputReader.close();
        outputWriter.flush();
        outputWriter.close();
    }
}