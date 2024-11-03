//Question No: 2745
//Title: 진법 변환
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        String numberInBase = tokenizer.nextToken();
        int base = Integer.parseInt(tokenizer.nextToken());
        reader.close();

        int powerMultiplier = 1;
        int decimalValue = 0;

        for (int i = numberInBase.length() - 1; i >= 0; i--) {
            char currentChar = numberInBase.charAt(i);

            if ('A' <= currentChar && currentChar <= 'Z') {
                decimalValue += (currentChar - 'A' + 10) * powerMultiplier;
            } else {
                decimalValue += (currentChar - '0') * powerMultiplier;
            }
            powerMultiplier *= base;
        }

        System.out.println(decimalValue);
    }
}