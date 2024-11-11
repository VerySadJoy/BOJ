//Question No: 2501
//Title: 약수 구하기
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        
        int number = Integer.parseInt(tokenizer.nextToken());
        int divisorPosition = Integer.parseInt(tokenizer.nextToken());
        
        int divisorCount = 0;
        int kthDivisor = 0;

        for (int i = 1; i <= number; i++) {
            if (number % i == 0) {
                divisorCount++;
            }
            if (divisorCount == divisorPosition) {
                kthDivisor = i;
                break;
            }
        }
        
        System.out.println(kthDivisor);
    }
}