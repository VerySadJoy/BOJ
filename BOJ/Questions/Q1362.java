//Question No: 1362
//Title: 펫
//Tier: Bronze II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        int scenarioNumber = 1;

        while (true) {
            StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
            int initialWeight = Integer.parseInt(tokenizer.nextToken());
            int currentWeight = Integer.parseInt(tokenizer.nextToken());

            if (initialWeight == 0 && currentWeight == 0) break;

            boolean isDead = false;

            while (true) {
                tokenizer = new StringTokenizer(inputReader.readLine());
                String event = tokenizer.nextToken();
                int change = Integer.parseInt(tokenizer.nextToken());

                if (event.equals("#") && change == 0) break;

                if (event.equals("E")) currentWeight -= change;
                if (event.equals("F")) currentWeight += change;

                if (currentWeight <= 0) {
                    isDead = true;
                }
            }

            if (isDead) {
                System.out.println(scenarioNumber + " RIP");
            } else {
                if ((initialWeight / 2) < currentWeight && currentWeight < (initialWeight * 2)) {
                    System.out.println(scenarioNumber + " :-)");
                } else {
                    System.out.println(scenarioNumber + " :-(");
                }
            }

            scenarioNumber++;
        }
    }
}