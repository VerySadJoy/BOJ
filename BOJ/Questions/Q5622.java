//Question No: 5622
//Title: 다이얼
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputString = reader.readLine();
        int totalDuration = 0;
        int stringLength = inputString.length();

        for (int i = 0; i < stringLength; i++) {
            char character = inputString.charAt(i);
            switch (character) {
                case 'A': case 'B': case 'C':
                    totalDuration += 3;
                    break;
                case 'D': case 'E': case 'F':
                    totalDuration += 4;
                    break;
                case 'G': case 'H': case 'I':
                    totalDuration += 5;
                    break;
                case 'J': case 'K': case 'L':
                    totalDuration += 6;
                    break;
                case 'M': case 'N': case 'O':
                    totalDuration += 7;
                    break;
                case 'P': case 'Q': case 'R': case 'S':
                    totalDuration += 8;
                    break;
                case 'T': case 'U': case 'V':
                    totalDuration += 9;
                    break;
                case 'W': case 'X': case 'Y': case 'Z':
                    totalDuration += 10;
                    break;
            }
        }
        System.out.print(totalDuration);
    }
}
