//Question No: 2581
//Title: 소수
//Tier: Bronze II
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        ArrayList<Integer> primeList = new ArrayList<>();

        for (int i = start; i <= end; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }

        if (primeList.isEmpty()) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int prime : primeList) {
                sum += prime;
            }
            System.out.println(sum);
            System.out.println(primeList.get(0));
        }
    }

    public static boolean isPrime(int number) {
        if (number < 2) return false;
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}