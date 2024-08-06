//Question No: 16496
//Title: 큰 수 만들기
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numCount = Integer.parseInt(reader.readLine().trim());

        String[] numbers = new String[numCount];
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < numCount; i++) {
            numbers[i] = tokenizer.nextToken();
        }

        Arrays.sort(numbers, (String n1, String n2) -> (n2 + n1).compareTo(n1 + n2));

        StringBuilder result = new StringBuilder();
        for (String number : numbers) {
            result.append(number);
        }

        boolean hasNonZero = false;
        for (int i = 0; i < result.length(); i++) {
            if (result.charAt(i) != '0') {
                hasNonZero = true;
                break;
            }
        }

        if (hasNonZero) {
            System.out.println(result.toString());
        } else {
            System.out.println("0");
        }
    }
}