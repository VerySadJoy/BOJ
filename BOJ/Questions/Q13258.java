//Question No: 13258
//Title: 복권 + 은행
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        StringTokenizer tokens = new StringTokenizer(reader.readLine());

        int initialValue = Integer.parseInt(tokens.nextToken());
        int totalSum = initialValue;

        for (int i = 1; i < N; i++) {
            totalSum += Integer.parseInt(tokens.nextToken());
        }

        double J = Integer.parseInt(reader.readLine());
        double C = Integer.parseInt(reader.readLine());

        double result = initialValue + (initialValue * J * C) / totalSum;
        System.out.printf("%.10f", result);
        
        reader.close();
    }
}