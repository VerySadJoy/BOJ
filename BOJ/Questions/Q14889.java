//Question No: 14889
//Title: 스타트와 링크
//Tier: Silver I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    static int numberOfPlayers;
    static int[][] abilities;
    static boolean[] selected;
    static int minimumDifference = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numberOfPlayers = Integer.parseInt(reader.readLine());
        abilities = new int[numberOfPlayers][numberOfPlayers];
        selected = new boolean[numberOfPlayers];

        for (int i = 0; i < numberOfPlayers; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < numberOfPlayers; j++) {
                abilities[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        generateCombinations(0, 0);
        System.out.println(minimumDifference);
    }

    static void generateCombinations(int index, int count) {
        if (count == numberOfPlayers / 2) {
            calculateDifference();
            return;
        }

        for (int i = index; i < numberOfPlayers; i++) {
            if (!selected[i]) {
                selected[i] = true;
                generateCombinations(i + 1, count + 1);
                selected[i] = false;
            }
        }
    }

    static void calculateDifference() {
        int teamStart = 0;
        int teamLink = 0;

        for (int i = 0; i < numberOfPlayers - 1; i++) {
            for (int j = i + 1; j < numberOfPlayers; j++) {
                if (selected[i] && selected[j]) {
                    teamStart += abilities[i][j];
                    teamStart += abilities[j][i];
                } else if (!selected[i] && !selected[j]) {
                    teamLink += abilities[i][j];
                    teamLink += abilities[j][i];
                }
            }
        }

        int difference = Math.abs(teamStart - teamLink);

        if (difference == 0) {
            System.out.println(difference);
            System.exit(0);
        }

        minimumDifference = Math.min(difference, minimumDifference);
    }
}