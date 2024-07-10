//Question No: 24500
//Title: blobblush
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        solve(reader);
    }

    private static void solve(BufferedReader reader) throws IOException {
        long number = Long.parseLong(reader.readLine());
        long maxPowerOfTwoMinusOne = 1;

        while (maxPowerOfTwoMinusOne < number) {
            maxPowerOfTwoMinusOne = maxPowerOfTwoMinusOne * 2 + 1;
        }

        if (maxPowerOfTwoMinusOne == number) {
            System.out.println(1);
            System.out.println(number);
        } else {
            System.out.println(2);
            System.out.println(maxPowerOfTwoMinusOne ^ number);
            System.out.println(number);
        }
    }
}
