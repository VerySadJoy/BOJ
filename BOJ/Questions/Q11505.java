//Question No: 11505
//Title: 구간 곱 구하기
//Tier: Gold I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    private static final int MOD = 1000000007;
    private static long[] arr, segmentTree;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numElements = Integer.parseInt(tokenizer.nextToken());
        int numUpdates = Integer.parseInt(tokenizer.nextToken());
        int numQueries = Integer.parseInt(tokenizer.nextToken());

        arr = new long[numElements + 1];
        for (int i = 1; i <= numElements; i++) {
            arr[i] = Long.parseLong(reader.readLine());
        }

        segmentTree = new long[numElements * 4];
        initializeSegmentTree(1, numElements, 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numUpdates + numQueries; i++) {
            tokenizer = new StringTokenizer(reader.readLine());

            int operationType = Integer.parseInt(tokenizer.nextToken());
            int index = Integer.parseInt(tokenizer.nextToken());
            long value = Long.parseLong(tokenizer.nextToken());

            if (operationType == 1) {
                arr[index] = value;
                updateSegmentTree(1, numElements, 1, index, value);
            } else if (operationType == 2) {
                result.append(queryProduct(1, numElements, 1, index, (int) value)).append("\n");
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    private static long initializeSegmentTree(int start, int end, int node) {
        if (start == end) {
            return segmentTree[node] = arr[start];
        }

        int mid = (start + end) / 2;
        return segmentTree[node] = (initializeSegmentTree(start, mid, node * 2) * initializeSegmentTree(mid + 1, end, node * 2 + 1)) % MOD;
    }

    private static long queryProduct(int start, int end, int node, int queryStart, int queryEnd) {
        if (queryEnd < start || queryStart > end) {
            return 1;
        }

        if (queryStart <= start && end <= queryEnd) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        return (queryProduct(start, mid, node * 2, queryStart, queryEnd) * queryProduct(mid + 1, end, node * 2 + 1, queryStart, queryEnd)) % MOD;
    }

    private static long updateSegmentTree(int start, int end, int node, int index, long newValue) {
        if (index < start || index > end) {
            return segmentTree[node];
        }

        if (start == end) {
            return segmentTree[node] = newValue;
        }

        int mid = (start + end) / 2;
        return segmentTree[node] = (updateSegmentTree(start, mid, node * 2, index, newValue) * updateSegmentTree(mid + 1, end, node * 2 + 1, index, newValue)) % MOD;
    }
}
