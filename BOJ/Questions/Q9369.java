//Question No: 9369
//Title: 암호 깨기
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine().trim());

        while (testCases-- > 0) {
            int[][] charMapping = new int[100][150];
            int[][] reverseMapping = new int[100][150];
            List<String> words = new ArrayList<>();
            List<Integer> validIndices = new ArrayList<>();

            int wordCount = Integer.parseInt(reader.readLine().trim());

            for (int i = 0; i < wordCount; i++) {
                words.add(reader.readLine().trim());
            }

            String correctWord = reader.readLine().trim();
            String targetWord = reader.readLine().trim();

            for (int i = 0; i < wordCount; i++) {
                int[] currentMapping = new int[150];
                int[] currentReverseMapping = new int[150];
                Arrays.fill(currentMapping, 0);
                Arrays.fill(currentReverseMapping, 0);
                boolean isValid = true;
                int matchCount = 0;

                if (words.get(i).length() != correctWord.length()) {
                    isValid = false;
                } else {
                    for (int j = 0; j < correctWord.length(); j++) {
                        int wordChar = words.get(i).charAt(j);
                        int correctChar = correctWord.charAt(j);

                        if (currentMapping[wordChar] == 0 && currentReverseMapping[correctChar] == 0) {
                            currentMapping[wordChar] = correctChar;
                            currentReverseMapping[correctChar] = wordChar;
                            matchCount++;
                        } else if (currentMapping[wordChar] != correctChar || currentReverseMapping[correctChar] != wordChar) {
                            isValid = false;
                            break;
                        }
                    }
                }

                if (isValid) {
                    validIndices.add(i);

                    if (matchCount == 25) {
                        int missingChar = 0, missingCorrectChar = 0;
                        for (int j = 'a'; j <= 'z'; j++) {
                            if (currentMapping[j] == 0) {
                                missingChar = j;
                            }
                            if (currentReverseMapping[j] == 0) {
                                missingCorrectChar = j;
                            }
                        }
                        currentMapping[missingChar] = missingCorrectChar;
                        currentReverseMapping[missingCorrectChar] = missingChar;
                    }
                    charMapping[i] = currentMapping;
                    reverseMapping[i] = currentReverseMapping;
                }
            }

            if (validIndices.size() == 0) {
                System.out.println("IMPOSSIBLE");
            } else {
                if (validIndices.size() == 1) {
                    int idx = validIndices.get(0);
                    StringBuilder result = new StringBuilder();

                    for (int i = 0; i < targetWord.length(); i++) {
                        char targetChar = targetWord.charAt(i);
                        if (charMapping[idx][targetChar] == 0) {
                            result.append('?');
                        } else {
                            result.append((char) charMapping[idx][targetChar]);
                        }
                    }
                    System.out.println(result);
                } else {
                    StringBuilder result = new StringBuilder();

                    for (int i = 0; i < targetWord.length(); i++) {
                        char targetChar = targetWord.charAt(i);
                        boolean isConsistent = true;
                        int firstIdx = validIndices.get(0);
                        int mappedChar = charMapping[firstIdx][targetChar];

                        if (mappedChar == 0) {
                            result.append('?');
                        } else {
                            for (int j = 1; j < validIndices.size(); j++) {
                                int idx = validIndices.get(j);
                                if (charMapping[idx][targetChar] != mappedChar) {
                                    isConsistent = false;
                                    break;
                                }
                            }
                            if (isConsistent) {
                                result.append((char) mappedChar);
                            } else {
                                result.append('?');
                            }
                        }
                    }
                    System.out.println(result);
                }
            }
        }
    }
}