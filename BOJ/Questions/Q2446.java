//Question No: 2446
//Title: 별 찍기 - 9
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int size = scanner.nextInt();

        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (size * 2 - (i * 2 + 1)); k++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < size; i++) {
            for (int j = 1; j <= size - i - 1; j++) {
                System.out.print(" ");
            }
            for (int k = 1; k <= (i * 2 + 1); k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}