//Question No: 27433
//Title: 팩토리얼 2
//Tier: Bronze V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int number = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(calculateFactorial(number));
    }

    static long calculateFactorial(int number) {
        if (number <= 0) {
            return 1;
        }
        return number * calculateFactorial(number - 1);
    }
}