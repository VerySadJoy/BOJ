//Question No: 25827
//Title: 시간 구간 다중 업데이트 다중 합
//Tier: Gold V
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static final int SECONDS_IN_A_DAY = 24 * 60 * 60;
    private static final long[] changes = new long[SECONDS_IN_A_DAY + 2];
    private static final long[] prefixSum = new long[SECONDS_IN_A_DAY + 2];
    private static boolean initialized = false;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(reader.readLine());
        StringBuilder result = new StringBuilder();

        while (queries-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int queryType = Integer.parseInt(tokenizer.nextToken());
            int startTime = parseTime(tokenizer.nextToken());
            int endTime = parseTime(tokenizer.nextToken());

            if (queryType == 1) {
                addChange(startTime, endTime);
            } else {
                initializePrefixSum();
                result.append(getRangeSum(startTime, endTime)).append("\n");
            }
        }

        System.out.print(result);
    }

    private static int parseTime(String time) {
        String[] parts = time.split(":");
        int hours = Integer.parseInt(parts[0]);
        int minutes = Integer.parseInt(parts[1]);
        int seconds = Integer.parseInt(parts[2]);
        return hours * 3600 + minutes * 60 + seconds + 1;
    }

    private static void addChange(int start, int end) {
        changes[start]++;
        changes[end]--;
    }

    private static void initializePrefixSum() {
        if (initialized) return;
        initialized = true;

        for (int i = 1; i <= SECONDS_IN_A_DAY; i++) {
            changes[i] += changes[i - 1];
            prefixSum[i] = prefixSum[i - 1] + changes[i];
        }
    }

    private static long getRangeSum(int start, int end) {
        return prefixSum[end - 1] - prefixSum[start - 1];
    }
}