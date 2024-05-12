//Question No: 2143
//Title: 두 배열의 합
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long targetSum = Long.parseLong(br.readLine());

        int sizeA = Integer.parseInt(br.readLine());
        int[] arrayA = new int[sizeA];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeA; i++) {
            arrayA[i] = Integer.parseInt(st.nextToken());
        }

        int sizeB = Integer.parseInt(br.readLine());
        int[] arrayB = new int[sizeB];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < sizeB; i++) {
            arrayB[i] = Integer.parseInt(st.nextToken());
        }

        long[] sumA = calculateSubArraySums(arrayA);
        long[] sumB = calculateSubArraySums(arrayB);

        Arrays.sort(sumA);
        Arrays.sort(sumB);

        long count = countPairsWithTargetSum(sumA, sumB, targetSum);
        System.out.println(count);
    }

    static long[] calculateSubArraySums(int[] array) {
        int size = array.length;
        int subArraySize = size * (size + 1) / 2;
        long[] subArraySum = new long[subArraySize];
        int index = 0;

        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                sum += array[j];
                subArraySum[index++] = sum;
            }
        }
        return subArraySum;
    }

    static long countPairsWithTargetSum(long[] arrayA, long[] arrayB, long targetSum) {
        long count = 0;
        int sizeA = arrayA.length;

        for (int i = 0; i < sizeA;) {
            long currentSumA = arrayA[i];
            int frequencyA = upperBound(arrayA, currentSumA) - lowerBound(arrayA, currentSumA);
            int frequencyB = upperBound(arrayB, targetSum - currentSumA) - lowerBound(arrayB, targetSum - currentSumA);
            count += frequencyA * frequencyB;
            i += frequencyA;
        }
        return count;
    }

    static int upperBound(long[] array, long target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target >= array[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    static int lowerBound(long[] array, long target) {
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (target <= array[mid]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }
}
