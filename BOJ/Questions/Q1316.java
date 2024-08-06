//Question No: 1316
//Title: 그룹 단어 체커
//Tier: Silver V
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {

        int validWordCount = 0;
        int numberOfWords = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfWords; i++) {
            if (isGroupWord()) {
                validWordCount++;
            }
        }
        System.out.println(validWordCount);
    }

    public static boolean isGroupWord() throws IOException {
        boolean[] alphabetSeen = new boolean[26];
        int previousChar = 0;
        String word = reader.readLine();
        
        for (int i = 0; i < word.length(); i++) {
            int currentChar = word.charAt(i);
            
            if (previousChar != currentChar) {
                if (!alphabetSeen[currentChar - 'a']) {
                    alphabetSeen[currentChar - 'a'] = true;
                    previousChar = currentChar;
                }
                else {
                    return false;
                }
            }
        }
        return true;
    }
}