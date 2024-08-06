//Question No: 1427
//Title: 소트인사이드
//Tier: Silver V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] digitCount = new int[10];
        String input = reader.readLine();

        for (int i = 0; i < input.length(); i++) {
            digitCount[input.charAt(i) - '0']++;
        }

        for (int i = 9; i >= 0; i--) {
            while (digitCount[i]-- > 0) {
                System.out.print(i);
            }
        }
    }
}