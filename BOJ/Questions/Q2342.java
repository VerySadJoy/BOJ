//Question No: 2342
//Title: Dance Dance Revolution
//Tier: Gold III
import java.io.*;
import java.util.Arrays;

public class Main {
    static int[] move;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] line = br.readLine().split(" ");
        move = new int[line.length - 1];
        for (int i = 0; i < line.length - 1; i++) {
            move[i] = Integer.parseInt(line[i]);
        }

        int n = move.length;
        dp = new int[5][5][n];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        System.out.println(solve(0, 0, 0));

        br.close();
    }

    static int solve(int left, int right, int cnt) {
        if (cnt == move.length) return 0;
        if (dp[left][right][cnt] != -1) return dp[left][right][cnt];

        int nextStep = move[cnt];
        dp[left][right][cnt] = Math.min(
                solve(nextStep, right, cnt + 1) + energy(left, nextStep),
                solve(left, nextStep, cnt + 1) + energy(right, nextStep)
        );

        return dp[left][right][cnt];
    }

    static int energy(int pos, int des) {
        int num = Math.abs(pos - des);
        if (pos == 0) return 2;
        else if (num == 0) return 1;
        else if (num == 1 || num == 3) return 3;
        else return 4;
    }
}

