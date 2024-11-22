//Question No: 4134
//Title: 다음 소수
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder resultBuilder = new StringBuilder();

        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            long number = Long.parseLong(reader.readLine());

            if (number <= 1) {
                resultBuilder.append(2).append("\n");
                continue;
            }

            while (true) {
                if (isPrime(number)) {
                    resultBuilder.append(number).append("\n");
                    break;
                }
                number++;
            }
        }

        System.out.print(resultBuilder);
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
        for (long i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}