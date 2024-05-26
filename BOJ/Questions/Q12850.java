//Question No: 12850
//Title: 본대 산책2
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    static long[][] v = {
            { 0, 1, 0, 1, 0, 0, 0, 0 },
            { 1, 0, 1, 1, 0, 0, 0, 0 },
            { 0, 1, 0, 1, 1, 1, 0, 0 },
            { 1, 1, 1, 0, 0, 1, 0, 0 },
            { 0, 0, 1, 0, 0, 1, 1, 0 },
            { 0, 0, 1, 1, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 1, 0, 0, 1 },
            { 0, 0, 0, 0, 0, 1, 1, 0 }
    };

    final static long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int D = Integer.parseInt(br.readLine());

        long[][] ans = pow(D);

        System.out.println(ans[0][0]);
    }

    private static long[][] pow(int n) {
        if (n == 1) {
            return v;
        }

        long[][] temp = pow(n / 2);
        temp = multiply(temp, temp);
        if (n % 2 == 1) {
            temp = multiply(temp, v);
        }

        return temp;
    }

    private static long[][] multiply(long[][] a, long[][] b) {
        long[][] temp = new long[8][8];

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < 8; k++) {
                    temp[i][j] = (temp[i][j] + a[i][k] * b[k][j]) % MOD;
                }
            }
        }

        return temp;
    }

}

