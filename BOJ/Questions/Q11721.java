//Question No: 11721
//Title: 열 개씩 끊어 출력하기
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        for (int i = 0; i < input.length(); i += 10) {
            System.out.println(input.substring(i, Math.min(i + 10, input.length())));
        }
    }
}