//Question No: 12642
//Title: Bribe the Prisoners (Large)
//Tier: Gold I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringBuilder output = new StringBuilder();

        for (int caseNum = 1; caseNum <= testCases; caseNum++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int length = Integer.parseInt(tokenizer.nextToken());
            int cutsCount = Integer.parseInt(tokenizer.nextToken());

            int[] cutPoints = new int[cutsCount];
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 0; i < cutsCount; i++) {
                cutPoints[i] = Integer.parseInt(tokenizer.nextToken());
            }

            Arrays.sort(cutPoints);

            int[][] memo = new int[cutsCount][cutsCount];
            for (int[] row : memo) Arrays.fill(row, -1);

            int minimumCost = calculateMinimumCost(0, cutsCount - 1, cutPoints, length, memo);
            output.append("Case #").append(caseNum).append(": ").append(minimumCost).append("\n");
        }

        System.out.print(output);
    }

    private static int calculateMinimumCost(int left, int right, int[] cutPoints, int length, int[][] memo) {
        if (left > right) return 0;
        if (memo[left][right] != -1) return memo[left][right];

        int leftBoundary = left > 0 ? cutPoints[left - 1] : 0;
        int rightBoundary = right < cutPoints.length - 1 ? cutPoints[right + 1] : length + 1;
        int minimumCost = Integer.MAX_VALUE;

        for (int i = left; i <= right; i++) {
            int cost = (rightBoundary - leftBoundary - 2) + calculateMinimumCost(left, i - 1, cutPoints, length, memo) + calculateMinimumCost(i + 1, right, cutPoints, length, memo);
            minimumCost = Math.min(minimumCost, cost);
        }

        memo[left][right] = minimumCost;
        return minimumCost;
    }
}