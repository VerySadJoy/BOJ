//Question No: 7868
//Title: 해밍 수열
//Tier: Gold V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long factor1 = Long.parseLong(tokenizer.nextToken());
        long factor2 = Long.parseLong(tokenizer.nextToken());
        long factor3 = Long.parseLong(tokenizer.nextToken());
        int iterations = Integer.parseInt(tokenizer.nextToken());

        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        HashSet<Long> uniqueNumbers = new HashSet<>();
        priorityQueue.offer(factor1);
        priorityQueue.offer(factor2);
        priorityQueue.offer(factor3);
        uniqueNumbers.add(factor1);
        uniqueNumbers.add(factor2);
        uniqueNumbers.add(factor3);

        long currentNumber = 0;

        for (int count = 0; count < iterations; count++) {
            currentNumber = priorityQueue.poll();
            if (!uniqueNumbers.contains(currentNumber * factor1)) {
                priorityQueue.offer(currentNumber * factor1);
                uniqueNumbers.add(currentNumber * factor1);
            }
            if (!uniqueNumbers.contains(currentNumber * factor2)) {
                priorityQueue.offer(currentNumber * factor2);
                uniqueNumbers.add(currentNumber * factor2);
            }
            if (!uniqueNumbers.contains(currentNumber * factor3)) {
                priorityQueue.offer(currentNumber * factor3);
                uniqueNumbers.add(currentNumber * factor3);
            }
        }
        System.out.println(currentNumber);
    }
}