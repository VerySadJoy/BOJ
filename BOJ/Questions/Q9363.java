//Question No: 9363
//Title: 큰 나눗셈
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    static int n, m;
    static int[] sieve = new int[1001000];
    static int[] acnt = new int[1000001];
    static int[] bcnt = new int[1000001];
    static List<Integer> a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        initializeSieve();

        int testCases = Integer.parseInt(reader.readLine());
        for (int x = 0; x < testCases; x++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(tokenizer.nextToken());
            m = Integer.parseInt(tokenizer.nextToken());
            a = readInputList(reader.readLine());
            b = readInputList(reader.readLine());

            Arrays.fill(acnt, 0);
            Arrays.fill(bcnt, 0);

            countFactors(a, acnt);
            countFactors(b, bcnt);

            for (int i = 2; i <= 1000000; i++) {
                int minCount = Math.min(acnt[i], bcnt[i]);
                acnt[i] -= minCount;
                bcnt[i] -= minCount;
            }

            long upper = calculateResult(acnt);
            long lower = calculateResult(bcnt);

            System.out.println("Case #" + (x + 1) + ": " + upper + " / " + lower);
        }
    }

    static void initializeSieve() {
        for (long i = 2; i * i <= 1000000; i++) {
            if (sieve[(int) i] != 0) continue;
            for (long j = i * i; j <= 1000000; j += i) {
                if (sieve[(int) j] == 0) {
                    sieve[(int) j] = (int) i;
                }
            }
        }
    }

    static List<Integer> readInputList(String line) {
        return Arrays.stream(line.split(" "))
                     .map(Integer::parseInt)
                     .collect(Collectors.toList());
    }

    static void countFactors(List<Integer> list, int[] countArray) {
        for (int i : list) {
            while (sieve[i] != 0) {
                countArray[sieve[i]]++;
                i /= sieve[i];
            }
            countArray[i]++;
        }
    }

    static long calculateResult(int[] countArray) {
        long result = 1;
        for (int i = 2; i <= 1000000; i++) {
            for (int j = 0; j < countArray[i]; j++) {
                result *= i;
            }
        }
        return result;
    }
}