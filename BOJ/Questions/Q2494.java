//Question No: 2494
//Title: 숫자 맞추기
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        int nextIndex, nextTurn, move;
        Node(int nextIndex, int nextTurn, int move) {
            this.nextIndex = nextIndex;
            this.nextTurn = nextTurn;
            this.move = move;
        }
    }

    static char[] from, to;
    static int[][] dp;
    static Node[][] child;
    static int N;

    public static int calculate(int index, int turn) {
        if (index == N) return 0;
        if (dp[index][turn] != -1) return dp[index][turn];

        int left = (to[index] - from[index] - turn + 20) % 10;
        int right = 10 - left;

        int turnLeft = calculate(index + 1, (turn + left) % 10) + left;
        int turnRight = calculate(index + 1, turn) + right;

        if (turnLeft < turnRight) {
            child[index][turn] = new Node(index + 1, (turn + left) % 10, left);
        } else {
            child[index][turn] = new Node(index + 1, turn, -right);
        }

        return dp[index][turn] = Math.min(turnLeft, turnRight);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(reader.readLine());

        from = reader.readLine().toCharArray();
        to = reader.readLine().toCharArray();

        for (int i = 0; i < N; i++) {
            from[i] -= '0';
            to[i] -= '0';
        }

        dp = new int[N][11];
        child = new Node[N][11];
        for (int[] row : dp) Arrays.fill(row, -1);

        System.out.println(calculate(0, 0));

        int index = 0, turn = 0;
        for (int i = 1; i <= N; i++) {
            Node current = child[index][turn];
            System.out.println(i + " " + current.move);
            index = current.nextIndex;
            turn = current.nextTurn;
        }
    }
}