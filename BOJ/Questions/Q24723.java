//Question No: 24723
//Title: 녹색거탑
//Tier: Bronze IV
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int exponent = Integer.parseInt(reader.readLine());

        System.out.print((int) Math.pow(2, exponent));
    }
}