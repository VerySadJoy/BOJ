//Question No: 1205
//Title: 등수 구하기
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        int totalScores = Integer.parseInt(tokenizer.nextToken());
        int newScore = Integer.parseInt(tokenizer.nextToken());
        int maxRankings = Integer.parseInt(tokenizer.nextToken());

        if (totalScores == 0) {
            System.out.println(1);
            return;
        }

        StringTokenizer scoresTokenizer = new StringTokenizer(inputReader.readLine());
        ArrayList<Integer> rankings = new ArrayList<>();

        for (int i = 0; i < totalScores; i++) {
            rankings.add(Integer.parseInt(scoresTokenizer.nextToken()));
        }

        int rank = 1;
        if (rankings.size() == maxRankings && newScore <= rankings.get(rankings.size() - 1)) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < totalScores; i++) {
            if (newScore >= rankings.get(i)) {
                rank = i + 1;
                break;
            } else {
                rank++;
            }
        }

        if (rank <= maxRankings) {
            System.out.println(rank);
        } else {
            System.out.println(-1);
        }
    }
}