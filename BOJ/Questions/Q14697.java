//Question No: 14697
//Title: 방 배정하기
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int target = scanner.nextInt();
        boolean found = false;

        for (int i = 0; i <= target / a; i++) {
            for (int j = 0; j <= target / b; j++) {
                for (int k = 0; k <= target / c; k++) {
                    if (a * i + b * j + c * k == target) {
                        found = true;
                        break;
                    }
                }
                if (found) break;
            }
            if (found) break;
        }
        
        System.out.print(found ? "1" : "0");
    }
}