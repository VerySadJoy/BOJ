//Question No: 23759
//Title: 비슷한 문자열
//Tier: Gold II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[][][] sequenceLength = new int[500001][11][26];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int totalStrings = Integer.parseInt(tokenizer.nextToken());
        int charCount = Integer.parseInt(tokenizer.nextToken());

        int maxSequence = 0;

        for (int i = 0; i < totalStrings; i++) {
            String currentString = reader.readLine();
            int currentMax = 1;

            for (int j = 0; j < charCount; j++) {
                int charIndex = currentString.charAt(j) - 'a';

                if (i == 0) {
                    sequenceLength[i][j][charIndex] = 1;
                } else {
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        int index = ch - 'a';

                        if (ch == currentString.charAt(j)) {
                            currentMax = Math.max(currentMax, sequenceLength[i - 1][j][index] + 1);
                        } else {
                            sequenceLength[i][j][index] = sequenceLength[i - 1][j][index];
                        }
                    }
                }
            }

            maxSequence = Math.max(maxSequence, currentMax);

            for (int j = 0; j < charCount; j++) {
                int charIndex = currentString.charAt(j) - 'a';
                sequenceLength[i][j][charIndex] = currentMax;
            }
        }

        System.out.println(totalStrings - maxSequence);
    }
}