//Question No: 1182
//Title: 부분수열의 합
//Tier: Silver II
import java.util.Scanner;

public class Main {
    static int[] numbers;
    private static int numberCount;
    private static int targetSum;
    private static int resultCount = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        numberCount = scanner.nextInt();
        targetSum = scanner.nextInt();
        numbers = new int[numberCount];
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = scanner.nextInt();
        }
        findSubsets(0, 0);
        if (targetSum == 0) {
            System.out.println(resultCount - 1);
        } else {
            System.out.println(resultCount);
        }
    }

    private static void findSubsets(int depth, int currentSum) {
        if (depth == numberCount) {
            if (currentSum == targetSum) {
                resultCount++;
            }
            return;
        }
        findSubsets(depth + 1, currentSum + numbers[depth]);
        findSubsets(depth + 1, currentSum);
    }
}