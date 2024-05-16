//Question No: 2473
//Title: 세 용액
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] solutions = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            solutions[i] = Integer.parseInt(st.nextToken());
        }
        br.close();

        Arrays.sort(solutions);
        long minSum = Long.MAX_VALUE;
        int ansA = 0, ansB = 0, ansC = 0;

        for (int i = 0; i < N - 2; i++) {
            int left = i + 1, right = N - 1;

            while (left < right) {
                long sum = (long) solutions[i] + solutions[left] + solutions[right];

                if (Math.abs(sum) < minSum) {
                    minSum = Math.abs(sum);
                    ansA = solutions[i];
                    ansB = solutions[left];
                    ansC = solutions[right];
                }

                if (sum < 0) {
                    left++;
                } else if (sum > 0) {
                    right--;
                } else {
                    System.out.println(ansA + " " + ansB + " " + ansC);
                    return;
                }
            }
        }

        System.out.println(ansA + " " + ansB + " " + ansC);
    }
}
