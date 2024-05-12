//Question No: 1644
//Title: 소수의 연속합
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isPrime = new boolean[N + 1];
        List<Integer> primeList = new ArrayList<>();
        for (int i = 2; i <= N; i++) {
            isPrime[i] = true;
        }
        for (int i = 2; i * i <= N; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= N; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= N; i++) {
            if (isPrime[i]) {
                primeList.add(i);
            }
        }
        int answer = 0;
        int start = 0, end = 0;
        int sum = 0;
        while (true) {
            if (sum >= N) {
                if (sum == N) {
                    answer++;
                }
                sum -= primeList.get(start++);
            } else if (end == primeList.size()) {
                break;
            } else {
                sum += primeList.get(end++);
            }
        }
        System.out.println(answer);
    }
}
