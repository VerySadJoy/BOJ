//Question No: 1158
//Title: 요세푸스 문제
//Tier: Silver IV
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.add(i);
        }

        StringBuilder result = new StringBuilder();
        result.append("<");

        while (queue.size() > 1) {
            for (int i = 1; i < k; i++) {
                queue.add(queue.poll());
            }
            result.append(queue.poll()).append(", ");
        }
        result.append(queue.poll()).append(">");
        System.out.println(result);
    }
}