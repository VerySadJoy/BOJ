//Question No: 9506
//Title: 약수들의 합
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            int number = Integer.parseInt(reader.readLine());
            if (number == -1) break;

            StringBuilder output = new StringBuilder(number + " = 1");
            int divisorSum = 1;

            for (int i = 2; i < number; i++) {
                if (number % i == 0) {
                    output.append(" + ").append(i);
                    divisorSum += i;
                }
            }

            if (number == divisorSum) {
                System.out.println(output);
            } else {
                System.out.println(number + " is NOT perfect.");
            }
        }
        reader.close();
    }
}