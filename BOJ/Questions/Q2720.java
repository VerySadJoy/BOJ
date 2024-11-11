//Question No: 2720
//Title: 세탁소 사장 동혁
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            int cents = scanner.nextInt();

            int quarters = cents / 25;
            cents %= 25;

            int dimes = cents / 10;
            cents %= 10;

            int nickels = cents / 5;
            cents %= 5;

            int pennies = cents;

            System.out.println(quarters + " " + dimes + " " + nickels + " " + pennies);
        }

        scanner.close();
    }
}