//Question No: 11022
//Title: A+B - 8
//Tier: Bronze V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 1; i <= testCases; i++) {
            int num1 = scanner.nextInt();
            int num2 = scanner.nextInt();
            int sum = num1 + num2;
            System.out.printf("Case #%d: %d + %d = %d%n", i, num1, num2, sum);
        }
    }
}