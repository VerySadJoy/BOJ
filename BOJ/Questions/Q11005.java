//Question No: 11005
//Title: 진법 변환 2
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int decimalNumber = Integer.parseInt(tokenizer.nextToken());
        int base = Integer.parseInt(tokenizer.nextToken());
        reader.close();

        ArrayList<Character> convertedDigits = new ArrayList<>();

        while (decimalNumber > 0) {
            int remainder = decimalNumber % base;
            if (remainder < 10) {
                convertedDigits.add((char) (remainder + '0'));
            } else {
                convertedDigits.add((char) (remainder - 10 + 'A'));
            }
            decimalNumber /= base;
        }

        for (int i = convertedDigits.size() - 1; i >= 0; i--) {
            System.out.print(convertedDigits.get(i));
        }
    }
}