//Question No: 1655
//Title: 가운데를 말해요
//Tier: Gold II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        int numberOfInputs = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);

        for (int i = 0; i < numberOfInputs; i++) {
            int currentNumber = Integer.parseInt(reader.readLine());

            if (minHeap.size() == maxHeap.size()) {
                maxHeap.offer(currentNumber);
            } else {
                minHeap.offer(currentNumber);
            }

            if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
                if (minHeap.peek() < maxHeap.peek()) {
                    int minHeapTop = minHeap.poll();
                    minHeap.offer(maxHeap.poll());
                    maxHeap.offer(minHeapTop);
                }
            }

            resultBuilder.append(maxHeap.peek()).append("\n");
        }

        System.out.println(resultBuilder);
    }
}