//Question No: 9229
//Title: 단어 사다리
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    public static boolean isAble(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }

        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
        }
        return count == 1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String before, now;

        while (true) {
            before = reader.readLine();
            if (before.equals("#")) break;
            
            boolean isCorrect = true;

            while (true) {
                now = reader.readLine();
                if (now.equals("#")) break;
                if (!isAble(before, now)) {
                    isCorrect = false;
                }
                before = now;
            }

            if (isCorrect) {
                System.out.println("Correct");
            } else {
                System.out.println("Incorrect");
            }
        }
    }
}
