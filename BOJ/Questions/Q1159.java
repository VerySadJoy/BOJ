//Question No: 1159
//Title: 농구 경기
//Tier: Bronze II
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] letterCount = new int[26];
        int numberOfPlayers = Integer.parseInt(reader.readLine());
        boolean selectionPossible = false;

        for (int i = 0; i < numberOfPlayers; i++) {
            String playerName = reader.readLine();
            char firstLetter = playerName.charAt(0);
            letterCount[firstLetter - 'a']++;
            if (letterCount[firstLetter - 'a'] == 5) {
                selectionPossible = true;
            }
        }

        if (selectionPossible) {
            for (int i = 0; i < 26; i++) {
                if (letterCount[i] >= 5) {
                    System.out.print((char) (i + 'a'));
                }
            }
        } else {
            System.out.print("PREDAJA");
        }
    }
}