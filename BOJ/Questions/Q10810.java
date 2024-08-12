//Question No: 10810
//Title: 공 넣기
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] array = new int[101];

        for (int i = 0; i < m; i++) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            int value = scanner.nextInt();
            for (int k = start; k <= end; k++) {
                array[k] = value;
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}