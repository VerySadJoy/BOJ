//Question No: 32377
//Title: 풍선 터트리기
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int targetCount = Integer.parseInt(tokenizer.nextToken());
        long[] processingTimes = new long[3];
        long maxProcessingTime = 0;

        for (int i = 0; i < 3; i++) {
            processingTimes[i] = Long.parseLong(tokenizer.nextToken());
            maxProcessingTime = Math.max(processingTimes[i], maxProcessingTime);
        }

        long minTime = 1;
        long maxTime = maxProcessingTime * targetCount;

        while (minTime <= maxTime) {
            long midTime = (minTime + maxTime) / 2;
            long totalProcessed = calculateProcessedItems(processingTimes, midTime);

            if (totalProcessed >= targetCount) {
                maxTime = midTime - 1;
            } else {
                minTime = midTime + 1;
            }
        }

        long previousProcessed = calculateProcessedItems(processingTimes, minTime - 1);

        for (int i = 0; i < 3; i++) {
            if (minTime % processingTimes[i] == 0) {
                previousProcessed++;
                if (previousProcessed == targetCount) {
                    System.out.println(getWinner(i));
                    break;
                }
            }
        }
    }

    private static long calculateProcessedItems(long[] processingTimes, long time) {
        long total = 0;
        for (long timePerItem : processingTimes) {
            total += time / timePerItem;
        }
        return total;
    }

    private static String getWinner(int index) {
        if (index == 0) return "A win";
        if (index == 1) return "B win";
        return "C win";
    }
}