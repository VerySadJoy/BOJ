//Question No: 23306
//Title: binary는 호남선
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out);

        int n = Integer.parseInt(reader.readLine().trim());

        writer.println("? 1");
        writer.flush();
        int a = Integer.parseInt(reader.readLine().trim());

        writer.println("? " + n);
        writer.flush();
        int b = Integer.parseInt(reader.readLine().trim());

        if (a == 1 && b == 0) {
            writer.println("! -1");
        } else if (a == 0 && b == 1) {
            writer.println("! 1");
        } else {
            writer.println("! 0");
        }

        writer.flush();
    }
}