//Question No: 10844
//Title: 쉬운 계단 수
//Tier: Silver I
import java.util.Scanner;

public class Main {
    static final long MODULO = 1000000000;
    static long[][] stairNumbers = new long[101][10];

    static long calculateStairNumbers(int digits) {
        for (int i = 1; i <= 9; i++) {
            stairNumbers[1][i] = 1;
        }
        
        for (int i = 2; i <= digits; i++) {
            stairNumbers[i][0] = stairNumbers[i - 1][1] % MODULO;
            for (int j = 1; j <= 8; j++) {
                stairNumbers[i][j] = (stairNumbers[i - 1][j - 1] + stairNumbers[i - 1][j + 1]) % MODULO;
            }
            stairNumbers[i][9] = stairNumbers[i - 1][8] % MODULO;
        }
        
        long totalStairNumbers = 0;
        for (int i = 0; i <= 9; i++) {
            totalStairNumbers = (totalStairNumbers + stairNumbers[digits][i]) % MODULO;
        }
        
        return totalStairNumbers;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int digits = scanner.nextInt();
        System.out.println(calculateStairNumbers(digits));
        scanner.close();
    }
}