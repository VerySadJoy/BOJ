//Question No: 28135
//Title: Since 1973
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int upperLimit = Integer.parseInt(reader.readLine().trim());
        int count = 0;

        for (int i = 0; i < upperLimit; i++) {
            count++;
            if (String.valueOf(i).contains("50")) {
                count++;
            }
        }

        System.out.println(count);
    }
}