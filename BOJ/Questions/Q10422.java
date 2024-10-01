//Question No: 10422
//Title: 괄호
//Tier: Gold IV
import java.util.Scanner;

public class Main {

    static final int MOD = 1000000007;
    static long[] dpArray = new long[5001];

    public static void initializeDP() {
        dpArray[0] = 1;
        for (int i = 2; i <= 5000; i += 2) {
            for (int j = 2; j <= i; j += 2) {
                dpArray[i] += dpArray[j - 2] * dpArray[i - j];
                dpArray[i] %= MOD;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeDP();

        int testCases = scanner.nextInt();
        for (int t = 0; t < testCases; t++) {
            int length = scanner.nextInt();
            System.out.println(dpArray[length]);
        }
    }
}