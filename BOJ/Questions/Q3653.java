//Question No: 3653
//Title: 영화 수집
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {

    static int movieCount, queryCount;
    static int[] moviePositions, movieIndexes, segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int testCases = Integer.parseInt(reader.readLine());
        while(testCases-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            movieCount = Integer.parseInt(tokenizer.nextToken());
            queryCount = Integer.parseInt(tokenizer.nextToken());

            moviePositions = new int[movieCount + queryCount];
            movieIndexes = new int[movieCount + 1];
            segmentTree = new int[(movieCount + queryCount + 1) * 4];

            for(int i = 0; i < movieCount; i++) {
                moviePositions[i] = 1;
                movieIndexes[i + 1] = movieCount - 1 - i;
            }

            initializeSegmentTree(1, 0, movieCount + queryCount - 1);

            tokenizer = new StringTokenizer(reader.readLine());
            int currentIndex = movieCount;
            while(tokenizer.hasMoreTokens()) {
                int movie = Integer.parseInt(tokenizer.nextToken());
                int movieIndex = movieIndexes[movie];
                writer.write(querySum(1, 0, movieCount + queryCount - 1, movieIndex + 1, movieCount + queryCount - 1) + " ");
                moviePositions[movieIndex] = 0;
                updateSegmentTree(1, 0, movieCount + queryCount - 1, movieIndex, -1);
                movieIndexes[movie] = currentIndex;
                updateSegmentTree(1, 0, movieCount + queryCount - 1, currentIndex, 1);
                moviePositions[currentIndex++] = 1;
            }
            writer.write("\n");
        }

        reader.close();
        writer.close();
    }

    static void initializeSegmentTree(int node, int start, int end) {
        if(start == end) {
            segmentTree[node] = moviePositions[start];
            return;
        }
        int mid = (start + end) / 2;
        initializeSegmentTree(node * 2, start, mid);
        initializeSegmentTree(node * 2 + 1, mid + 1, end);
        segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
    }

    static void updateSegmentTree(int node, int start, int end, int index, int diff) {
        if(index < start || index > end) return;
        segmentTree[node] += diff;
        if(start == end) return;
        int mid = (start + end) / 2;
        updateSegmentTree(node * 2, start, mid, index, diff);
        updateSegmentTree(node * 2 + 1, mid + 1, end, index, diff);
    }

    static int querySum(int node, int start, int end, int left, int right) {
        if(right < start || left > end) return 0;
        if(left <= start && end <= right) return segmentTree[node];
        int mid = (start + end) / 2;
        return querySum(node * 2, start, mid, left, right) + querySum(node * 2 + 1, mid + 1, end, left, right);
    }
}
