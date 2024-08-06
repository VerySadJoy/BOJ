//Question No: 2941
//Title: 크로아티아 알파벳
//Tier: Silver V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        
        int length = inputString.length();
        int charCount = 0;

        for (int i = 0; i < length; i++) {
            char currentChar = inputString.charAt(i);

            if (currentChar == 'c' && i < length - 1) {
                if (inputString.charAt(i + 1) == '=' || inputString.charAt(i + 1) == '-') {
                    i++;
                }
            } else if (currentChar == 'd' && i < length - 1) {
                if (inputString.charAt(i + 1) == '-') {
                    i++;
                } else if (inputString.charAt(i + 1) == 'z' && i < length - 2) {
                    if (inputString.charAt(i + 2) == '=') {
                        i += 2;
                    }
                }
            } else if ((currentChar == 'l' || currentChar == 'n') && i < length - 1) {
                if (inputString.charAt(i + 1) == 'j') {
                    i++;
                }
            } else if ((currentChar == 's' || currentChar == 'z') && i < length - 1) {
                if (inputString.charAt(i + 1) == '=') {
                    i++;
                }
            }
            charCount++;
        }

        System.out.println(charCount);
    }
}