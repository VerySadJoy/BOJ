//Question No: 27172
//Title: 수 나누기 게임
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder result = new StringBuilder();

        int numPlayers = Integer.parseInt(reader.readLine());
        int maxCardValue = 1000001;
        int[] playerCards = new int[numPlayers];
        boolean[] hasCard = new boolean[maxCardValue];
        int[] scores = new int[maxCardValue];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numPlayers; i++) {
            playerCards[i] = Integer.parseInt(tokenizer.nextToken());
            hasCard[playerCards[i]] = true;
        }

        for (int cardValue : playerCards) {
            for (int multiple = cardValue * 2; multiple < maxCardValue; multiple += cardValue) {
                if (hasCard[multiple]) {
                    scores[cardValue]++;
                    scores[multiple]--;
                }
            }
        }

        for (int cardValue : playerCards) {
            result.append(scores[cardValue]).append(' ');
        }

        System.out.println(result.toString().trim());
    }
}
