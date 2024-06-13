//Question No: 25828
//Title: Corona Virus Testing
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static int solve(int g, int p, int t) {
        int origin = g * p;
        int newValue = g + p * t;
        if (origin < newValue) {
            return 1;
        } else if (origin > newValue) {
            return 2;
        } else {
            return 0;
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int g = scanner.nextInt();
        int p = scanner.nextInt();
        int t = scanner.nextInt();
        System.out.println(solve(g, p, t));
    }
}
