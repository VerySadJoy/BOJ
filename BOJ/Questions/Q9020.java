//Question No: 9020
//Title: 골드바흐의 추측
//Tier: Silver II
import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int testCases = Integer.parseInt(reader.readLine());
            
            isPrime = new boolean[10001];
            Arrays.fill(isPrime, true);
            
            isPrime[0] = false;
            isPrime[1] = false;
            
            for (int i = 2; i * i < 10001; i++) {
                if (isPrime[i]) {
                    for (int j = i * i; j < 10001; j += i) {
                        isPrime[j] = false;
                    }
                }
            }
            
            for (int i = 0; i < testCases; i++) {
                int number = Integer.parseInt(reader.readLine());
                int half = number / 2;
                
                for (int j = half; j >= 2; j--) {
                    if (isPrime[j] && isPrime[number - j]) {
                        System.out.println(j + " " + (number - j));
                        break;
                    }
                }
            }
        }
    }
}