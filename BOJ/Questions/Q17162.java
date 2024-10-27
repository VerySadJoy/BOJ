//Question No: 17162
//Title: 가희의 수열놀이 (Small)
//Tier: Gold IV
import java.io.DataInputStream;
import java.io.IOException;
import java.util.Stack;

public class Main extends FastInput {
    private void solution() throws Exception {
        int queryCount = nextInt();
        int modulo = nextInt();
        Stack<Integer>[] stacks = new Stack[modulo];
        for (int i = 0; i < modulo; i++) stacks[i] = new Stack<>();
        StringBuilder resultBuilder = new StringBuilder();
        int index = 0;

        while (queryCount-- > 0) {
            int queryType = nextInt();
            switch (queryType) {
                case 1:
                    int number = nextInt();
                    stacks[number % modulo].push(index++);
                    break;
                case 2:
                    for (int i = 0; i < modulo; i++) {
                        if (!stacks[i].isEmpty() && stacks[i].peek() == index - 1) {
                            stacks[i].pop();
                            index--;
                            break;
                        }
                    }
                    break;
                case 3:
                    int minimum = Integer.MAX_VALUE;
                    for (int i = 0; i < modulo; i++) {
                        if (stacks[i].isEmpty()) {
                            minimum = -1;
                            break;
                        }
                        if (stacks[i].peek() < minimum) {
                            minimum = stacks[i].peek();
                        }
                    }
                    resultBuilder.append(minimum == -1 ? minimum : index - minimum).append('\n');
                    break;
            }
        }
        System.out.print(resultBuilder);
    }

    public static void main(String[] args) throws Exception {
        initFastInput();
        new Main().solution();
    }
}

class FastInput {
    private static final int DEFAULT_BUFFER_SIZE = 1024;
    private static DataInputStream inputStream;
    private static byte[] buffer;
    private static int currentIndex, maxIndex;

    protected static void initFastInput() {
        inputStream = new DataInputStream(System.in);
        buffer = new byte[DEFAULT_BUFFER_SIZE];
        currentIndex = maxIndex = 0;
    }

    protected static int nextInt() throws IOException {
        int result = 0;
        byte character = read();
        while (character <= ' ') character = read();
        do {
            result = result * 10 + character - '0';
        } while ((character = read()) >= '0' && character <= '9');
        return result;
    }

    private static byte read() throws IOException {
        if (currentIndex == maxIndex) {
            maxIndex = inputStream.read(buffer, currentIndex = 0, DEFAULT_BUFFER_SIZE);
            if (maxIndex == -1) buffer[0] = -1;
        }
        return buffer[currentIndex++];
    }
}