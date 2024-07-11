//Question No: 15678
//Title: 연세워터파크
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {

    static class Node {
        int index;
        long value;

        public Node(int index, long value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int numberOfNodes = Integer.parseInt(tokenizer.nextToken());
            int maxDistance = Integer.parseInt(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            Node[] nodes = new Node[numberOfNodes];

            for (int i = 0; i < numberOfNodes; ++i) {
                long value = Long.parseLong(tokenizer.nextToken());
                nodes[i] = new Node(i, value);
            }

            Deque<Node> deque = new ArrayDeque<>();
            long maxSum = Long.MIN_VALUE;

            for (int i = 0; i < numberOfNodes; i++) {
                while (!deque.isEmpty() && deque.peekLast().index + maxDistance < i) {
                    deque.pollLast();
                }

                if (deque.isEmpty()) {
                    deque.offer(nodes[i]);
                    continue;
                }
                if (deque.peekLast().value <= deque.peekLast().value + nodes[i].value) {
                    deque.addLast(new Node(i, deque.peekLast().value + nodes[i].value));
                } 
                else {
                    while (deque.size() > 1 && deque.peekFirst().value <= deque.peekLast().value + nodes[i].value) {
                        deque.pollFirst();
                    }
                    deque.addFirst(new Node(i, deque.peekLast().value + nodes[i].value));
                }
                if (deque.peekLast().value <= nodes[i].value) {
                    deque.addLast(new Node(i, nodes[i].value));
                }
                maxSum = Math.max(maxSum, deque.peekLast().value);
            }

            writer.write(maxSum + "\n");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
