//Question No: 13913
//Title: 숨바꼭질 4
//Tier: Gold IV
import java.util.*;
import java.io.*;

public class Main {
    static int startPosition, targetPosition;
    static int[] parent = new int[100001];
    static int[] time = new int[100001];

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        startPosition = Integer.parseInt(tokenizer.nextToken());
        targetPosition = Integer.parseInt(tokenizer.nextToken());

        findShortestPath();

        Stack<Integer> pathStack = new Stack<>();
        pathStack.push(targetPosition);
        int currentIndex = targetPosition;

        while (currentIndex != startPosition) {
            pathStack.push(parent[currentIndex]);
            currentIndex = parent[currentIndex];
        }

        resultBuilder.append(time[targetPosition] - 1).append("\n");
        while (!pathStack.isEmpty()) {
            resultBuilder.append(pathStack.pop()).append(" ");
        }

        System.out.println(resultBuilder.toString());
    }

    static void findShortestPath() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(startPosition);
        time[startPosition] = 1;

        while (!queue.isEmpty()) {
            int currentPosition = queue.poll();

            if (currentPosition == targetPosition) return;

            for (int i = 0; i < 3; i++) {
                int nextPosition;

                if (i == 0) {
                    nextPosition = currentPosition + 1;
                } else if (i == 1) {
                    nextPosition = currentPosition - 1;
                } else {
                    nextPosition = currentPosition * 2;
                }

                if (nextPosition < 0 || nextPosition > 100000) continue;

                if (time[nextPosition] == 0) {
                    queue.add(nextPosition);
                    time[nextPosition] = time[currentPosition] + 1;
                    parent[nextPosition] = currentPosition;
                }
            }
        }
    }
}