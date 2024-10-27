//Question No: 2092
//Title: 집합의 개수
//Tier: Gold II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static final int DIVISOR = 1_000_000;

    static int maxNumber;
    static int totalNumbers;
    static int minSelectedCount;
    static int maxSelectedCount;
    static int[] numberArray;
    static int[] numberFrequency;

    static void input() {
        InputReader scanner = new InputReader();

        maxNumber = scanner.nextInt();
        totalNumbers = scanner.nextInt();
        minSelectedCount = scanner.nextInt();
        maxSelectedCount = scanner.nextInt();
        numberArray = new int[totalNumbers];
        numberFrequency = new int[maxNumber + 1];

        for (int i = 0; i < totalNumbers; i++) {
            numberArray[i] = scanner.nextInt();
            numberFrequency[numberArray[i]]++;
        }
    }

    static void solution() {
        int[][] dp = new int[maxNumber + 1][totalNumbers + 1];
        dp[0][0] = 1;

        for (int num = 1; num <= maxNumber; num++) {
            for (int count = 0; count <= numberFrequency[num]; count++) {
                dp[num][count]++;
            }

            for (int count = 0; count <= totalNumbers; count++) {
                dp[num][count] += dp[num - 1][count];
                for (int curCount = 1; curCount <= numberFrequency[num]; curCount++) {
                    if (count - curCount > 0) {
                        dp[num][count] += dp[num - 1][count - curCount];
                        dp[num][count] %= DIVISOR;
                    }
                }
            }
        }

        int total = 0;
        for (int count = minSelectedCount; count <= maxSelectedCount; count++) {
            total += dp[maxNumber][count];
            total %= DIVISOR;
        }

        System.out.println(total);
    }

    public static void main(String[] args) {
        input();
        solution();
    }

    static class InputReader {
        BufferedReader reader;
        StringTokenizer tokenizer;

        public InputReader() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreElements()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }
}