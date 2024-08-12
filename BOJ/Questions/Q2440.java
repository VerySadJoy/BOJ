//Question No: 2440
//Title: 별 찍기 - 3
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();

        for (int i = 1; i <= number; i++) {
            for (int j = 1; j <= number - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}