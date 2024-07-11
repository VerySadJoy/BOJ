//Question No: 1786
//Title: 찾기
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final List<Integer> matchPositions = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String text = reader.readLine();
        String pattern = reader.readLine();
        int matchCount = KMP(text, pattern);

        writer.write(matchCount + "\n");
        for (int position : matchPositions) {
            writer.write(position + "\n");
        }
        writer.flush();
        writer.close();
    }

    private static int[] createPartialMatchTable(String pattern) {
        int patternLength = pattern.length();
        int[] table = new int[patternLength];
        int j = 0;

        for (int i = 1; i < patternLength; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = table[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                table[i] = ++j;
            }
        }
        return table;
    }

    private static int KMP(String text, String pattern) {
        int[] partialMatchTable = createPartialMatchTable(pattern);
        int textLength = text.length();
        int patternLength = pattern.length();
        int j = 0;
        int matchCount = 0;

        for (int i = 0; i < textLength; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = partialMatchTable[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == patternLength - 1) {
                    matchPositions.add(i - patternLength + 2);
                    j = partialMatchTable[j];
                    matchCount++;
                } else {
                    j++;
                }
            }
        }
        return matchCount;
    }
}
