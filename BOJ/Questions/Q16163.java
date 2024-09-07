//Question No: 16163
//Title: #15164번_제보
//Tier: Platinum V
import java.io.*;
import java.util.Arrays;

import static java.lang.Math.min;

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        String input = reader.readLine();
        StringBuilder formattedString = new StringBuilder();
        
        for (int i = 0; i < input.length(); i++) {
            formattedString.append("#");
            formattedString.append(input.charAt(i));
        }
        formattedString.append("#");
        
        long[] palindromeRadii = new long[formattedString.length()];
        long right = -1, center = -1;

        for (int i = 0; i < formattedString.length(); i++) {
            if (i <= right) {
                palindromeRadii[i] = min(right - i, palindromeRadii[(int) (center + (center - i))]);
            }

            while (i + palindromeRadii[i] + 1 < formattedString.length() 
                   && i - palindromeRadii[i] - 1 >= 0 
                   && formattedString.charAt((int) (i + palindromeRadii[i] + 1)) == formattedString.charAt((int) (i - palindromeRadii[i] - 1))) {
                ++palindromeRadii[i];
            }

            if (i + palindromeRadii[i] > right) {
                center = i;
                right = i + palindromeRadii[i];
            }
        }

        long result = Arrays.stream(palindromeRadii).map(i -> (i + 1) / 2).sum();
        writer.write(result + "\n");
        writer.flush();
    }
}