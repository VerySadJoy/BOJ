//Question No: 1990
//Title: 소수인팰린드롬
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean[] primeFlags = new boolean[100_000_001];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int lowerBound = Integer.parseInt(tokenizer.nextToken());
        int upperBound = Integer.parseInt(tokenizer.nextToken());

        sieveOfEratosthenes();

        StringBuilder result = new StringBuilder();
        for (int number = lowerBound; number <= upperBound; number++) {
            if (!primeFlags[number] && isPalindrome(number)) {
                result.append(number).append("\n");
            }
        }
        result.append(-1);
        System.out.println(result);
    }

    public static boolean isPalindrome(int number) {
        String str = String.valueOf(number);
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            if (str.charAt(i) != str.charAt(length - i - 1)) {
                return false;
            }
        }
        return true;
    }

    public static void sieveOfEratosthenes() {
        primeFlags[0] = primeFlags[1] = true;

        for (int i = 2; i * i <= 100_000_000; i++) {
            if (!primeFlags[i]) {
                for (int j = i * i; j <= 100_000_000; j += i) {
                    primeFlags[j] = true;
                }
            }
        }
    }
}