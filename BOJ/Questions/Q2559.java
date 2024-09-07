//Question No: 2559
//Title: 수열
//Tier: Silver III
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfElements = scanner.nextInt();
        int windowSize = scanner.nextInt();

        int[] prefixSum = new int[numberOfElements + 1];
        int maxSum = Integer.MIN_VALUE;

        for (int i = 1; i <= numberOfElements; i++) {
            int currentInput = scanner.nextInt();
            prefixSum[i] = prefixSum[i - 1] + currentInput;
        }

        for (int i = windowSize; i <= numberOfElements; i++) {
            maxSum = Math.max(maxSum, prefixSum[i] - prefixSum[i - windowSize]);
        }

        System.out.println(maxSum);
    }
}