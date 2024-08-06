//Question No: 2480
//Title: 주사위 세개
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
        
        if (num1 == num2 && num2 == num3) {
            System.out.print(10000 + num1 * 1000);
        }
        else if (num1 == num2 || num1 == num3) {
            System.out.print(1000 + num1 * 100);
        }
        else if (num2 == num3) {
            System.out.print(1000 + num2 * 100);
        }
        else {
            System.out.print(Math.max(Math.max(num1, num2), num3) * 100);
        }
    }
}