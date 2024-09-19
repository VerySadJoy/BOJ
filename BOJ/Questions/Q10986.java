//Question No: 10986
//Title: 나머지 합
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numberOfElements = Integer.parseInt(tokenizer.nextToken());
        int divisor = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());

        int[] remainderCount = new int[divisor];
        int cumulativeSum = 0;
        for (int i = 0; i < numberOfElements; i++) {
            int number = Integer.parseInt(tokenizer.nextToken());
            cumulativeSum = (cumulativeSum + number) % divisor;
            remainderCount[cumulativeSum]++;
        }

        long result = remainderCount[0];
        for (int i = 0; i < remainderCount.length; i++) {
            result += (long) remainderCount[i] * (remainderCount[i] - 1) / 2;
        }

        System.out.println(result);
    }
}