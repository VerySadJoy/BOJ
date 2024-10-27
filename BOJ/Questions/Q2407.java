//Question No: 2407
//Title: 조합
//Tier: Silver III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] inputValues = reader.readLine().split(" ");

        int n = Integer.parseInt(inputValues[0]);
        int m = Integer.parseInt(inputValues[1]);

        BigInteger numerator = BigInteger.ONE;
        BigInteger denominator = BigInteger.ONE;

        for (int i = 0; i < m; i++) {
            numerator = numerator.multiply(BigInteger.valueOf(n - i));
            denominator = denominator.multiply(BigInteger.valueOf(i + 1));
        }

        BigInteger result = numerator.divide(denominator);

        System.out.println(result);
    }
}