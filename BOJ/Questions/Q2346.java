//Question No: 2346
//Title: 풍선 터뜨리기
//Tier: Silver III
import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();
        Deque<Balloon> balloons = new ArrayDeque<>();

        int balloonCount = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int[] moves = new int[balloonCount];
        for (int i = 0; i < balloonCount; i++) {
            moves[i] = Integer.parseInt(tokenizer.nextToken());
        }

        result.append("1 ");
        int currentMove = moves[0];

        for (int i = 1; i < balloonCount; i++) {
            balloons.add(new Balloon(i + 1, moves[i]));
        }

        while (!balloons.isEmpty()) {
            if (currentMove > 0) {
                for (int i = 1; i < currentMove; i++) {
                    balloons.addLast(balloons.pollFirst());
                }
                Balloon next = balloons.pollFirst();
                currentMove = next.moveValue;
                result.append(next.index).append(" ");
            } else {
                for (int i = 1; i < -currentMove; i++) {
                    balloons.addFirst(balloons.pollLast());
                }
                Balloon next = balloons.pollLast();
                currentMove = next.moveValue;
                result.append(next.index).append(" ");
            }
        }

        System.out.println(result);
    }

    private static class Balloon {
        int index;
        int moveValue;

        Balloon(int index, int moveValue) {
            this.index = index;
            this.moveValue = moveValue;
        }
    }
}