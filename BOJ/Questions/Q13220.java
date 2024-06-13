//Question No: 13220
//Title: Secret
//Tier: Silver I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];

        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
        }

        for (int i = 0; i < N; i++) {
            b[i] = scanner.nextInt();
        }
        int idxA = 0;
        int idxB = 0;
        while (idxA < 2 * N) {
            if (a[idxA % N] == b[idxB]) {
                idxB++;
                if (idxB == N) {
                    System.out.println("YES");
                    return;
                }
            }
            idxA++;
        }

        System.out.println("NO");
    }
}

