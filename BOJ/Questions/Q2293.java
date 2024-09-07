//Question No: 2293
//Title: 동전 1
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static int itemCount, targetSum;
    private static int[] itemValues, combinations;

    public static void main(String[] args) throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        itemCount = Integer.parseInt(tokenizer.nextToken());
        targetSum = Integer.parseInt(tokenizer.nextToken());

        itemValues = new int[itemCount + 1];
        combinations = new int[targetSum + 1];
        combinations[0] = 1;

        for(int i = 1; i <= itemCount; i++) {
            itemValues[i] = Integer.parseInt(reader.readLine());
            for (int j = itemValues[i]; j <= targetSum; j++) {
                combinations[j] += combinations[j - itemValues[i]];
            }
        }

        System.out.println(combinations[targetSum]);
    }
}