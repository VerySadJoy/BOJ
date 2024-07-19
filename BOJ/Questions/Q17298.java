//Question No: 17298
//Title: 오큰수
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Stack;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> indexStack = new Stack<>();

        int elementCount = Integer.parseInt(reader.readLine());
        int[] elements = new int[elementCount];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

        for (int i = 0; i < elementCount; i++) {
            elements[i] = Integer.parseInt(tokenizer.nextToken());
        }

        for (int i = 0; i < elementCount; i++) {
            while (!indexStack.isEmpty() && elements[indexStack.peek()] < elements[i]) {
                elements[indexStack.pop()] = elements[i];
            }
            indexStack.push(i);
        }

        while (!indexStack.isEmpty()) {
            elements[indexStack.pop()] = -1;
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < elementCount; i++) {
            result.append(elements[i]).append(' ');
        }

        System.out.println(result);
    }
}
