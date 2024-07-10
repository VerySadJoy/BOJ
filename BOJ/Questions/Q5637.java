//Question No: 5637
//Title: 가장 긴 단어
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int maxLength = -1;
        String longestWord = null;
        
        while (true) {
            String input = br.readLine();
            String[] words = input.toLowerCase().split("[^a-z-]");
            
            for (String word : words) {
                if (word.equals("e-n-d")) {
                    System.out.println(longestWord.toLowerCase());
                    return;
                }
                if (maxLength < word.length()) {
                    maxLength = word.length();
                    longestWord = word;
                }
            }
        }
    }
}
