//Question No: 22943
//Title: 수
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int digitLength = Integer.parseInt(tokenizer.nextToken());
        int divisor = Integer.parseInt(tokenizer.nextToken());
        int validCount = 0;
        boolean isPrime;
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        int[] numberStatus = new int[100001];

        for (int i = 2; i < Math.pow(10, digitLength); ++i) {
            isPrime = true;
            for (int prime : primeNumbers) {
                if (i % prime == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeNumbers.add(i);
            }
        }

        for (int i = 0; i < primeNumbers.size(); ++i) {
            for (int j = i + 1; j < primeNumbers.size(); ++j) {
                int sum = primeNumbers.get(i) + primeNumbers.get(j);
                if (sum >= 100000) {
                    break;
                }
                numberStatus[sum] = 1;
            }
        }

        for (int i = 0; i < primeNumbers.size(); ++i) {
            for (int j = i; j < primeNumbers.size(); ++j) {
                long product = (long) primeNumbers.get(i) * (long) primeNumbers.get(j);
                if (product < 100_000) {
                    numberStatus[(int) product] |= 2;
                }
            }
        }

        for (int i = (int) Math.pow(10, digitLength - 1); i < Math.pow(10, digitLength); ++i) {
            int bitMask = 0;
            int originalNumber = i;
            int dividedNumber = i;

            if ((numberStatus[i] & 1) == 0) {
                continue;
            }

            while (dividedNumber % divisor == 0) {
                dividedNumber /= divisor;
            }

            if ((numberStatus[dividedNumber] & 2) != 0) {
                numberStatus[i] = 7;
            } else {
                continue;
            }

            for (int j = 0; j < digitLength; ++j) {
                if ((bitMask & (1 << (originalNumber % 10))) != 0) {
                    bitMask = 0;
                    break;
                }
                bitMask |= (1 << (originalNumber % 10));
                originalNumber /= 10;
            }

            validCount = bitMask != 0 ? validCount + 1 : validCount;
        }

        writer.write(validCount + "\n");
        writer.close();
    }
}