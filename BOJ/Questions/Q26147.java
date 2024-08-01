//Question No: 26147
//Title: Wordle 찍기
//Tier: Gold IV
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    
    public static String shiftChars(String correctWord, String real, List<Integer> indices) {
        char[] correctWordArray = correctWord.toCharArray();
        char[] temp = correctWordArray.clone();

        if (indices.size() > 1) {
            for (int i = 0; i < indices.size(); i++) {
                temp[indices.get(i)] = correctWordArray[indices.get((i - 1 + indices.size()) % indices.size())];
            }
        } else if (indices.size() == 1) {
            for (int i = 0; i < 5; i++) {
                if (correctWordArray[i] == 'F') {
                    temp[indices.get(0)] = real.charAt(i);
                }
            }
        }

        return new String(temp);
    }

    public static void solveWordle(int N, List<String> results) {
        if (!checkConstraints(results)) {
            System.out.println("IMPOSSIBLE");
            return;
        }

        String correctWord = "ABCDE";
        List<String> guesses = generateGuesses(correctWord, results);

        System.out.println(correctWord);
        for (String guess : guesses) {
            System.out.println(guess);
        }
    }

    public static boolean checkConstraints(List<String> results) {
        for (String result : results) {
            if (result.chars().filter(ch -> ch == 'G').count() == 4) {
                if (result.chars().filter(ch -> ch == 'B').count() != 1) {
                    return false;
                }
            }
        }
        return true;
    }

    public static List<String> generateGuesses(String correctWord, List<String> results) {
        List<String> guesses = new ArrayList<>();
        for (String result : results) {
            char[] guessArray = correctWord.toCharArray();
            List<Integer> usedWord = new ArrayList<>();
            for (int i = 0; i < result.length(); i++) {
                char color = result.charAt(i);
                if (color == 'B') {
                    guessArray[i] = 'F';
                } else if (color == 'Y') {
                    usedWord.add(i);
                }
            }
            String guess = shiftChars(new String(guessArray), correctWord, usedWord);
            guesses.add(guess);
        }
        return guesses;
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            int N = Integer.parseInt(scanner.nextLine().trim());
            List<String> results = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                results.add(scanner.nextLine().trim());
            }
            solveWordle(N, results);
        }
    }
}
