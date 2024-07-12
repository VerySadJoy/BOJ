//Question No: 10430
//Title: 나머지
//Tier: Bronze V
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int num3 = scanner.nextInt();
 
        scanner.close();
 
        System.out.println((num1 + num2) % num3);
        System.out.println((num1 % num3 + num2 % num3) % num3);
        System.out.println((num1 * num2) % num3);
        System.out.println((num1 % num3 * num2 % num3) % num3);
    }
}
