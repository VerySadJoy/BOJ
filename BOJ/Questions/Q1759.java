//Question No: 1759
//Title: 암호 만들기
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {

    public static int codeLength, totalChars;
    public static char[] availableChars;
    public static char[] currentCode;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        codeLength = Integer.parseInt(tokenizer.nextToken());
        totalChars = Integer.parseInt(tokenizer.nextToken());

        availableChars = new char[totalChars];
        currentCode = new char[codeLength];

        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < totalChars; i++) {
            availableChars[i] = tokenizer.nextToken().charAt(0);
        }

        Arrays.sort(availableChars);

        generateCode(0, 0);
    }

    public static void generateCode(int startIndex, int currentLength) {
        if (currentLength == codeLength) {
            if (isValidCode()) {
                System.out.println(currentCode);
            }
            return;
        }

        for (int i = startIndex; i < totalChars; i++) {
            currentCode[currentLength] = availableChars[i];
            generateCode(i + 1, currentLength + 1);
        }
    }

    public static boolean isValidCode() {
        int vowelCount = 0;
        int consonantCount = 0;

        for (char ch : currentCode) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowelCount++;
            } else {
                consonantCount++;
            }
        }

        return vowelCount >= 1 && consonantCount >= 2;
    }
}