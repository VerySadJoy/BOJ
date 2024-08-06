//Question No: 25304
//Title: 영수증
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int totalAmount = scanner.nextInt(); 
        int itemCount = scanner.nextInt(); 
        int calculatedTotal = 0;

        for (int i = 0; i < itemCount; i++) {
            int itemPrice = scanner.nextInt(); 
            int itemQuantity = scanner.nextInt(); 
            calculatedTotal += itemPrice * itemQuantity;
        }

        if (calculatedTotal == totalAmount) {
            System.out.println("Yes");
        }
        else {
            System.out.println("No");
        }
    }
}