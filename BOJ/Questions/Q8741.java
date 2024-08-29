//Question No: 8741
//Title: 이진수 합
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfOnes = scanner.nextInt();
        String result = "1".repeat(numberOfOnes) + "0".repeat(numberOfOnes - 1);
        System.out.println(result);
        scanner.close();
    }
}