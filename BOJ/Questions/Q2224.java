//Question No: 2224
//Title: 명제 증명
//Tier: Gold IV
import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    private static final int MAX = 58;
    private static final int INF = (int) 1e9;
    private static int[][] dp = new int[MAX][MAX];
    private static ArrayList<String> results = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        init();
        input(scanner);
        settings();
        findAnswer();
    }

    private static void init() {
        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (i != j) {
                    dp[i][j] = INF;
                }
            }
        }
    }

    private static void input(Scanner scanner) {
        int n = scanner.nextInt();
        scanner.nextLine();

        while (n-- > 0) {
            char a = scanner.next().charAt(0);
            String is = scanner.next();
            char b = scanner.next().charAt(0);
            scanner.nextLine();

            int x = a - 'A';
            int y = b - 'A';
            dp[x][y] = 1;
        }
    }

    private static void settings() {
        for (int k = 0; k < MAX; k++) {
            for (int i = 0; i < MAX; i++) {
                for (int j = 0; j < MAX; j++) {
                    if (i != j && dp[i][j] > dp[i][k] + dp[k][j]) {
                        dp[i][j] = dp[i][k] + dp[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < MAX; i++) {
            for (int j = 0; j < MAX; j++) {
                if (i != j && dp[i][j] != INF) {
                    char first = (char) (i + 65);
                    char second = (char) (j + 65);
                    String tmp = first + " => " + second;
                    results.add(tmp);
                }
            }
        }
    }

    private static void findAnswer() {
        System.out.println(results.size());
        for (String result : results) {
            System.out.println(result);
        }
    }
}