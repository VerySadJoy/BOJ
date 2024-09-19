//Question No: 14002
//Title: 가장 긴 증가하는 부분 수열 4
//Tier: Gold IV
import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static final BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder output;

    public static void main(String[] args) throws IOException {
        output = new StringBuilder();
        int size = Integer.parseInt(reader.readLine());
        int[] elements = new int[size + 1];
        int[] dp = new int[size + 1];
        int maxLength = 0;

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 1; i <= size; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());
            elements[i] = num;
            for (int j = 0; j < i; j++) {
                if (elements[i] > elements[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                    maxLength = Math.max(dp[i], maxLength);
                }
            }
        }

        output.append(maxLength).append("\n");

        int lengthToFind = maxLength;
        Stack<Integer> stack = new Stack<>();

        for (int i = size; i >= 1; i--) {
            if (lengthToFind == dp[i]) {
                stack.push(elements[i]);
                lengthToFind--;
            }
        }

        while (!stack.isEmpty()) {
            output.append(stack.pop()).append(" ");
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }
}