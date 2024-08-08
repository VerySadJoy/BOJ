//Question No: 3020
//Title: 개똥벌레
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int h = Integer.parseInt(tokenizer.nextToken());

        int[] stalactites = new int[n / 2];
        int[] stalagmites = new int[n / 2];

        for (int i = 0; i < n / 2; i++) {
            stalactites[i] = Integer.parseInt(reader.readLine());
            stalagmites[i] = Integer.parseInt(reader.readLine());
        }

        Arrays.sort(stalactites);
        Arrays.sort(stalagmites);

        int[] obstacleCount = new int[h];

        for (int i = 0; i < h; i++) {
            int count = (n / 2 - lowerBound(stalactites, i + 1)) + (n / 2 - lowerBound(stalagmites, h - i));
            obstacleCount[i] = count;
        }

        int minObstacles = Arrays.stream(obstacleCount).min().orElse(0);
        long minCount = Arrays.stream(obstacleCount).filter(count -> count == minObstacles).count();

        System.out.println(minObstacles + " " + minCount);
    }

    private static int lowerBound(int[] array, int target) {
        int start = 0, end = array.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (target <= array[mid]) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }

        return start;
    }
}