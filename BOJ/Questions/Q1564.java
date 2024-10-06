//Question No: 1564
//Title: 팩토리얼5
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder outputBuilder = new StringBuilder();

        long total = Integer.parseInt(inputReader.readLine());
        long factorialResult = 1;
        long threshold = (long) 1e12;

        for (long i = 1; i <= total; i++) {
            factorialResult *= i;
            while (factorialResult % 10 == 0)
                factorialResult /= 10;
            factorialResult %= threshold;
        }

        factorialResult %= 100000;
        if (factorialResult < 10000) outputBuilder.append(0);
        if (factorialResult < 1000) outputBuilder.append(0);
        if (factorialResult < 100) outputBuilder.append(0);
        if (factorialResult < 10) outputBuilder.append(0);
        outputBuilder.append(factorialResult);
        System.out.print(outputBuilder);
    }
}