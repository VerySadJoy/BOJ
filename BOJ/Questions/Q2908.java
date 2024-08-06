//Question No: 2908
//Title: 상수
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String number1 = scanner.next();
        String number2 = scanner.next();
        String result = "";

        for (int i = 2; i >= 0; i--) {
            if (number1.charAt(i) > number2.charAt(i)) {
                result = number1;
                break;
            } else if (number1.charAt(i) < number2.charAt(i)) {
                result = number2;
                break;
            }
        }

        for (int i = 2; i >= 0; i--) {
            System.out.print(result.charAt(i));
        }
    }
}