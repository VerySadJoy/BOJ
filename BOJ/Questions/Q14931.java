//Question No: 14931
//Title: 물수제비 (SUJEBI)
//Tier: Silver I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int L = sc.nextInt();
        int[] pt = new int[L + 1];
        long[] val = new long[L + 1];
        
        for (int i = 1; i <= L; i++) {
            pt[i] = sc.nextInt();
        }
        
        for (int d = 1; d <= L; d++) {
            for (int i = d; i <= L; i += d) {
                val[d] += pt[i];
            }
        }
        
        long mx = 1;
        for (int d = 1; d <= L; d++) {
            if (val[(int) mx] < val[d]) {
                mx = d;
            }
        }
        
        if (val[(int) mx] <= 0) {
            System.out.println("0 0");
        } else {
            System.out.println(mx + " " + val[(int) mx]);
        }
        
        sc.close();
    }
}
