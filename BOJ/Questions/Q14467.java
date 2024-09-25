//Question No: 14467
//Title: 소가 길을 건너간 이유 1
//Tier: Bronze I
import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int numberOfEntries = Integer.parseInt(reader.readLine());
        int[][] cowPositions = new int[11][1];
        int positionChanges = 0;

        for(int i = 1; i < 11; i++) {
            cowPositions[i][0] = -1;
        }

        StringTokenizer tokenizer;
        for(int i = 0; i < numberOfEntries; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            int cowId = Integer.parseInt(tokenizer.nextToken());
            int position = Integer.parseInt(tokenizer.nextToken());

            if(cowPositions[cowId][0] == -1) {
                cowPositions[cowId][0] = position;
            } else {
                if(cowPositions[cowId][0] != position) {
                    positionChanges++;
                    cowPositions[cowId][0] = position;
                }
            }
        }
        System.out.println(positionChanges);
    }
}