//Question No: 5565
//Title: 영수증
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int totalNumber = scanner.nextInt();
        int sum = 0;
        
        for (int i = 0; i < 9; i++) {
            int inputNumber = scanner.nextInt();
            sum += inputNumber;
        }
        
        System.out.println(totalNumber - sum);
    }
}