//Question No: 1550
//Title: 16진수
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hexInput = scanner.next();
        int decimalValue = Integer.parseInt(hexInput, 16);
        System.out.println(decimalValue);
        scanner.close();
    }
}