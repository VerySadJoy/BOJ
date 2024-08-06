//Question No: 10870
//Title: 피보나치 수 5
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        System.out.println(calculateFibonacci(number));
    }

    static int calculateFibonacci(int number) {
        if (number == 0) return 0;
        if (number == 1) return 1;
        return calculateFibonacci(number - 1) + calculateFibonacci(number - 2);
    }
}