//Question No: 11653
//Title: 소인수분해
//Tier: Bronze I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int number = in.nextInt();

        for (int factor = 2; factor <= Math.sqrt(number); factor++) {
            while (number % factor == 0) {
                System.out.println(factor);
                number /= factor;
            }
        }
        if (number != 1) {
            System.out.println(number);
        }
    }
}
