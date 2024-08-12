//Question No: 1010
//Title: 다리 놓기
//Tier: Silver V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            long result = 1;
            int left = scanner.nextInt();
            int right = scanner.nextInt();

            int r = 1;
            for (int j = right; j > right - left; j--) {
                result *= j;
                result /= r;
                r++;
            }
            System.out.println(result);
        }
    }
}