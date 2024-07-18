//Question No: 27966
//Title: △
//Tier: Silver III
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        scanner.close();

        System.out.println(n - 1 + (n - 2) * (n - 1));

        for (long i = 2; i <= n; i++) {
            System.out.println("1 " + i);
        }
    }
}
