//Question No: 8393
//Title: 합
//Tier: Bronze V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        int sum = 0;
        
        for (int i = 1; i <= number; i++) {
            sum += i;
        }
        
        System.out.println(sum);
    }
}