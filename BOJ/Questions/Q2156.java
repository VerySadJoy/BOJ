//Question No: 2156
//Title: 포도주 시식
//Tier: Silver I
import java.util.Scanner;

public class Main {
    static final int MAXIMUM_ELEMENTS = 10010;
    static int totalElements;
    static int[] values = new int[MAXIMUM_ELEMENTS];
    static int[] dp = new int[MAXIMUM_ELEMENTS];

    static int getMax(int firstValue, int secondValue) {
        return (firstValue > secondValue) ? firstValue : secondValue;
    }

    static void readInput() {
        try (Scanner scanner = new Scanner(System.in)) {
            totalElements = scanner.nextInt();
            for (int i = 1; i <= totalElements; i++) {
                values[i] = scanner.nextInt();
            }
        }
    }

    static void findSolution() {
        dp[1] = values[1];
        dp[2] = dp[1] + values[2];
        for (int i = 3; i <= totalElements; i++) {
            dp[i] = getMax(dp[i - 3] + values[i - 1] + values[i], dp[i - 2] + values[i]);
            dp[i] = getMax(dp[i - 1], dp[i]);
        }
        System.out.println(dp[totalElements]);
    }

    public static void main(String[] args) {
        readInput();
        findSolution();
    }
}