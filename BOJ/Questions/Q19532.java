//Question No: 19532
//Title: 수학은 비대면강의입니다
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");

        int coeffA1 = Integer.parseInt(input[0]);
        int coeffB1 = Integer.parseInt(input[1]);
        int constC1 = Integer.parseInt(input[2]);
        int coeffA2 = Integer.parseInt(input[3]);
        int coeffB2 = Integer.parseInt(input[4]);
        int constC2 = Integer.parseInt(input[5]);

        int resultX = 0, resultY = 0;

        for (int x = -999; x <= 999; x++) {
            for (int y = -999; y <= 999; y++) {
                if (coeffA1 * x + coeffB1 * y == constC1 && coeffA2 * x + coeffB2 * y == constC2) {
                    resultX = x;
                    resultY = y;
                    break;
                }
            }
        }

        System.out.println(resultX + " " + resultY);
    }
}