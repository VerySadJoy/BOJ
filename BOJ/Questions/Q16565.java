//Question No: 16565
//Title: N포커
//Tier: Gold II
import java.util.Scanner;

public class Main {
    private static final int MOD = 10007;
    private static int[][] combination = new int[53][53];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 0; i <= 52; i++) {
            combination[i][0] = 1;
            combination[i][i] = 1;
            for (int j = 1; j < i; j++) {
                combination[i][j] = (combination[i - 1][j - 1] + combination[i - 1][j]) % MOD;
                combination[i][i - j] = combination[i][j];
            }
        }

        int result = 0;
        for (int i = 4; i <= n; i += 4) {
            if ((i / 4) % 2 == 1) {
                result = (result + combination[13][i / 4] * combination[52 - i][n - i]) % MOD;
            } else {
                result = (result - combination[13][i / 4] * combination[52 - i][n - i]) % MOD;
            }
        }

        if (result < 0) {
            result += MOD;
        }

        System.out.println(result);
    }
}
