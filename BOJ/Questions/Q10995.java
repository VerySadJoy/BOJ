//Question No: 10995
//Title: 별 찍기 - 20
//Tier: Bronze III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int lines = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int i = 1; i <= lines; i++) {
            for (int j = 1; j <= 2 * lines; j++) {
                if (i % 2 == 1) {
                    if (j % 2 == 1) {
                        output.append("*");
                    } else {
                        output.append(" ");
                    }
                } else {
                    if (j % 2 == 1) {
                        output.append(" ");
                    } else {
                        output.append("*");
                    }
                }
            }
            output.append("\n");
        }
        System.out.print(output);
    }
}