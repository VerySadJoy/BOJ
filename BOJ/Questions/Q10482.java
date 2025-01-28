//Question No: 10482
//Title: Goldbach’s Conjecture
//Tier: Silver II
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int max = 32001;
        boolean[] primes = new boolean[max];
        Arrays.fill(primes, true);
        primes[1] = false;

        for (int i = 2; i * i < max; i++) {
            if (primes[i]) {
                for (int j = i * i; j < max; j += i) {
                    primes[j] = false;
                }
            }
        }

        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i < max; i++) {
            if (primes[i]) {
                primeList.add(i);
            }
        }

        int t = Integer.parseInt(reader.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(reader.readLine());

            List<int[]> representations = new ArrayList<>();

            for (int i = 1; i <= n / 2; i++) {
                if (primes[i] && primes[n - i]) {
                    representations.add(new int[]{i, n - i});
                }
            }

            writer.write(n + " has " + representations.size() + " representation(s)\n");

            for (int[] pair : representations) {
                writer.write(pair[0] + "+" + pair[1] + "\n");
            }

            writer.write("\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}