//Question No: 14428
//Title: 수열과 쿼리 16
//Tier: Gold I
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    static int[] segmentTree, array;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int arraySize = Integer.parseInt(reader.readLine());
        array = new int[arraySize + 1];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= arraySize; i++) {
            array[i] = Integer.parseInt(tokenizer.nextToken());
        }

        segmentTree = new int[arraySize * 4];
        initializeSegmentTree(1, arraySize, 1);
        int queryCount = Integer.parseInt(reader.readLine());

        StringBuilder result = new StringBuilder();
        while (queryCount-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());

            int operation = Integer.parseInt(tokenizer.nextToken());
            int left = Integer.parseInt(tokenizer.nextToken());
            int right = Integer.parseInt(tokenizer.nextToken());

            if (operation == 1) {
                updateSegmentTree(1, arraySize, 1, left, right);
            } else if (operation == 2) {
                result.append(querySegmentTree(1, arraySize, 1, left, right)).append("\n");
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
        reader.close();
    }

    public static void initializeSegmentTree(int start, int end, int node) {
        if (start == end) {
            segmentTree[node] = start;
        } else {
            int mid = (start + end) / 2;
            initializeSegmentTree(start, mid, node * 2);
            initializeSegmentTree(mid + 1, end, node * 2 + 1);

            if (array[segmentTree[node * 2]] <= array[segmentTree[node * 2 + 1]]) {
                segmentTree[node] = segmentTree[node * 2];
            } else {
                segmentTree[node] = segmentTree[node * 2 + 1];
            }
        }
    }

    public static int querySegmentTree(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return -1;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        int minLeft = querySegmentTree(start, mid, node * 2, left, right);
        int minRight = querySegmentTree(mid + 1, end, node * 2 + 1, left, right);
        
        if (minLeft == -1) {
            return minRight;
        } else if (minRight == -1) {
            return minLeft;
        } else {
            if (array[minLeft] <= array[minRight]) {
                return minLeft;
            } else {
                return minRight;
            }
        }
    }

    public static void updateSegmentTree(int start, int end, int node, int index, int value) {
        if (index < start || index > end) {
            return;
        }

        if (start == end) {
            segmentTree[node] = index;
            array[index] = value;
            return;
        }

        int mid = (start + end) / 2;
        updateSegmentTree(start, mid, node * 2, index, value);
        updateSegmentTree(mid + 1, end, node * 2 + 1, index, value);
        
        if (array[segmentTree[node * 2]] <= array[segmentTree[node * 2 + 1]]) {
            segmentTree[node] = segmentTree[node * 2];
        } else {
            segmentTree[node] = segmentTree[node * 2 + 1];
        }
    }
}
