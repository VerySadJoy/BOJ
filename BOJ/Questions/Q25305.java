//Question No: 25305
//Title: 커트라인
//Tier: Bronze II
import java.io.*;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter outputWriter = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());
        int numParticipants = Integer.parseInt(tokenizer.nextToken());
        int cutoffRank = Integer.parseInt(tokenizer.nextToken());

        Integer[] scores = new Integer[numParticipants];
        tokenizer = new StringTokenizer(inputReader.readLine());
        for (int i = 0; i < numParticipants; i++) {
            scores[i] = Integer.valueOf(tokenizer.nextToken());
        }
        inputReader.close();

        Arrays.sort(scores, Collections.reverseOrder());
        outputWriter.write(scores[cutoffRank - 1].toString());
        outputWriter.flush();
        outputWriter.close();
    }
}