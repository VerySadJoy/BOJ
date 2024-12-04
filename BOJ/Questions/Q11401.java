//Question No: 11401
//Title: 이항 계수 3
//Tier: Gold I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    private static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        long totalElements = Long.parseLong(tokenizer.nextToken());
        long chosenElements = Long.parseLong(tokenizer.nextToken());
        
        long numerator = factorial(totalElements);
        long denominator = (factorial(chosenElements) * factorial(totalElements - chosenElements)) % MOD;
        
        long result = numerator * modularInverse(denominator, MOD - 2) % MOD;
        System.out.println(result);
    }

    private static long factorial(long number) {
        long result = 1;
        while (number > 1) {
            result = (result * number) % MOD;
            number--;
        }
        return result;
    }

    private static long modularInverse(long base, long exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }
}