//Question No: 15919
//Title: 사자는 여행왕이야!!
//Tier: Gold III
import java.util.*;

public class Main {

    private static int n, m;
    private static int[] dp = new int[1001];
    private static List<Pair> trips = new ArrayList<>();

    private static class Pair {
        int start, end;
        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    private static int findMinGap(int currentTrip) {
        if (currentTrip == m) return 0;
        if (dp[currentTrip] != -1) return dp[currentTrip];

        int result = 10000;
        for (int i = currentTrip + 1; i < m; ++i) {
            if (trips.get(i).start <= trips.get(currentTrip).end) continue;
            result = Math.min(result, Math.max(trips.get(i).start - trips.get(currentTrip).end - 1, findMinGap(i)));
        }
        result = Math.min(result, n - trips.get(currentTrip).end);
        dp[currentTrip] = result;
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        m = scanner.nextInt();

        for (int i = 0; i < m; ++i) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();
            trips.add(new Pair(start, end));
        }
        trips.sort(Comparator.comparingInt(o -> o.start));
        Arrays.fill(dp, -1);

        int minGap = 1000;
        for (int i = 0; i < m; ++i) {
            minGap = Math.min(minGap, Math.max(trips.get(i).start - 1, findMinGap(i)));
        }

        System.out.println(minGap);
        scanner.close();
    }
}