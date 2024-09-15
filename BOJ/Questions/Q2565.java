//Question No: 2565
//Title: 전깃줄
//Tier: Gold V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;
import java.util.Comparator;

public class Main {

    static Integer[] dp;
    static int[][] wires;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(reader.readLine());

        dp = new Integer[count];
        wires = new int[count][2];

        StringTokenizer tokenizer;

        for (int i = 0; i < count; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            wires[i][0] = Integer.parseInt(tokenizer.nextToken());
            wires[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(wires, new Comparator<int[]>() {
            @Override
            public int compare(int[] wire1, int[] wire2) {
                return wire1[0] - wire2[0];
            }
        });

        int maxConnections = 0;

        for (int i = 0; i < count; i++) {
            maxConnections = Math.max(findMaxConnections(i), maxConnections);
        }

        System.out.println(count - maxConnections);
    }

    static int findMaxConnections(int index) {
        if (dp[index] == null) {
            dp[index] = 1;
            for (int i = index + 1; i < dp.length; i++) {
                if (wires[index][1] < wires[i][1]) {
                    dp[index] = Math.max(dp[index], findMaxConnections(i) + 1);
                }
            }
        }
        return dp[index];
    }
}