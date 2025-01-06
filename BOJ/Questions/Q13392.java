//Question No: 13392
//Title: 방법을 출력하지 않는 숫자 맞추기
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 1000000;
    static int length;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        length = Integer.parseInt(reader.readLine());
        int[][] dp = new int[length + 1][10];
        initializeDP(dp);

        int[] current = new int[length + 1];
        int[] target = new int[length + 1];
        initializeState(reader.readLine(), current);
        initializeState(reader.readLine(), target);

        int leftRotation = calculateRotation(current[1], target[1], true);
        dp[1][leftRotation] = leftRotation;
        dp[1][0] = calculateRotation(current[1], target[1], false);

        for (int i = 2; i <= length; i++) {
            for (int j = 0; j <= 9; j++) {
                if (dp[i - 1][j] != MAX) {
                    int rotatedValue = applyRotation(current[i], j);

                    int left = calculateRotation(rotatedValue, target[i], true);
                    int nextLeftRotation = applyRotation(j, left);
                    dp[i][nextLeftRotation] = Math.min(dp[i][nextLeftRotation], dp[i - 1][j] + left);

                    int right = calculateRotation(rotatedValue, target[i], false);
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][j] + right);
                }
            }
        }

        int result = MAX;
        for (int i = 0; i <= 9; i++) {
            result = Math.min(result, dp[length][i]);
        }
        System.out.println(result);
    }

    static void initializeDP(int[][] array) {
        for (int i = 1; i <= length; i++) {
            Arrays.fill(array[i], MAX);
        }
    }

    static void initializeState(String str, int[] array) {
        for (int i = 0; i < str.length(); i++) {
            array[i + 1] = str.charAt(i) - '0';
        }
    }

    static int applyRotation(int value, int count) {
        return (value + count) % 10;
    }

    static int calculateRotation(int current, int target, boolean isLeft) {
        if (current == target) {
            return 0;
        }
        if (isLeft) {
            return current < target ? target - current : (target + 10) - current;
        } else {
            return current > target ? current - target : (current + 10) - target;
        }
    }
}