//Question No: 10992
//Title: 별 찍기 - 17
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

            if (i == n) {
                for (int j = 0; j < 2 * i - 1; j++) {
                    output.append("*");
                }
            } else {
                for (int j = 0; j < 2 * i - 1; j++) {
                    if (j == 0 || j == 2 * i - 2) {
                        output.append("*");
                    } else {
                        output.append(" ");
                    }
                }
            }
            output.append("\n");
        }
        System.out.println(output);
    }
}