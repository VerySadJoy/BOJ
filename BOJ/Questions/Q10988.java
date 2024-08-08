//Question No: 10988
//Title: 팰린드롬인지 확인하기
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String reversedInput = new StringBuilder(input).reverse().toString();
        
        if (input.equals(reversedInput)) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }
}