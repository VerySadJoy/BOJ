//Question No: 20921
//Title: 그렇고 그런 사이
//Tier: Silver I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());

        int totalNumbers = Integer.parseInt(tokenizer.nextToken());
        int targetSum = Integer.parseInt(tokenizer.nextToken());

        int accumulatedSum = 0;
        int currentIndex = totalNumbers - 1;
        boolean[] isSelected = new boolean[totalNumbers];

        while (currentIndex > 0) {
            if (accumulatedSum + currentIndex <= targetSum) {
                accumulatedSum += currentIndex;
                isSelected[currentIndex] = true;
            }
            currentIndex--;
        }

        for (int i = totalNumbers - 1; i >= 0; i--) {
            if (isSelected[i]) {
                outputWriter.write(Integer.toString(i + 1) + " ");
            }
        }
        for (int i = 0; i < totalNumbers; i++) {
            if (!isSelected[i]) {
                outputWriter.write(Integer.toString(i + 1) + " ");
            }
        }

        outputWriter.flush();
        outputWriter.close();
    }
}