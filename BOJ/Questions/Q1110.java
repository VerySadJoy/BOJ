//Question No: 1110
//Title: 더하기 사이클
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int initialNumber = Integer.parseInt(reader.readLine());
        int cycleCount = 0;
        int currentNumber = initialNumber;

        if (initialNumber < 10) {
            initialNumber *= 10;
        }

        currentNumber = initialNumber;

        while (true) {
            int sum = (currentNumber % 10) + (currentNumber / 10);
            currentNumber = (currentNumber % 10) * 10 + (sum % 10);
            cycleCount++;

            if (currentNumber == initialNumber) {
                break;
            }
        }

        System.out.println(cycleCount);
    }
}