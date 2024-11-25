//Question No: 18258
//Title: 큐 2
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static final int[] queue = new int[2000000];
    private static int size = 0;
    private static int frontIndex = 0;
    private static int backIndex = 0;

    private static final StringBuilder resultBuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());

        while (commandCount-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            String command = tokenizer.nextToken();

            switch (command) {
                case "push":
                    push(Integer.parseInt(tokenizer.nextToken()));
                    break;
                case "pop":
                    pop();
                    break;
                case "size":
                    size();
                    break;
                case "empty":
                    isEmpty();
                    break;
                case "front":
                    front();
                    break;
                case "back":
                    back();
                    break;
                default:
                    break;
            }
        }

        System.out.println(resultBuilder);
    }

    private static void push(int value) {
        queue[backIndex++] = value;
        size++;
    }

    private static void pop() {
        if (size == 0) {
            resultBuilder.append(-1).append('\n');
        } else {
            resultBuilder.append(queue[frontIndex++]).append('\n');
            size--;
        }
    }

    private static void size() {
        resultBuilder.append(size).append('\n');
    }

    private static void isEmpty() {
        resultBuilder.append(size == 0 ? 1 : 0).append('\n');
    }

    private static void front() {
        if (size == 0) {
            resultBuilder.append(-1).append('\n');
        } else {
            resultBuilder.append(queue[frontIndex]).append('\n');
        }
    }

    private static void back() {
        if (size == 0) {
            resultBuilder.append(-1).append('\n');
        } else {
            resultBuilder.append(queue[backIndex - 1]).append('\n');
        }
    }
}