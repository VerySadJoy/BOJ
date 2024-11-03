//Question No: 1508
//Title: 레이스
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    static int totalLength, requiredSections, pointCount;

    public static void main(String args[]) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        totalLength = Integer.parseInt(tokenizer.nextToken());
        requiredSections = Integer.parseInt(tokenizer.nextToken());
        pointCount = Integer.parseInt(tokenizer.nextToken());

        int[] positions = new int[pointCount];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < pointCount; i++) {
            positions[i] = Integer.parseInt(tokenizer.nextToken());
        }

        System.out.println(findOptimalArrangement(positions));
    }

    static String findOptimalArrangement(int[] positions) {
        String arrangement = "";
        int minDistance = 1;
        int maxDistance = totalLength;

        while (minDistance <= maxDistance) {
            int midDistance = (minDistance + maxDistance) / 2;
            String result = evaluateArrangement(positions, midDistance);

            if (result.isEmpty()) {
                maxDistance = midDistance - 1;
            } else {
                minDistance = midDistance + 1;
                arrangement = result;
            }
        }

        return arrangement;
    }

    static String evaluateArrangement(int[] positions, int minimumDistance) {
        int sectionCount = 1;
        StringBuilder arrangement = new StringBuilder("1");
        int previousPosition = positions[0];

        for (int i = 1; i < positions.length; i++) {
            if (sectionCount == requiredSections) {
                arrangement.append("0");
            } else {
                if (positions[i] - previousPosition >= minimumDistance) {
                    arrangement.append("1");
                    sectionCount++;
                    previousPosition = positions[i];
                } else {
                    arrangement.append("0");
                }
            }
        }

        if (sectionCount == requiredSections) {
            return arrangement.toString();
        }
        return "";
    }
}