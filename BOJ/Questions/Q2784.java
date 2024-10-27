//Question No: 2784
//Title: 가로 세로 퍼즐
//Tier: Silver II
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] words = new String[6];
        boolean[] visited = new boolean[6];
        boolean[] checkedWords = new boolean[3];
        int matchCount;
        String[] selectedWords = new String[3];
        String[] transformedWords = new String[3];

        for (int i = 0; i < 6; i++) {
            words[i] = scanner.next();
        }
        Arrays.sort(words);

        for (int i = 0; i < 6; i++) {
            visited[i] = true;
            selectedWords[0] = words[i];
            for (int j = 0; j < 6; j++) {
                if (visited[j]) continue;
                selectedWords[1] = words[j];
                visited[j] = true;
                for (int k = 0; k < 6; k++) {
                    if (visited[k]) continue;
                    visited[k] = true;
                    selectedWords[2] = words[k];

                    transformedWords[0] = "";
                    transformedWords[1] = "";
                    transformedWords[2] = "";

                    transformedWords[0] += selectedWords[0].charAt(0);
                    transformedWords[0] += selectedWords[1].charAt(0);
                    transformedWords[0] += selectedWords[2].charAt(0);

                    transformedWords[1] += selectedWords[0].charAt(1);
                    transformedWords[1] += selectedWords[1].charAt(1);
                    transformedWords[1] += selectedWords[2].charAt(1);

                    transformedWords[2] += selectedWords[0].charAt(2);
                    transformedWords[2] += selectedWords[1].charAt(2);
                    transformedWords[2] += selectedWords[2].charAt(2);

                    Arrays.sort(transformedWords);

                    matchCount = 0;
                    Arrays.fill(checkedWords, false);

                    for (int l = 0; l < 6; l++) {
                        if (visited[l]) continue;
                        for (int m = 0; m < 3; m++) {
                            if (checkedWords[m]) continue;
                            if (words[l].equals(transformedWords[m])) {
                                checkedWords[m] = true;
                                matchCount++;
                                break;
                            }
                        }
                    }

                    if (matchCount == 3) {
                        System.out.printf("%s%n%s%n%s%n", selectedWords[0], selectedWords[1], selectedWords[2]);
                        return;
                    }
                    visited[k] = false;
                }
                visited[j] = false;
            }
            visited[i] = false;
        }
        System.out.println("0");
    }
}