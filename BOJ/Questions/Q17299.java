//Question No: 17299
//Title: 오등큰수
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {

    private static final int MAX_VALUE = 1_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> stack = new Stack<>();
        int arraySize = Integer.parseInt(reader.readLine());
        int[] frequency = new int[MAX_VALUE];
        int[] numbers = new int[arraySize];
        int[] result = new int[arraySize];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
            frequency[numbers[i]]++;
        }

        for (int i = 0; i < arraySize; i++) {
            while (!stack.isEmpty() && frequency[numbers[i]] > frequency[numbers[stack.peek()]]) {
                result[stack.pop()] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < arraySize; i++) {
            output.append(result[i]).append(" ");
        }
        System.out.println(output);
    }
}