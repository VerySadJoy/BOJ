//Question No: 5086
//Title: 배수와 약수
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        String isFactor = "factor\n";
        String isMultiple = "multiple\n";
        String isNeither = "neither\n";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        StringTokenizer tokenizer;

        while (true) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int num1 = Integer.parseInt(tokenizer.nextToken());
            int num2 = Integer.parseInt(tokenizer.nextToken());

            if (num1 == 0 && num2 == 0) break;

            if (num2 % num1 == 0) {
                result.append(isFactor);
            } else if (num1 % num2 == 0) {
                result.append(isMultiple);
            } else {
                result.append(isNeither);
            }
        }
        System.out.print(result);
    }
}