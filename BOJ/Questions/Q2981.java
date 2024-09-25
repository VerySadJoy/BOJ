//Question No: 2981
//Title: 검문
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        int totalNumbers = Integer.parseInt(inputReader.readLine());
        int[] numbers = new int[totalNumbers];

        for (int i = 0; i < totalNumbers; i++) {
            numbers[i] = Integer.parseInt(inputReader.readLine());
        }

        Arrays.sort(numbers);

        int gcdValue = numbers[1] - numbers[0];

        for (int i = 2; i < totalNumbers; i++) {
            gcdValue = calculateGCD(gcdValue, numbers[i] - numbers[i - 1]);
        }

        for (int i = 2; i <= gcdValue; i++) {
            if (gcdValue % i == 0) {
                System.out.print(i + " ");
            }
        }
    }

    static int calculateGCD(int a, int b) {
        while (b != 0) {
            int remainder = a % b;
            a = b;
            b = remainder;
        }
        return a;
    }
}