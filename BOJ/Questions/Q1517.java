//Question No: 1517
//Title: 버블 소트
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {

    static class Info implements Comparable<Info> {
        int index, value;

        Info(int index, int value) {
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(Info other) {
            return this.value - other.value;
        }
    }

    static long[] segmentTree;
    static Info[] values;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        values = new Info[n];
        for (int i = 0; i < n; i++) {
            values[i] = new Info(i, Integer.parseInt(tokenizer.nextToken()));
        }

        long result = 0;
        Arrays.sort(values);
        segmentTree = new long[calculateTreeSize(n)];
        int previousValue = Integer.MAX_VALUE;
        List<Integer> indices = new ArrayList<>();

        for (Info value : values) {
            if (previousValue != value.value) {
                for (int index : indices) {
                    updateSegmentTree(0, n - 1, 1, index);
                }
                indices.clear();
                previousValue = value.value;
            }
            result += querySegmentTree(0, n - 1, 1, value.index + 1, n - 1);
            indices.add(value.index);
        }

        writer.write(String.valueOf(result));
        writer.flush();
        writer.close();
        reader.close();
    }

    static long querySegmentTree(int start, int end, int node, int left, int right) {
        if (left > end || right < start) {
            return 0L;
        }
        if (left <= start && end <= right) {
            return segmentTree[node];
        }
        int mid = (start + end) / 2;
        return querySegmentTree(start, mid, node * 2, left, right) 
             + querySegmentTree(mid + 1, end, node * 2 + 1, left, right);
    }

    static void updateSegmentTree(int start, int end, int node, int index) {
        if (start == index && end == index) {
            segmentTree[node] = 1L;
            return;
        }
        int mid = (start + end) / 2;
        if (index <= mid) {
            updateSegmentTree(start, mid, node * 2, index);
        } else {
            updateSegmentTree(mid + 1, end, node * 2 + 1, index);
        }
        segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
    }

    static int calculateTreeSize(int n) {
        int height = (int) Math.ceil(Math.log(n) / Math.log(2)) + 1;
        return (int) Math.pow(2, height) - 1;
    }
}