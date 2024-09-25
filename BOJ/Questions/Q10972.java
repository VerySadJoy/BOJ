//Question No: 10972
//Title: 다음 순열
//Tier: Silver III
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        if (nextPermutation(a)) {
            for (int val : a) {
                sb.append(val).append(" ");
            }
        } else {
            sb.append("-1");
        }

        System.out.println(sb);
    }

    public static boolean nextPermutation(int[] a) {
        int i = a.length - 1;

        while (i > 0 && a[i - 1] >= a[i]) {
            i--;
        }

        if (i <= 0) return false;

        int j = a.length - 1;

        while (a[i - 1] >= a[j]) {
            j--;
        }

        int temp = a[j];
        a[j] = a[i - 1];
        a[i - 1] = temp;

        j = a.length - 1;

        while (i < j) {
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }

        return true;
    }
}