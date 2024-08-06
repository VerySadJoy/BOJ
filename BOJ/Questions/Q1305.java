//Question No: 1305
//Title: 광고
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int patternLength = Integer.parseInt(reader.readLine().trim());
        String text = reader.readLine().trim();
        String pattern = text;
        
        int[] kmpTable = new int[patternLength + 1];
        int j = 0;
        for (int i = 1; i < patternLength; i++) {
            while (j > 0 && pattern.charAt(j) != text.charAt(i)) {
                j = kmpTable[j - 1];
            }
            if (pattern.charAt(j) == text.charAt(i)) {
                kmpTable[i] = ++j;
            }
        }
        
        System.out.println(patternLength - kmpTable[patternLength - 1]);
    }
}