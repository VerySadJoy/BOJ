//Question No: 29616
//Title: 인기투표
//Tier: Gold V
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arraySize = scanner.nextInt();
        scanner.nextInt();

        long[] firstArray = new long[arraySize];
        long[] secondArray = new long[arraySize];

        for (int i = 0; i < arraySize; i++) {
            firstArray[i] = scanner.nextLong();
        }

        for (int i = 0; i < arraySize; i++) {
            secondArray[i] = scanner.nextLong();
        }

        long gcdFirstArray = calculateGCD(firstArray);
        long gcdSecondArray = calculateGCD(secondArray);

        long sumFirstArray = 0;
        for (int i = 0; i < arraySize; i++) {
            firstArray[i] /= gcdFirstArray;
            sumFirstArray += firstArray[i];
        }

        for (int i = 0; i < arraySize; i++) {
            secondArray[i] /= gcdSecondArray;
        }

        long maxRatio = 1;
        for (int i = 0; i < arraySize; i++) {
            long ratio = (long) Math.ceil((double) firstArray[i] / secondArray[i]);
            if (maxRatio < ratio) {
                maxRatio = ratio;
            }
        }

        long sumSecondArray = 0;
        for (int i = 0; i < arraySize; i++) {
            secondArray[i] *= maxRatio;
            sumSecondArray += secondArray[i];
        }

        System.out.println(sumFirstArray + " " + sumSecondArray);
    }

    public static long calculateGCD(long[] array) {
        long result = array[0];
        for (int i = 1; i < array.length; i++) {
            result = calculateGCD(result, array[i]);
        }
        return result;
    }

    public static long calculateGCD(long a, long b) {
        if (b == 0) return a;
        return calculateGCD(b, a % b);
    }
}