//Question No: 20958
//Title: 아린과 슬롯머신
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {
    private static final int MAX_N = (int) 1e7 + 2;
    private static final int KEY_NUM = 3163;
    @SuppressWarnings("FieldMayBeFinal")
    private static boolean[] isPrime = new boolean[MAX_N];
    @SuppressWarnings("FieldMayBeFinal")
    private static List<Integer> primes = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        initializePrimes();

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int arraySize = Integer.parseInt(tokenizer.nextToken());
        int rangeSize = Integer.parseInt(tokenizer.nextToken());
        int[] array = new int[arraySize];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        if (!validateArray(array)) {
            System.out.println(-1);
            return;
        }

        int adjustments = calculateAdjustments(array, rangeSize);
        System.out.println(adjustments);
    }

    private static void initializePrimes() {
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;

        for (int i = 2; i < MAX_N; i++) {
            if (isPrime[i]) {
                primes.add(i);
                for (int j = i + i; j < MAX_N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    private static boolean validateArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] % 7 != 0) {
                return false;
            }
            array[i] /= 7;
            if (array[i] % 7 == 0) {
                return false;
            }
        }
        return true;
    }

    private static int calculateAdjustments(int[] array, int rangeSize) {
        int adjustments = 0;
        for (int prime : primes) {
            if (prime >= KEY_NUM) {
                break;
            }

            int[] rangeReduction = new int[array.length + rangeSize];
            int maxExponent = 0;

            for (int i = 0; i < array.length; i++) {
                int currentValue = array[i];
                int count = 0;

                while (currentValue % prime == 0) {
                    currentValue /= prime;
                    count++;
                }
                array[i] = currentValue;

                if (maxExponent < count) {
                    adjustments += count - maxExponent;
                    rangeReduction[i + rangeSize - 1] = count - maxExponent;
                    maxExponent = count;
                }

                maxExponent -= rangeReduction[i];
            }
        }

        Set<Integer> uniqueFactors = new HashSet<>();
        uniqueFactors.add(1);
        int[] factorExpiry = new int[array.length + rangeSize];

        for (int i = 0; i < array.length; i++) {
            int currentValue = array[i];

            if (!uniqueFactors.contains(currentValue)) {
                uniqueFactors.add(currentValue);
                factorExpiry[i + rangeSize - 1] = currentValue;
                adjustments++;
            }

            if (factorExpiry[i] != 0) {
                uniqueFactors.remove(factorExpiry[i]);
            }
        }

        return adjustments;
    }
}