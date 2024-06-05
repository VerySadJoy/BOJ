//Question No: 11179
//Title: 2진수 뒤집기
//Tier: Bronze I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        String binaryString = Integer.toBinaryString(number);
        String reversedBinaryString = new StringBuilder(binaryString).reverse().toString();
        int result = Integer.parseInt(reversedBinaryString, 2);
        System.out.println(result);
        scanner.close();
    }
}
