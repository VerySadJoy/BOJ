//Question No: 10811
//Title: 바구니 뒤집기
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        int totalBuckets = Integer.parseInt(tokenizer.nextToken());
        int operationsCount = Integer.parseInt(tokenizer.nextToken());

        int[] buckets = new int[totalBuckets];
        for (int i = 0; i < totalBuckets; i++) {
            buckets[i] = i + 1;
        }

        for (int i = 0; i < operationsCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int leftIndex = Integer.parseInt(tokenizer.nextToken()) - 1;
            int rightIndex = Integer.parseInt(tokenizer.nextToken()) - 1;

            while (leftIndex < rightIndex) {
                int temp = buckets[leftIndex];
                buckets[leftIndex++] = buckets[rightIndex];
                buckets[rightIndex--] = temp;
            }
        }
        reader.close();

        for (int bucket : buckets) {
            System.out.print(bucket + " ");
        }
    }
}