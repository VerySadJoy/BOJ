//Question No: 28278
//Title: 스택 2
//Tier: Silver IV
import java.io.*;
import java.util.Stack;

public class Main {

    private static final Stack<Integer> stack = new Stack<>();
    private static final StringBuilder resultBuilder = new StringBuilder();

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int commandCount = Integer.parseInt(reader.readLine());

        while (commandCount-- > 0) {
            processCommand(reader.readLine());
        }

        reader.close();
        System.out.print(resultBuilder);
    }

    private static void processCommand(String command) {
        char commandType = command.charAt(0);

        switch (commandType) {
            case '1':
                int valueToPush = Integer.parseInt(command.substring(2));
                stack.push(valueToPush);
                break;
            case '2':
                resultBuilder.append(stack.isEmpty() ? -1 : stack.pop()).append("\n");
                break;
            case '3':
                resultBuilder.append(stack.size()).append("\n");
                break;
            case '4':
                resultBuilder.append(stack.isEmpty() ? 1 : 0).append("\n");
                break;
            case '5':
                resultBuilder.append(stack.isEmpty() ? -1 : stack.peek()).append("\n");
                break;
            default:
                throw new IllegalArgumentException("Invalid command: " + command);
        }
    }
}