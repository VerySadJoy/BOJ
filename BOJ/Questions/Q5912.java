//Question No: 5912
//Title: Haybale Stacking
//Tier: Silver I
import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int k = scanner.nextInt();
        int[] h = new int[n + 1];
        int[] ps = new int[n + 1];
        
        for (int i = 0; i < k; i++) {
            int a = scanner.nextInt();
            int b = scanner.nextInt();
            h[a] += 1;
            if (b < n) {
                h[b + 1] -= 1;
            }
        }

        int cumulativeSum = 0;
        for (int i = 0; i <= n; i++) {
            cumulativeSum += h[i];
            ps[i] = cumulativeSum;
        }

        Arrays.sort(ps);
        int median = ps[(n + 1) / 2];
        
        System.out.println(median);
    }
}
