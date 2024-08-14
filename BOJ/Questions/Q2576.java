//Question No: 2576
//Title: 홀수
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sumOddNumbers = 0;
        int smallestOddNumber = 100;

        for (int i = 0; i < 7; i++) {
            int number = Integer.parseInt(reader.readLine());

            if (number % 2 == 1) {
                sumOddNumbers += number;
                smallestOddNumber = Math.min(smallestOddNumber, number);
            }
        }

        if (sumOddNumbers == 0) {
            System.out.println(-1);
        } else {
            System.out.println(sumOddNumbers);
            System.out.println(smallestOddNumber);
        }
    }
}