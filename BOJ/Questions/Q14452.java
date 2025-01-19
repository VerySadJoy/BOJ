//Question No: 14452
//Title: Cow Dance Show
//Tier: Gold IV
import java.io.*;
import java.util.*;

public class Main {

    static int taskCount, maxTime;
    static int[] taskDurations = new int[10005];

    private static boolean canAllocateWorkers(int workerCount) {
        PriorityQueue<Integer> workerQueue = new PriorityQueue<>();
        int currentTime = 0;

        for (int i = 0; i < taskCount; i++) {
            if (!workerQueue.isEmpty() && workerQueue.size() == workerCount) {
                currentTime = workerQueue.poll();
            }
            if (currentTime + taskDurations[i] > maxTime) {
                return false;
            }
            workerQueue.add(currentTime + taskDurations[i]);
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        taskCount = Integer.parseInt(tokenizer.nextToken());
        maxTime = Integer.parseInt(tokenizer.nextToken());

        for (int i = 0; i < taskCount; i++) {
            taskDurations[i] = Integer.parseInt(reader.readLine());
        }

        int low = 0, high = 10005;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            if (canAllocateWorkers(mid)) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.println(high);
    }
}