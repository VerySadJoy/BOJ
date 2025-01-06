import java.io.*;
import java.util.*;

public class Main {
    static final int MAX = 100000;
    static int[] segmentTree, lazy;

    static void propagate(int node, int start, int end) {
        if (lazy[node] != 0) {
            segmentTree[node] += lazy[node];
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static void update(int node, int start, int end, int left, int right, int value) {
        propagate(node, start, end);
        if (right < start || end < left) return;
        if (left <= start && end <= right) {
            lazy[node] += value;
            propagate(node, start, end);
            return;
        }
        int mid = (start + end) / 2;
        update(node * 2, start, mid, left, right, value);
        update(node * 2 + 1, mid + 1, end, left, right, value);
        segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
    }

    static int query(int node, int start, int end, int left, int right) {
        propagate(node, start, end);
        if (right < start || end < left) return 0;
        if (left <= start && end <= right) return segmentTree[node];
        int mid = (start + end) / 2;
        return query(node * 2, start, mid, left, right) + query(node * 2 + 1, mid + 1, end, left, right);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());

        while (testCases-- > 0) {
            segmentTree = new int[(MAX + 1) * 4];
            lazy = new int[(MAX + 1) * 4];

            List<List<Integer>> houses = new ArrayList<>(MAX + 1);
            List<List<int[]>> openIntervals = new ArrayList<>(MAX + 1);
            List<List<int[]>> closeIntervals = new ArrayList<>(MAX + 1);

            for (int i = 0; i <= MAX; i++) {
                houses.add(new ArrayList<>());
                openIntervals.add(new ArrayList<>());
                closeIntervals.add(new ArrayList<>());
            }

            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(tokenizer.nextToken());
            int m = Integer.parseInt(tokenizer.nextToken());

            for (int i = 0; i < n; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                houses.get(x).add(y);
            }

            for (int i = 0; i < m; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int l = Integer.parseInt(tokenizer.nextToken());
                int r = Integer.parseInt(tokenizer.nextToken());
                int b = Integer.parseInt(tokenizer.nextToken());
                int t = Integer.parseInt(tokenizer.nextToken());
                openIntervals.get(l).add(new int[]{b, t});
                closeIntervals.get(r).add(new int[]{b, t});
            }

            int result = 0;

            for (int i = 0; i <= MAX; i++) {
                for (int[] interval : openIntervals.get(i)) {
                    update(1, 0, MAX, interval[0], interval[1], 1);
                }

                for (int y : houses.get(i)) {
                    result += query(1, 0, MAX, y, y);
                }

                for (int[] interval : closeIntervals.get(i)) {
                    update(1, 0, MAX, interval[0], interval[1], -1);
                }
            }

            System.out.println(result);
        }
    }
}