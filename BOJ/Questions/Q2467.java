//Question No: 2467
//Title: 용액
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
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

        int left = 0, right = N - 1;
        int minAbsSum = Integer.MAX_VALUE;
        int ansLeft = 0, ansRight = 0;

        while (left < right) {
            int sum = solutions[left] + solutions[right];
            int absSum = Math.abs(sum);

            if (absSum < minAbsSum) {
                minAbsSum = absSum;
                ansLeft = solutions[left];
                ansRight = solutions[right];
            }

            if (sum < 0) {
                left++;
            } else if (sum > 0) {
                right--;
            } else {
                ansLeft = solutions[left];
                ansRight = solutions[right];
                break;
            }
        }

        System.out.println(ansLeft + " " + ansRight);
    }
}
