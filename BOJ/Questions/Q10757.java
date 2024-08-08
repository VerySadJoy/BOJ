//Question No: 10757
//Title: 큰 수 A+B
//Tier: Bronze V
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger number1 = scanner.nextBigInteger();
        BigInteger number2 = scanner.nextBigInteger();
        System.out.println(number1.add(number2));
    }
}