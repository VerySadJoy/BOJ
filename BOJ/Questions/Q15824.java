//Question No: 15824
//Title: 너 봄에는 캡사이신이 맛있단다
//Tier: Gold II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static class MyScanner {
        BufferedReader reader;
        StringTokenizer tokenizer;

        MyScanner() {
            reader = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

    static ArrayList<Long> flavors = new ArrayList<>();

    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        int n = sc.nextInt();

        long[] powerOfTwo = new long[n];
        powerOfTwo[0] = 1;
        int mod = 1000000007;

        for (int i = 0; i < n; i++) {
            flavors.add(sc.nextLong());
        }

        Collections.sort(flavors);

        for (int i = 0; i < n - 1; i++) {
            powerOfTwo[i + 1] = (powerOfTwo[i] * 2) % mod;
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            result = (result + flavors.get(i) * (-powerOfTwo[n - 1 - i] + powerOfTwo[i])) % mod;
        }
        System.out.println(result);
    }
}
