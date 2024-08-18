//Question No: 4948
//Title: 베르트랑 공준
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static boolean[] isNotPrime = new boolean[246913];
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        generatePrimes();
        
        while (true) {
            int n = Integer.parseInt(reader.readLine());
            if (n == 0) break;
            
            int primeCount = 0;
            
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime[i]) primeCount++;
            }
            System.out.println(primeCount);
        }        
    }
    
    public static void generatePrimes() {
        isNotPrime[0] = isNotPrime[1] = true;
        
        for (int i = 2; i <= Math.sqrt(isNotPrime.length); i++) {
            if (isNotPrime[i]) continue;
            for (int j = i * i; j < isNotPrime.length; j += i) {
                isNotPrime[j] = true;
            }
        }
    }
}