//Question No: 1037
//Title: 약수
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfIntegers = Integer.parseInt(reader.readLine());

        int maximumValue = Integer.MIN_VALUE;
        int minimumValue = Integer.MAX_VALUE;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        while (numberOfIntegers-- > 0) {
            int currentNumber = Integer.parseInt(tokenizer.nextToken());
            maximumValue = Math.max(currentNumber, maximumValue);
            minimumValue = Math.min(currentNumber, minimumValue);
        }

        reader.close();

        System.out.println(maximumValue * minimumValue);
    }
}