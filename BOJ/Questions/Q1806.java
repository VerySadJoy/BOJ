//Question No: 1806
//Title: 부분합
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static BufferedReader reader;

    public static void main(String[] args) throws IOException {
        reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int S = Integer.parseInt(tokenizer.nextToken());
        int[] numbers = new int[N];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int start = 0, end = 0;
        int sum = numbers[0];
        int minLength = Integer.MAX_VALUE;

        while (end < N) {
            if (sum >= S) {
                minLength = Math.min(minLength, end - start + 1);
                sum -= numbers[start];
                start++;
            } else {
                end++;
                if (end < N) {
                    sum += numbers[end];
                }
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }
    }
}
