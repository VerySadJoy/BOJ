//Question No: 2522
//Title: 별 찍기 - 12
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfRows = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= numberOfRows; i++) {
            for (int j = numberOfRows - i; j > 0; j--) {
                output.append(" ");
            }
            for (int j = 1; j <= i; j++) {
                output.append("*");
            }
            output.append("\n");
        }

        for (int i = 1; i <= numberOfRows - 1; i++) {
            for (int j = 1; j <= i; j++) {
                output.append(" ");
            }
            for (int j = 1; j <= numberOfRows - i; j++) {
                output.append("*");
            }
            output.append("\n");
        }

        System.out.print(output);
    }
}