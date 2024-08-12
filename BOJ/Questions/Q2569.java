//Question No: 2569
//Title: 짐정리
//Tier: Platinum I
import java.util.Scanner;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] weights = new int[n][2];
        
        for (int i = 0; i < n; i++) {
            weights[i][0] = scanner.nextInt();
            weights[i][1] = i;
        }

        Arrays.sort(weights, (a, b) -> Integer.compare(a[0], b[0]));
        int result = 0;
        boolean[] visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (visited[i]) continue;

            int cycleSum = 0;
            int cycleLength = 0;
            int next = i;

            while (!visited[next]) {
                visited[next] = true;
                cycleSum += weights[next][0];
                cycleLength++;
                next = weights[next][1];
            }

            if (cycleLength > 1) {
                result += Math.min(
                    cycleSum + (cycleLength - 2) * weights[i][0],
                    cycleSum + weights[0][0] * (cycleLength + 1) + weights[i][0]
                );
            }
        }

        System.out.println(result);
    }
}