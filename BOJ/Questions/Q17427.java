//Question No: 17427
//Title: 약수의 합 2
//Tier: Silver II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;

        for (int i = 1; i <= n; i++) {
            sum += (n / i) * i;
        }

        System.out.println(sum);
    }
}
