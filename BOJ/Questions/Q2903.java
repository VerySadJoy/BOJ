//Question No: 2903
//Title: 중앙 이동 알고리즘
//Tier: Bronze III
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int exponent = Integer.parseInt(reader.readLine());
        reader.close();

        int result = (int) Math.pow(Math.pow(2, exponent) + 1, 2);
        System.out.println(result);
    }
}