//Question No: 2470
//Title: 두 용액
//Tier: Gold V
import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(reader.readLine());

        int[] elements = new int[size];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < size; i++) {
            elements[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int[] result = new int[2];
        int start = 0, end = size - 1, minimumDifference = Integer.MAX_VALUE;
        Arrays.sort(elements);

        while (start < end) {
            int sum = elements[start] + elements[end];

            if (minimumDifference > Math.abs(sum)) {
                minimumDifference = Math.abs(sum);
                result[0] = elements[start];
                result[1] = elements[end];

                if (sum == 0) break;
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.println(result[0] + " " + result[1]);
    }
}