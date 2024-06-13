//Question No: 2042
//Title: 구간 합 구하기
//Tier: Gold I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static long[] values, segmentTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numElements = Integer.parseInt(tokenizer.nextToken());
        int numUpdates = Integer.parseInt(tokenizer.nextToken());
        int numQueries = Integer.parseInt(tokenizer.nextToken());

        values = new long[numElements + 1];
        for (int i = 1; i <= numElements; i++) {
            values[i] = Long.parseLong(reader.readLine());
        }

        segmentTree = new long[numElements * 4];
        buildSegmentTree(1, numElements, 1);

        StringBuilder output = new StringBuilder();
        for (int i = 0; i < numUpdates + numQueries; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int queryType = Integer.parseInt(tokenizer.nextToken());
            int start = Integer.parseInt(tokenizer.nextToken());
            long endOrValue = Long.parseLong(tokenizer.nextToken());

            if (queryType == 1) {
                long difference = endOrValue - values[start];
                values[start] = endOrValue;
                updateSegmentTree(1, numElements, 1, start, difference);
            } else if (queryType == 2) {
                output.append(rangeSum(1, numElements, 1, start, (int) endOrValue)).append("\n");
            }
        }

        writer.write(output.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    public static long buildSegmentTree(int start, int end, int node) {
        if (start == end) {
            return segmentTree[node] = values[start];
        }

        int mid = (start + end) / 2;
        return segmentTree[node] = buildSegmentTree(start, mid, node * 2) + buildSegmentTree(mid + 1, end, node * 2 + 1);
    }

    public static long rangeSum(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        return rangeSum(start, mid, node * 2, left, right) + rangeSum(mid + 1, end, node * 2 + 1, left, right);
    }

    public static void updateSegmentTree(int start, int end, int node, int index, long difference) {
        if (index < start || index > end) {
            return;
        }

        segmentTree[node] += difference;
        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        updateSegmentTree(start, mid, node * 2, index, difference);
        updateSegmentTree(mid + 1, end, node * 2 + 1, index, difference);
    }
}
