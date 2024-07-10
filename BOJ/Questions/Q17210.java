//Question No: 17210
//Title: 문문문
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long num = scanner.nextLong();
        int first = scanner.nextInt();

        if (num > 5) {
            System.out.println("Love is open door");
        } else {
            for (int i = 0; i < num - 1; i++) {
                first ^= 1;
                System.out.println(first);
            }
        }

        scanner.close();
    }
}
