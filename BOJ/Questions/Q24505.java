//Question No: 24505
//Title: blobhyperthink
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {

    static final int MOD = 1000000007;
    static int N;
    static long[][] tree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        tree = new long[2 * N][11];

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            update(nums[i] - 1, 1, 0);
            if (nums[i] == 1) {
                continue;
            }
            for (int j = 1; j <= 10; j++) {
                long res = search(0, nums[i] - 2, j - 1);
                update(nums[i] - 1, res, j);
            }
        }

        System.out.println(tree[1][10] % MOD);
    }

    static void update(int index, long value, int depth) {
        index += N;
        while (index > 0) {
            tree[index][depth] = (tree[index][depth] + value) % MOD;
            index /= 2;
        }
    }

    static long search(int left, int right, int depth) {
        left += N;
        right += N;
        long result = 0;
        while (left <= right) {
            if (left % 2 == 1) {
                result = (result + tree[left][depth]) % MOD;
                left++;
            }
            if (right % 2 == 0) {
                result = (result + tree[right][depth]) % MOD;
                right--;
            }
            left /= 2;
            right /= 2;
        }
        return result;
    }
}