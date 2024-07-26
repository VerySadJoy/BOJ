//Question No: 17087
//Title: 숨바꼭질 6
//Tier: Silver II
import java.util.Scanner;

public class Main {
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numPoints = scanner.nextInt();
        int s = scanner.nextInt();
        int gcdValue = -1;

        for (int i = 0; i < numPoints; i++) {
            int point = scanner.nextInt();
            int distance = Math.abs(s - point);
            if (gcdValue != -1) {
                gcdValue = gcd(gcdValue, distance);
            } else {
                gcdValue = distance;
            }
        }

        System.out.println(gcdValue);
        scanner.close();
    }
}