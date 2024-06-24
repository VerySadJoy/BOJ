//Question No: 13334
//Title: 철로
//Tier: Gold II
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numActivities = scanner.nextInt();
        int[][] activities = new int[numActivities][2];

        for (int i = 0; i < numActivities; ++i) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }
            activities[i][0] = start;
            activities[i][1] = end;
        }

        Arrays.sort(activities, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });

        int railLength = scanner.nextInt();
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        int currentStart, currentEnd;
        int maxActivities = 0;
        int currentActivityCount = 0;

        for (int i = 0; i < numActivities; ++i) {
            currentEnd = activities[i][1];
            currentStart = currentEnd - railLength;

            while (!minHeap.isEmpty() && minHeap.peek() < currentStart) {
                minHeap.poll();
                --currentActivityCount;
            }

            if (activities[i][0] >= currentStart) {
                minHeap.offer(activities[i][0]);
                ++currentActivityCount;
                maxActivities = Math.max(maxActivities, currentActivityCount);
            }
        }

        System.out.println(maxActivities);

        scanner.close();
    }
}
