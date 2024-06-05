//Question No: 9848
//Title: Gift
//Tier: Bronze III
import java.util.Scanner;

public class Q9848 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] li = new int[n];
        for (int i = 0; i < n; i++) {
            li[i] = scanner.nextInt();
        }
        int cnt = 0;
        for (int i = 0; i < n - 1; i++) {
            if (li[i] - li[i + 1] >= k) {
                cnt += 1;
            }
        }
        System.out.println(cnt);
        scanner.close();
    }
}
