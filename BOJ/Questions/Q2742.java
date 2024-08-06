//Question No: 2742
//Title: 기찍 N
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        
        for (int i = number; i > 0; i--) {
            System.out.println(i);
        }
    }
}