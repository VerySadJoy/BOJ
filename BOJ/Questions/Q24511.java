//Question No: 24511
//Title: queuestack
//Tier: Silver III
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int dataStructureCount = Integer.parseInt(reader.readLine());
        int[] structureTypes = new int[dataStructureCount];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < dataStructureCount; i++) {
            structureTypes[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Deque<Integer> queue = new ArrayDeque<>();
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < dataStructureCount; i++) {
            int value = Integer.parseInt(tokenizer.nextToken());
            if (structureTypes[i] == 0) {
                queue.addLast(value);
            }
        }

        int sequenceLength = Integer.parseInt(reader.readLine());
        tokenizer = new StringTokenizer(reader.readLine());
        reader.close();

        while (sequenceLength-- > 0) {
            int input = Integer.parseInt(tokenizer.nextToken());
            queue.addFirst(input);
            result.append(queue.pollLast()).append(" ");
        }

        System.out.println(result);
    }
}