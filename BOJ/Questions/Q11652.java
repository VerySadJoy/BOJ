//Question No: 11652
//Title: 카드
//Tier: Silver IV
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine());

        HashMap<Long, Integer> cardCounts = new HashMap<>();

        int maxCount = 0;
        long minCard = 0;

        for (int i = 0; i < N; i++) {
            long card = Long.parseLong(reader.readLine());
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);

            if (cardCounts.get(card) > maxCount) {
                maxCount = cardCounts.get(card);
                minCard = card;
            } else if (cardCounts.get(card) == maxCount) {
                minCard = Math.min(minCard, card);
            }
        }
        System.out.println(minCard);
    }
}