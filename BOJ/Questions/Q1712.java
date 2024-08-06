//Question No: 1712
//Title: 손익분기점
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int fixedCost = Integer.parseInt(tokenizer.nextToken());
        int variableCost = Integer.parseInt(tokenizer.nextToken());
        int price = Integer.parseInt(tokenizer.nextToken());

        if (price <= variableCost) {
            System.out.println("-1");
        } else {
            System.out.println((fixedCost / (price - variableCost)) + 1);
        }
    }
}