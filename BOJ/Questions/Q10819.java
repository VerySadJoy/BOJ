//Question No: 10819
//Title: 차이를 최대로
//Tier: Silver II
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static int maxSum = Integer.MIN_VALUE;
    static int numElements;
    static int[] numbers, permutation;
    static boolean[] used;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        numElements = Integer.parseInt(tokenizer.nextToken());
        numbers = new int[numElements];
        used = new boolean[numElements];
        permutation = new int[numElements];

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numElements; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        findPermutations(0);

        System.out.println(maxSum);
    }

    public static void findPermutations(int count) {
        if (count == numElements) {
            maxSum = Math.max(maxSum, calculateSum());
            return;
        }

        for (int i = 0; i < numElements; i++) {
            if (!used[i]) {
                used[i] = true;
                permutation[count] = numbers[i];
                findPermutations(count + 1);
                used[i] = false;
            }
        }
    }

    public static int calculateSum() {
        int total = 0;
        for (int i = 0; i < numElements - 1; i++) {
            total += Math.abs(permutation[i] - permutation[i + 1]);
        }
        return total;
    }
}