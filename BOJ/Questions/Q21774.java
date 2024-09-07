//Question No: 21774
//Title: 가희와 로그 파일
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        List<String> eventsList = new ArrayList<>();
        String[] inputTokens;

        inputTokens = bufferedReader.readLine().split(" ");
        int numEvents = Integer.parseInt(inputTokens[0]);
        int numQueries = Integer.parseInt(inputTokens[1]);

        String[] eventIdentifiers = new String[numEvents];
        int[] eventLevels = new int[numEvents];

        String[] queryStart = new String[numQueries];
        String[] queryEnd = new String[numQueries];
        int[] queryLevels = new int[numQueries];

        int[][] eventMatrix = new int[7][numEvents + 2 * numQueries + 1];
        int[][] cumulativeMatrix = new int[7][numEvents + 2 * numQueries + 1];

        eventsList.add("");
        for (int i = 0; i < numEvents; i++) {
            inputTokens = bufferedReader.readLine().split("#");
            eventIdentifiers[i] = inputTokens[0];
            eventLevels[i] = Integer.parseInt(inputTokens[1]);
            eventsList.add(eventIdentifiers[i]);
        }

        for (int i = 0; i < numQueries; i++) {
            inputTokens = bufferedReader.readLine().split("#");
            queryStart[i] = inputTokens[0];
            eventsList.add(queryStart[i]);
            queryEnd[i] = inputTokens[1];
            eventsList.add(queryEnd[i]);
            queryLevels[i] = Integer.parseInt(inputTokens[2]);
        }

        Collections.sort(eventsList);

        for (int i = 0; i < numEvents; i++) {
            int index = Collections.binarySearch(eventsList, eventIdentifiers[i]);
            eventMatrix[eventLevels[i]][index]++;
        }

        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= numEvents + 2 * numQueries; j++) {
                cumulativeMatrix[i][j] = cumulativeMatrix[i - 1][j] + cumulativeMatrix[i][j - 1] - cumulativeMatrix[i - 1][j - 1] + eventMatrix[i][j];
            }
        }

        StringBuilder resultBuilder = new StringBuilder();
        for (int i = 0; i < numQueries; i++) {
            int startIndex = Collections.binarySearch(eventsList, queryStart[i]);
            int endIndex = Collections.binarySearch(eventsList, queryEnd[i]);
            int level = queryLevels[i];

            int result = calculate(level, startIndex, endIndex, cumulativeMatrix);
            resultBuilder.append(result).append("\n");
        }

        System.out.println(resultBuilder.toString());
    }

    private static int calculate(int level, int start, int end, int[][] cumulativeMatrix) {
        return cumulativeMatrix[6][end] - cumulativeMatrix[level - 1][end]
                - cumulativeMatrix[6][start - 1] + cumulativeMatrix[level - 1][start - 1];
    }
}