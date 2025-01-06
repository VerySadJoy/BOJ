//Question No: 23813
//Title: 회전
//Tier: Bronze II
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[] n = reader.readLine().toCharArray();
        int length = n.length;
        long total = 0;

        for (int i = 0; i < length; i++) {
            char last = n[length - 1];
            System.arraycopy(n, 0, n, 1, length - 1);
            n[0] = last;
            total += Long.parseLong(new String(n));
        }

        System.out.println(total);
    }
}