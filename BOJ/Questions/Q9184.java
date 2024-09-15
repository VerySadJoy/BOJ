//Question No: 9184
//Title: 신나는 함수 실행
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int[][][] memoization = new int[21][21][21];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");

            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            int c = Integer.parseInt(tokenizer.nextToken());

            if (a == -1 && b == -1 && c == -1) {
                break;
            }

            output.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ")
                  .append(computeW(a, b, c)).append('\n');
        }

        System.out.println(output);
    }

    static int computeW(int a, int b, int c) {
        if (isInRange(a, b, c) && memoization[a][b][c] != 0) {
            return memoization[a][b][c];
        }

        if (a <= 0 || b <= 0 || c <= 0) {
            return 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return memoization[20][20][20] = computeW(20, 20, 20);
        }

        if (a < b && b < c) {
            return memoization[a][b][c] = computeW(a, b, c - 1) + computeW(a, b - 1, c - 1) - computeW(a, b - 1, c);
        }

        return memoization[a][b][c] = computeW(a - 1, b, c) + computeW(a - 1, b - 1, c) + computeW(a - 1, b, c - 1) 
               - computeW(a - 1, b - 1, c - 1);
    }

    static boolean isInRange(int a, int b, int c) {
        return 0 <= a && a <= 20 && 0 <= b && b <= 20 && 0 <= c && c <= 20;
    }
}