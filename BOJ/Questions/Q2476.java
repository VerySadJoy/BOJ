//Question No: 2476
//Title: 주사위 게임
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int numberOfParticipants = Integer.parseInt(reader.readLine());
        int maximumPrize = 0;

        for (int i = 0; i < numberOfParticipants; i++) {
            int currentPrize = 0;
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int die1 = Integer.parseInt(tokenizer.nextToken());
            int die2 = Integer.parseInt(tokenizer.nextToken());
            int die3 = Integer.parseInt(tokenizer.nextToken());

            if (die1 == die2 && die2 == die3) {
                currentPrize = 10000 + die1 * 1000;
            } else if (die1 != die2 && die2 != die3 && die1 != die3) {
                currentPrize = Math.max(die1, Math.max(die2, die3)) * 100;
            } else {
                if (die1 == die2 || die1 == die3) {
                    currentPrize = 1000 + die1 * 100;
                } else {
                    currentPrize = 1000 + die2 * 100;
                }
            }

            maximumPrize = Math.max(maximumPrize, currentPrize);
        }
        System.out.println(maximumPrize);
    }
}