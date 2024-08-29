//Question No: 3460
//Title: 이진수
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();
        
        for (int t = 0; t < testCases; t++) {
            int number = scanner.nextInt();
            String binaryString = Integer.toBinaryString(number);
            
            for (int i = 0; i < binaryString.length(); i++) {
                if (binaryString.charAt(binaryString.length() - 1 - i) == '1') {
                    System.out.print(i + " ");
                }
            }
            System.out.println();
        }
    }
}