//Question No: 10868
//Title: 최솟값
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    static int[] array, segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int queries = Integer.parseInt(tokenizer.nextToken());

        array = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            array[i] = Integer.parseInt(reader.readLine());
        }

        segmentTree = new int[n * 4];
        initializeSegmentTree(1, n, 1);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < queries; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int left = Integer.parseInt(tokenizer.nextToken());
            int right = Integer.parseInt(tokenizer.nextToken());
            result.append(findMinimum(1, n, 1, left, right)).append("\n");
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int initializeSegmentTree(int start, int end, int node) {
        if (start == end) {
            return segmentTree[node] = array[start];
        }

        int mid = (start + end) / 2;
        return segmentTree[node] = Math.min(
            initializeSegmentTree(start, mid, node * 2),
            initializeSegmentTree(mid + 1, end, node * 2 + 1)
        );
    }

    public static int findMinimum(int start, int end, int node, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        return Math.min(
            findMinimum(start, mid, node * 2, left, right),
            findMinimum(mid + 1, end, node * 2 + 1, left, right)
        );
    }
}