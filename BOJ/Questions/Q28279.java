//Question No: 28279
//Title: 덱 2
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    private static final StringBuilder resultBuilder = new StringBuilder();
    private static final Deque<Integer> deque = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());

        while (commandCount-- > 0) {
            processCommand(reader.readLine());
        }

        System.out.println(resultBuilder);
    }

    private static void processCommand(String command) {
        StringTokenizer tokenizer = new StringTokenizer(command);
        int operation = Integer.parseInt(tokenizer.nextToken());

        switch (operation) {
            case 1 -> deque.addFirst(Integer.valueOf(tokenizer.nextToken()));
            case 2 -> deque.addLast(Integer.valueOf(tokenizer.nextToken()));
            case 3 -> resultBuilder.append(deque.isEmpty() ? -1 : deque.pollFirst()).append("\n");
            case 4 -> resultBuilder.append(deque.isEmpty() ? -1 : deque.pollLast()).append("\n");
            case 5 -> resultBuilder.append(deque.size()).append("\n");
            case 6 -> resultBuilder.append(deque.isEmpty() ? 1 : 0).append("\n");
            case 7 -> resultBuilder.append(deque.isEmpty() ? -1 : deque.peekFirst()).append("\n");
            case 8 -> resultBuilder.append(deque.isEmpty() ? -1 : deque.peekLast()).append("\n");
        }
    }
}