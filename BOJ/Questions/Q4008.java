//Question No: 4008
//Title: 특공대
//Tier: Diamond V
import java.io.*;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    static int numElements;
    static long coeffA, coeffB, coeffC;
    static long[] prefixSum = new long[1000001];
    static long[] dp = new long[1000001];

    public static void main(String[] args) throws IOException {
        BufferedWriter writer;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer tokenizer;
            numElements = Integer.parseInt(reader.readLine());
            tokenizer = new StringTokenizer(reader.readLine());
            coeffA = Long.parseLong(tokenizer.nextToken());
            coeffB = Long.parseLong(tokenizer.nextToken());
            coeffC = Long.parseLong(tokenizer.nextToken());
            tokenizer = new StringTokenizer(reader.readLine());
            for (int i = 1; i <= numElements; i++) {
                prefixSum[i] = Long.parseLong(tokenizer.nextToken());
                prefixSum[i] += prefixSum[i - 1];
            }
            writer.write(computeOptimalResult() + "\n");
        }
        writer.flush();
        writer.close();
    }

    private static double calculateIntersection(int lineIndex1, int lineIndex2) {
        return (coeffA * ((prefixSum[lineIndex2] * prefixSum[lineIndex2]) - (prefixSum[lineIndex1] * prefixSum[lineIndex1])) - coeffB * (prefixSum[lineIndex2] - prefixSum[lineIndex1]) + dp[lineIndex2] - dp[lineIndex1]) / (2.0 * coeffA * (prefixSum[lineIndex2] - prefixSum[lineIndex1]));
    }

    private static long evaluateFunction(int index) {
        return coeffA * (prefixSum[index] * prefixSum[index]) + coeffB * prefixSum[index] + coeffC;
    }

    private static long computeOptimalResult() {
        LinkedList<Integer> lineIndices = new LinkedList<>();
        lineIndices.addLast(0);
        for (int currentIndex = 1; currentIndex <= numElements; currentIndex++) {
            while (lineIndices.size() > 1 && calculateIntersection(lineIndices.getFirst(), lineIndices.get(1)) < prefixSum[currentIndex]) {
                lineIndices.removeFirst();
            }
            int bestLineIndex = lineIndices.getFirst();
            dp[currentIndex] = -2 * coeffA * prefixSum[bestLineIndex] * prefixSum[currentIndex] + coeffA * (prefixSum[bestLineIndex] * prefixSum[bestLineIndex]) - coeffB * prefixSum[bestLineIndex] + dp[bestLineIndex] + evaluateFunction(currentIndex);
            while (lineIndices.size() > 1 && calculateIntersection(currentIndex, lineIndices.get(lineIndices.size() - 2)) < calculateIntersection(lineIndices.getLast(), lineIndices.get(lineIndices.size() - 2))) {
                lineIndices.removeLast();
            }
            lineIndices.addLast(currentIndex);
        }
        return dp[numElements];
    }
}