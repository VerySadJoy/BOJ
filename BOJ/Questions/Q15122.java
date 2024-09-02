//Question No: 15122
//Title: Forbidden Zero
//Tier: Bronze II
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int number = readNumber() + 1;
        while (containsZero(number)) number++;

        writer.write(String.valueOf(number));
        writer.flush();
    }

    private static boolean containsZero(int number) {
        while (number > 0) {
            if (number % 10 == 0) return true;
            number /= 10;
        }
        return false;
    }

    private static int readNumber() throws IOException {
        int character, number = System.in.read() & 15;
        while ((character = System.in.read()) > 32) {
            number = (number << 3) + (number << 1) + (character & 15);
        }
        return number;
    }
}