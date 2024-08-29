//Question No: 17285
//Title: XORChic
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] characters = input.toCharArray();
        char key = (char) (characters[0] ^ 'C');

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < characters.length; i++) {
            result.append((char) (characters[i] ^ key));
        }

        System.out.println(result.toString());
    }
}