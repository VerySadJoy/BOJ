//Question No: 4913
//Title: 페르마의 크리스마스 정리
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        int[] sieve = new int[1000001];
        int[] sieve2 = new int[1000001];
        
        for (int i = 2; i < 1000001; i++) {
            sieve[i] = 1;
        }
        
        for (int i = 2; i < 1500; i++) {
            if (sieve[i] == 1) {
                for (int j = 2 * i; j < 1000001; j += i) {
                    sieve[j] = 0;
                }
            }
        }
        
        sieve2[2] = 1;
        for (int i = 3; i < 1000001; i++) {
            if (sieve[i] == 1 && i % 4 == 1) {
                sieve2[i] = 1;
            }
        }
        
        for (int i = 1; i < 1000001; i++) {
            sieve[i] += sieve[i - 1];
            sieve2[i] += sieve2[i - 1];
        }
        
        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int lowerBound = Integer.parseInt(tokenizer.nextToken());
            int upperBound = Integer.parseInt(tokenizer.nextToken());
            
            if (lowerBound == -1 && upperBound == -1) {
                break;
            }
            
            int primeCount = 0;
            int specialPrimeCount = 0;
            
            if (lowerBound >= 1) {
                primeCount = sieve[upperBound] - sieve[lowerBound - 1];
                specialPrimeCount = sieve2[upperBound] - sieve2[lowerBound - 1];
            } else if (lowerBound < 1 && upperBound >= 0) {
                primeCount = sieve[upperBound];
                specialPrimeCount = sieve2[upperBound];
            }
            
            System.out.printf("%d %d %d %d%n", lowerBound, upperBound, primeCount, specialPrimeCount);
        }
    }
}