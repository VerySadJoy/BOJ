//Question No: 14445
//Title: 케이크(?) 자르기
//Tier: Gold V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(n > 1 ? (n + 1) / 2 : 0);
        scanner.close();
    }
}