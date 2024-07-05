//Question No: 20310
//Title: 타노스
//Tier: Silver III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine().trim();
        List<Character> characters = new ArrayList<>();

        for (char ch : input.toCharArray()) {
            characters.add(ch);
        }

        int countZero = Collections.frequency(characters, '0');
        int countOne = Collections.frequency(characters, '1');

        int removedOnes = 0;
        for (int i = 0; i < characters.size(); i++) {
            if (removedOnes == countOne / 2) {
                break;
            }
            if (characters.get(i) == '1') {
                characters.remove(i);
                i--;
                removedOnes++;
            }
        }

        Collections.reverse(characters);

        int removedZeros = 0;
        for (int i = 0; i < characters.size(); i++) {
            if (removedZeros == countZero / 2) {
                break;
            }
            if (characters.get(i) == '0') {
                characters.remove(i);
                i--;
                removedZeros++;
            }
        }

        Collections.reverse(characters);

        for (char ch : characters) {
            System.out.print(ch);
        }
    }
}
