//Question No: 1639
//Title: 행운의 티켓
//Tier: Silver IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.next();
        int[] digits = new int[input.length()];
        for (int i = 0; i < input.length(); i++) {
            digits[i] = Integer.parseInt(String.valueOf(input.charAt(i)));
        }

        int start, mid, end;
        int searchStart, searchEnd;
        int leftSum, rightSum;

        end = input.length() % 2 == 0 ? input.length() : input.length() - 1;
        end += 2;

        while (end > 2) {
            start = 0;
            end -= 2;
            searchEnd = end;
            searchStart = start;

            while (searchEnd <= input.length()) {
                mid = (searchStart + searchEnd) / 2;
                leftSum = 0;
                rightSum = 0;

                for (int l = searchStart; l < mid; l++) {
                    leftSum += digits[l];
                }

                for (int r = mid; r < searchEnd; r++) {
                    rightSum += digits[r];
                }

                if (leftSum == rightSum) {
                    System.out.println(end);
                    return;
                }
                searchStart++;
                searchEnd++;
            }
        }
        System.out.println(0);
    }
}
