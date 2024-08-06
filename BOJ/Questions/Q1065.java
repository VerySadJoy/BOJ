//Question No: 1065
//Title: 한수
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(reader.readLine());
        System.out.print(countArithmeticSequences(inputNumber));
    }

    public static int countArithmeticSequences(int number) {
        int count = 0;

        if (number < 100) {
            return number;
        } else {
            count = 99;
            for (int i = 100; i <= number; i++) {
                int hundreds = i / 100;
                int tens = (i / 10) % 10;
                int units = i % 10;

                if ((hundreds - tens) == (tens - units)) {
                    count++;
                }
            }
        }

        return count;
    }
}