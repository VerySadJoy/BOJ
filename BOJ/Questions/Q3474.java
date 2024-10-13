//Question No: 3474
//Title: 교수가 된 현우
//Tier: Silver III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCases; i++) {
            int number = Integer.parseInt(reader.readLine());

            int countTwos = 0;
            int countFives = 0;

            for (int j = 2; j <= number; j *= 2) {
                countTwos += number / j;
            }
            for (int j = 5; j <= number; j *= 5) {
                countFives += number / j;
            }

            System.out.println(Math.min(countTwos, countFives));
        }
    }
}