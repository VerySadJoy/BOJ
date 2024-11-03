//Question No: 24913
//Title: 개표
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int candidateCount = Integer.parseInt(tokenizer.nextToken());
        int queryCount = Integer.parseInt(tokenizer.nextToken());
        long[] votes = new long[candidateCount + 2];
        StringBuilder result = new StringBuilder();
        
        long totalVotes = 0;
        long maxVotes = 0;

        for (int i = 0; i < queryCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int queryType = Integer.parseInt(tokenizer.nextToken());
            int valueX = Integer.parseInt(tokenizer.nextToken());
            int valueY = Integer.parseInt(tokenizer.nextToken());

            if (queryType == 1) {
                votes[valueY] += valueX;
                if (valueY != candidateCount + 1) {
                    totalVotes += valueX;
                    maxVotes = Math.max(maxVotes, votes[valueY]);
                }
            } else {
                long referenceVotes = votes[candidateCount + 1] + valueX;
                long averageVotes = (totalVotes + valueY) / candidateCount;
                if ((totalVotes + valueY) % candidateCount != 0) {
                    averageVotes += 1;
                }
                if (referenceVotes <= maxVotes || referenceVotes <= averageVotes) {
                    result.append("NO").append("\n");
                } else {
                    result.append("YES").append("\n");
                }
            }
        }
        
        System.out.print(result);
    }
}