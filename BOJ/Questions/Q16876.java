//Question No: 16876
//Title: 재미있는 숫자 게임
//Tier: Gold II
import java.util.Scanner;

public class Main {
    static final int NMAX = 10000;
    static final int MMAX = 105;

    static int N, M;
    static int[][] dp = new int[NMAX][MMAX];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();

        for (int i = 0; i < NMAX; i++) {
            for (int j = 0; j < MMAX; j++) {
                dp[i][j] = -1;
            }
        }

        if (sv(N, 1) == 1) {
            System.out.print("koosaga");
        } else {
            System.out.print("cubelover");
        }
    }

    static int calc(int[] inp) {
        int result = 0;
        for (int i = 1, factor = 1; i <= 4; i++, factor *= 10) {
            result += inp[i] * factor;
        }
        return result;
    }

    static int sv(int n, int t) {
        if (dp[n][t] >= 0) {
            return dp[n][t];
        } else if (t > M) {
            if (n > N) {
                return dp[n][t] = 1;
            } else {
                return dp[n][t] = 0;
            }
        }

        int[] inp = new int[5];
        int temp = n;
        for (int i = 1; i <= 4; i++, temp /= 10) {
            inp[i] = temp % 10;
        }

        int result = 1 - (t % 2);
        for (int i = 1; i <= 4; i++) {
            inp[i] = (inp[i] + 1) % 10;
            if (sv(calc(inp), t + 1) == (t % 2)) {
                result = t % 2;
            }
            inp[i] = (inp[i] - 1 + 10) % 10;
        }

        return dp[n][t] = result;
    }
}