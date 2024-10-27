//Question No: 15728
//Title: 에리 - 카드
//Tier: Silver III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static int numberOfPlayers, numberToRemove;
    static ArrayList<Integer> shares, team;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        numberOfPlayers = Integer.parseInt(tokenizer.nextToken());
        numberToRemove = Integer.parseInt(tokenizer.nextToken());

        shares = new ArrayList<>();
        team = new ArrayList<>();

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfPlayers; i++) {
            shares.add(Integer.parseInt(tokenizer.nextToken()));
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfPlayers; i++) {
            team.add(Integer.parseInt(tokenizer.nextToken()));
        }

        for (int i = 0; i < numberToRemove; i++) {
            int maxProduct = Integer.MIN_VALUE;
            int indexToRemove = -1;
            for (int j = 0; j < numberOfPlayers; j++) {
                for (int k = 0; k < team.size(); k++) {
                    int product = shares.get(j) * team.get(k);
                    if (product > maxProduct) {
                        maxProduct = product;
                        indexToRemove = k;
                    }
                }
            }
            team.remove(indexToRemove);
        }

        int maxResult = shares.get(0) * team.get(0);
        for (int i = 1; i < numberOfPlayers; i++) {
            for (int j = 0; j < team.size(); j++) {
                maxResult = Math.max(maxResult, shares.get(i) * team.get(j));
            }
        }

        System.out.println(maxResult);
    }
}