//Question No: 32228
//Title: 등차수열 만들기
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int N = Integer.parseInt(tokenizer.nextToken());
        int M = Integer.parseInt(tokenizer.nextToken());
        tokenizer = new StringTokenizer(reader.readLine());
        int[] A = new int[N];
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(tokenizer.nextToken());
        }
        System.out.println(eulerPhi(M));
    }

    public static List<Integer> primeFactorization(int N) {
        List<Integer> primeFactors = new ArrayList<>();
        int limit = (int) Math.sqrt(N) + 1;
        for (int i = 2; i <= limit; i++) {
            while (N % i == 0) {
                primeFactors.add(i);
                N /= i;
            }
        }
        if (N != 1) {
            primeFactors.add(N);
        }
        return primeFactors;
    }

    public static int eulerPhi(int N) {
        if (N == 1) {
            return 1;
        }
        List<Integer> primeFactors = primeFactorization(N);
        int result = 1;
        int count = 1;
        for (int i = 1; i < primeFactors.size(); i++) {
            if (!primeFactors.get(i).equals(primeFactors.get(i - 1))) {
                int p = primeFactors.get(i - 1);
                result *= Math.pow(p, count - 1) * (p - 1);
                count = 1;
            } else {
                count++;
            }
        }
        int p = primeFactors.get(primeFactors.size() - 1);
        result *= Math.pow(p, count - 1) * (p - 1);
        return result;
    }
}