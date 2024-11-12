//Question No: 24264
//Title: 알고리즘 수업 - 알고리즘의 수행 시간 3
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BigInteger inputSize = new BigInteger(reader.readLine().trim());
        reader.close();

        BigInteger square = inputSize.multiply(inputSize);
        StringBuilder output = new StringBuilder();
        output.append(square).append("\n").append(2);
        
        System.out.println(output);
    }
}