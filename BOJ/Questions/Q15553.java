//Question No: 15553
//Title: 난로
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numberOfTimes = Integer.parseInt(tokenizer.nextToken());
        int segmentsToRemove = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        int firstTime = Integer.parseInt(reader.readLine());
        int previousTime = firstTime;
        for (int i = 1; i < numberOfTimes; i++) {
            int currentTime = Integer.parseInt(reader.readLine());
            priorityQueue.offer(currentTime - (previousTime + 1));
            previousTime = currentTime;
        }

        int totalReduction = 0;
        for (int i = 0; i < segmentsToRemove - 1; i++) {
            totalReduction += priorityQueue.poll();
        }

        System.out.println((previousTime - firstTime + 1) - totalReduction);
    }
}