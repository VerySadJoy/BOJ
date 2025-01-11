//Question No: 9359
//Title: 서로소
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {

    static List<Long> primes = new ArrayList<>();
    static List<Long> divisors;
    static Map<Long, Integer> primeMap;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        sieveOfEratosthenes(100000);

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            long a = Long.parseLong(tokenizer.nextToken());
            long b = Long.parseLong(tokenizer.nextToken());
            long n = Long.parseLong(tokenizer.nextToken());

            divisors = new ArrayList<>();
            primeMap = new HashMap<>();

            decomposeIntoPrimes(n);

            for (Long key : primeMap.keySet()) {
                divisors.add(key);
            }

            long result = calculateCount(a, b);
            System.out.println("Case #" + caseNum + ": " + result);
        }
    }

    private static void sieveOfEratosthenes(int limit) {
        boolean[] isPrime = new boolean[limit + 1];
        Arrays.fill(isPrime, true);

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                primes.add((long) i);
                for (int j = i + i; j <= limit; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private static void decomposeIntoPrimes(long n) {
        for (long prime : primes) {
            if (prime * prime > n) {
                break;
            }

            if (n % prime == 0) {
                primeMap.put(prime, 1);
                while (n % prime == 0) {
                    n /= prime;
                }
            }
        }

        if (n > 1) {
            primeMap.put(n, 1);
        }
    }

    private static long calculateCount(long a, long b) {
        long count = 0;
        long totalCombinations = 1L << divisors.size();

        for (int i = 1; i < totalCombinations; i++) {
            long product = 1;
            int bitCount = 0;

            for (int j = 0; j < divisors.size(); j++) {
                if ((i & (1 << j)) != 0) {
                    product *= divisors.get(j);
                    bitCount++;
                }
            }

            long lowerBound = (a + product - 1) / product;
            long upperBound = b / product;

            if (lowerBound <= upperBound) {
                if (bitCount % 2 == 1) {
                    count += (upperBound - lowerBound + 1);
                } else {
                    count -= (upperBound - lowerBound + 1);
                }
            }
        }

        return (b - a + 1) - count;
    }
}