//Question No: 9272
//Title: 상근이의 아이디어
//Tier: Silver II
import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int startNumber = scanner.nextInt();
        int endNumber = scanner.nextInt();
        scanner.close();

        System.out.println(calculateSum(startNumber, endNumber));
    }

    private static int calculateSum(int startNumber, int endNumber) {
        int difference = endNumber - startNumber;
        return difference * (difference + 1) / 2;
    }
}
