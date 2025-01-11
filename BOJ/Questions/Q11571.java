//Question No: 11571
//Title: 분수를 소수로
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        for (int t = 0; t < testCases; t++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int dividend = Integer.parseInt(tokenizer.nextToken());
            int divisor = Integer.parseInt(tokenizer.nextToken());
            int[] remainderIndex = new int[100000];
            Arrays.fill(remainderIndex, -1);

            int start = 0, end = 0, index = 0;
            int temp = dividend;

            while (true) {
                temp = temp % divisor * 10;
                if (remainderIndex[temp] != -1) {
                    start = remainderIndex[temp];
                    end = index;
                    break;
                }
                remainderIndex[temp] = index++;
            }

            result.append(dividend / divisor).append(".");
            temp = dividend % divisor * 10;
            for (int i = 0; i < start; i++) {
                result.append(temp / divisor);
                temp = temp % divisor * 10;
            }

            result.append("(");
            for (int i = start; i < end; i++) {
                result.append(temp / divisor);
                temp = temp % divisor * 10;
            }
            result.append(")").append("\n");
        }

        System.out.println(result.toString());
    }
}