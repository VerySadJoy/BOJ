//Question No: 2441
//Title: 별 찍기 - 4
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfRows = scanner.nextInt();

        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = 1; j <= i - 1; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= numberOfRows - i + 1; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}