//Question No: 1735
//Title: 분수 합
//Tier: Silver III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer firstFraction = new StringTokenizer(inputReader.readLine());
        int numerator1 = Integer.parseInt(firstFraction.nextToken());
        int denominator1 = Integer.parseInt(firstFraction.nextToken());

        StringTokenizer secondFraction = new StringTokenizer(inputReader.readLine());
        int numerator2 = Integer.parseInt(secondFraction.nextToken());
        int denominator2 = Integer.parseInt(secondFraction.nextToken());

        int resultNumerator = numerator1 * denominator2 + numerator2 * denominator1;
        int resultDenominator = denominator1 * denominator2;

        int gcdValue = calculateGCD(resultNumerator, resultDenominator);
        resultNumerator /= gcdValue;
        resultDenominator /= gcdValue;

        outputWriter.write(resultNumerator + " " + resultDenominator + "\n");
        outputWriter.flush();
        outputWriter.close();
        inputReader.close();
    }

    public static int calculateGCD(int value1, int value2) {
        while (value2 != 0) {
            int remainder = value1 % value2;
            value1 = value2;
            value2 = remainder;
        }
        return value1;
    }
}