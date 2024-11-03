//Question No: 10798
//Title: 세로읽기
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        char[][] characters = new char[5][15];
        int maxLength = 0;

        for (char[] character : characters) {
            String input = reader.readLine();
            if (maxLength < input.length()) {
                maxLength = input.length();
            }
            for (int col = 0; col < input.length(); col++) {
                character[col] = input.charAt(col);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int col = 0; col < maxLength; col++) {
            for (int row = 0; row < 5; row++) {
                if (characters[row][col] == '\0') {
                    continue;
                }
                result.append(characters[row][col]);
            }
        }
        System.out.println(result);
    }
}