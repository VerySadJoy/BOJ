//Question No: 25632
//Title: 소수 부르기 게임
//Tier: Silver III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int YT1 = Integer.parseInt(st.nextToken());
        int YT2 = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int YJ1 = Integer.parseInt(st.nextToken());
        int YJ2 = Integer.parseInt(st.nextToken());

        int min = Math.min(Math.min(YT1, YT2), Math.min(YJ1, YJ2));
        int max = Math.max(Math.max(YT1, YT2), Math.max(YJ1, YJ2));

        List<Integer> allPrimes = getPrimes(min, max);
        List<Integer> YTPrimes = new ArrayList<>();
        List<Integer> YJPrimes = new ArrayList<>();
        List<Integer> nesting = new ArrayList<>();

        for (int prime : allPrimes) {
            if (prime >= YT1 && prime <= YT2) {
                if (prime < YJ1 || prime > YJ2) {
                    YTPrimes.add(prime);
                } else {
                    nesting.add(prime);
                }
            }
            if (prime >= YJ1 && prime <= YJ2) {
                if (prime < YT1 || prime > YT2) {
                    YJPrimes.add(prime);
                }
            }
        }

        if (YTPrimes.size() > YJPrimes.size()) {
            System.out.println("yt");
        } else if (YTPrimes.size() < YJPrimes.size()) {
            System.out.println("yj");
        } else {
            System.out.println(nesting.size() % 2 == 0 ? "yj" : "yt");
        }
    }

    private static List<Integer> getPrimes(int start, int end) {
        boolean[] isPrime = new boolean[end + 1];
        Arrays.fill(isPrime, true);
        List<Integer> primes = new ArrayList<>();
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= end; i++) {
            if (isPrime[i]) {
                if (i >= start) primes.add(i);
                for (int j = i * 2; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return primes;
    }
}