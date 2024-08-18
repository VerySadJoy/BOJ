//Question No: 31907
//Title: GIST 찍기
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

    static int size;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        size = Integer.parseInt(reader.readLine());

        for (int i = 0; i < size; i++) {
            generateFirstPattern();
        }

        for (int i = 0; i < size; i++) {
            generateSecondPattern();
        }

        for (int i = 0; i < size; i++) {
            generateThirdPattern();
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    private static void generateFirstPattern() {
        for (int i = 0; i < size; i++) {
            output.append("G");
        }

        for (int i = 0; i < size; i++) {
            output.append("...");
        }

        output.append("\n");
    }

    private static void generateSecondPattern() {
        for (int i = 0; i < size; i++) {
            output.append(".");
        }

        for (int i = 0; i < size; i++) {
            output.append("I");
        }

        for (int i = 0; i < size; i++) {
            output.append(".");
        }

        for (int i = 0; i < size; i++) {
            output.append("T");
        }

        output.append("\n");
    }

    private static void generateThirdPattern() {
        for (int i = 0; i < size; i++) {
            output.append("..");
        }

        for (int i = 0; i < size; i++) {
            output.append("S");
        }

        for (int i = 0; i < size; i++) {
            output.append(".");
        }

        output.append("\n");
    }
}