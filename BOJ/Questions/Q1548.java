//Question No: 1548
//Title: 부분 삼각 수열
//Tier: Gold V
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] data = new int[n];
        
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        Arrays.sort(data);

        if (n > 2) {
            int maxLength = 2;
            for (int start = 0; start < n - 2; start++) {
                int end = start + 2;
                while (true) {
                    if (data[start] + data[start + 1] > data[end]) {
                        maxLength = Math.max(maxLength, end - start + 1);
                        end++;
                        if (end == n) break;
                    } else {
                        break;
                    }
                }
            }
            System.out.println(maxLength);
        } else {
            System.out.println(n);
        }
    }
}
