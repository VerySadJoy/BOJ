//Question No: 22193
//Title: Multiply
//Tier: Bronze V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        reader.readLine();
        BigInteger firstNumber = new BigInteger(reader.readLine());
        BigInteger secondNumber = new BigInteger(reader.readLine());

        System.out.println(firstNumber.multiply(secondNumber));
    }
}