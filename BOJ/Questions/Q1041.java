//Question No: 1041
//Title: 주사위
//Tier: Gold V
import java.io.*;
import java.util.Arrays;

public class Main {

    static long N;
    static int[] dice = new int[6];
    static long[] faceCount = new long[4];
    static long result;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(br.readLine());

        faceCount[1] = 5 * (N - 2) * (N - 2) + 4 * (N - 2);
        faceCount[2] = 8 * (N - 2) + 4;
        faceCount[3] = 4;

        String[] input = br.readLine().split(" ");
        for (int i = 0; i < 6; i++)
            dice[i] = Integer.parseInt(input[i]);

        if (N == 1) {
            Arrays.sort(dice);
            int sum = 0;
            for (int i = 0; i < 5; i++) {
                sum += dice[i];
            }
            bw.write(sum + "\n");
        } else {
            long min = dice[0];
            for (int i = 1; i < 6; i++) {
                min = Math.min(min, dice[i]);
            }
            result += faceCount[1] * min;

            min = Long.MAX_VALUE;
            for (int i = 0; i < 6; i++) {
                for (int j = i + 1; j < 6; j++) {
                    if (j + i != 5) {
                        min = Math.min(min, dice[i] + dice[j]);
                    }
                }
            }
            result += faceCount[2] * min;

            int sum = 0;
            for (int i = 0; i < 3; i++) {
                sum += Math.min(dice[i], dice[5 - i]);
            }
            result += faceCount[3] * sum;

            bw.write(result + "\n");
        }
        bw.flush();
    }
}
