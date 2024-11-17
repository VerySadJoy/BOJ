//Question No: 13241
//Title: 최소공배수
//Tier: Silver V
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());

        long firstNumber = Integer.parseInt(tokenizer.nextToken());
        long secondNumber = Integer.parseInt(tokenizer.nextToken());
        inputReader.close();

        if (firstNumber > secondNumber) {
            outputWriter.write(firstNumber * secondNumber / calculateGCD(firstNumber, secondNumber) + "\n");
        } else if (firstNumber < secondNumber) {
            outputWriter.write(firstNumber * secondNumber / calculateGCD(secondNumber, firstNumber) + "\n");
        } else {
            outputWriter.write(firstNumber + "\n");
        }

        outputWriter.flush();
        outputWriter.close();
    }

    static long calculateGCD(long largerNumber, long smallerNumber) {
        while (smallerNumber != 0) {
            long remainder = largerNumber % smallerNumber;
            largerNumber = smallerNumber;
            smallerNumber = remainder;
        }
        return largerNumber;
    }
}