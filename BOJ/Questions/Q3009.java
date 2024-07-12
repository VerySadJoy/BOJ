//Question No: 3009
//Title: 네 번째 점
//Tier: Bronze III
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] point1 = { scanner.nextInt(), scanner.nextInt() };
        int[] point2 = { scanner.nextInt(), scanner.nextInt() };
        int[] point3 = { scanner.nextInt(), scanner.nextInt() };

        scanner.close();

        int x, y;

        if (point1[0] == point2[0]) {
            x = point3[0];
        } else if (point1[0] == point3[0]) {
            x = point2[0];
        } else {
            x = point1[0];
        }

        if (point1[1] == point2[1]) {
            y = point3[1];
        } else if (point1[1] == point3[1]) {
            y = point2[1];
        } else {
            y = point1[1];
        }

        System.out.println(x + " " + y);
    }
}
