//Question No: 16132
//Title: 그룹 나누기 (Subset)
//Tier: Gold IV
import java.util.Scanner;

public class Main {
    static final int MAX = 51;
    static long N, targetSum;
    static long[][] dpCache = new long[MAX][638];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        N = scanner.nextLong();
        targetSum = N * (N + 1) / 2;

        if (targetSum % 2 != 0) {
            System.out.println(0);
            return;
        }

        targetSum /= 2;
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < 638; j++) {
                dpCache[i][j] = -1;
            }
        }

        System.out.println(computeWays(1, 0));
    }

    static long computeWays(int current, long sum) {
        if (current > N || sum > targetSum) {
            return 0;
        }
        if (sum == targetSum) {
            return 1;
        }

        if (dpCache[current][(int) sum] != -1) {
            return dpCache[current][(int) sum];
        }

        dpCache[current][(int) sum] = computeWays(current + 1, sum) + computeWays(current + 1, sum + current);
        return dpCache[current][(int) sum];
    }
}