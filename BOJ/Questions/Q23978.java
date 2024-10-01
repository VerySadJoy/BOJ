//Question No: 23978
//Title: 급상승
//Tier: Gold V
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalElements = scanner.nextInt();
        long targetSum = scanner.nextLong();
        long[] array = new long[totalElements + 1];

        for (int i = 0; i < totalElements; i++) {
            array[i] = scanner.nextLong();
        }

        long left = 1, right = 1500000000;
        long answer = Long.MAX_VALUE;

        while (left <= right) {
            long mid = (left + right) / 2;
            long sum = mid * (mid + 1) / 2;

            for (int i = 0; i < totalElements - 1; i++) {
                long difference = Math.min(mid, array[i + 1] - array[i]);
                sum += mid * difference - (difference - 1) * difference / 2;
            }

            if (sum >= targetSum) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}