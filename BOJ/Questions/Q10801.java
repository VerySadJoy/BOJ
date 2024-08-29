//Question No: 10801
//Title: 카드게임
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int[] aScores = new int[10];
        int[] bScores = new int[10];

        for (int i = 0; i < 10; i++) {
            aScores[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < 10; i++) {
            bScores[i] = Integer.parseInt(tokenizer.nextToken());
        }

        int aWins = 0, bWins = 0;

        for (int i = 0; i < 10; i++) {
            if (aScores[i] > bScores[i]) {
                aWins++;
            } else if (aScores[i] < bScores[i]) {
                bWins++;
            }
        }

        if (aWins == bWins) {
            System.out.println("D");
        } else if (aWins > bWins) {
            System.out.println("A");
        } else {
            System.out.println("B");
        }
    }
}