//Question No: 10991
//Title: 별 찍기 - 16
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= n; i++) {
            for (int j = n; j > i; j--) {
                output.append(" ");
            }
            for (int j = 0; j < 2 * i - 1; j++) {
                if (j % 2 == 0) {
                    output.append("*");
                } else {
                    output.append(" ");
                }
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}