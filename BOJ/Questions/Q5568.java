//Question No: 5568
//Title: 카드 놓기
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfCards = Integer.parseInt(bufferedReader.readLine());
        int combinationLength = Integer.parseInt(bufferedReader.readLine());
        String[] cards = new String[numberOfCards];
        for (int i = 0; i < numberOfCards; i++) {
            cards[i] = bufferedReader.readLine().trim();
        }
        
        Set<String> uniqueCombinations = new HashSet<>();
        generatePermutations(cards, "", combinationLength, uniqueCombinations);
        
        System.out.println(uniqueCombinations.size());
    }

    public static void generatePermutations(String[] cards, String currentCombination, int length, Set<String> uniqueCombinations) {
        if (length == 0) {
            uniqueCombinations.add(currentCombination);
            return;
        }
        for (int i = 0; i < cards.length; i++) {
            String[] remainingCards = new String[cards.length - 1];
            System.arraycopy(cards, 0, remainingCards, 0, i);
            System.arraycopy(cards, i + 1, remainingCards, i, cards.length - i - 1);
            generatePermutations(remainingCards, currentCombination + cards[i], length - 1, uniqueCombinations);
        }
    }
}