//Question No: 2170
//Title: 선 긋기
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int[][] positions = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            positions[i][0] = Integer.parseInt(tokenizer.nextToken());
            positions[i][1] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(positions, (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);

        int totalLength = 0;
        int currentStart = positions[0][0];
        int currentEnd = positions[0][1];
        totalLength += currentEnd - currentStart;

        for (int i = 1; i < n; i++) {
            int nextStart = positions[i][0];
            int nextEnd = positions[i][1];

            if (nextStart <= currentEnd) {
                if (nextEnd > currentEnd) {
                    totalLength += nextEnd - currentEnd;
                    currentEnd = nextEnd;
                }
            } else {
                totalLength += nextEnd - nextStart;
                currentStart = nextStart;
                currentEnd = nextEnd;
            }
        }

        System.out.println(totalLength);
    }
}