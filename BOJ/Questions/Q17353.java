//Question No: 17353
//Title: 하늘에서 떨어지는 1, 2, ..., R-L+1개의 별
//Tier: Platinum II
import static java.lang.Integer.*;
import java.io.*;
import java.util.*;

class Segment {
    long[] tree, arr;
    int size;
    long[][] lazy;

    public Segment(int size, long[] arr) {
        this.size = size;
        tree = new long[size];
        lazy = new long[size][2];
        this.arr = arr;
    }

    void init(int node, int start, int end) {
        if (start == end) {
            tree[node] = arr[start];
            return;
        }

        int mid = (start + end) >> 1;
        init(node << 1, start, mid);
        init(node << 1 | 1, mid + 1, end);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    void lazyUpdate(int node, int start, int end) {
        int mid = (start + end) >> 1;

        if (lazy[node][0] != 0) {
            tree[node] += lazy[node][0];
            if (start != end) {
                lazy[node << 1][0] += lazy[node][0];
                lazy[node << 1][1] += lazy[node][1];

                lazy[node << 1 | 1][0] += lazy[node][0] + (mid - start + 1) * lazy[node][1];
                lazy[node << 1 | 1][1] += lazy[node][1];
            }
            lazy[node][0] = 0;
            lazy[node][1] = 0;
        }
    }

    private long getRange(long range) {
        return range * (range + 1) / 2;
    }

    void update(int node, int start, int end, int left, int right) {
        lazyUpdate(node, start, end);

        if (left > end || right < start) {
            return;
        }

        int mid = (start + end) >> 1;
        if (left <= start && right >= end) {
            tree[node] += getRange(end - left + 1) - getRange(start - left);
            if (start != end) {
                lazy[node << 1][0] += start - left + 1;
                lazy[node << 1 | 1][0] += start - left + 1 + (mid - start + 1);
                lazy[node << 1][1]++;
                lazy[node << 1 | 1][1]++;
            }
            return;
        }

        update(node << 1, start, mid, left, right);
        update(node << 1 | 1, mid + 1, end, left, right);
        tree[node] = tree[node << 1] + tree[node << 1 | 1];
    }

    long query(int node, int start, int end, int index) {
        lazyUpdate(node, start, end);

        if (index > end || index < start) {
            return 0;
        }

        int mid = (start + end) >> 1;

        if (start == end) {
            return tree[node];
        }

        return Math.max(query(node << 1, start, mid, index), query(node << 1 | 1, mid + 1, end, index));
    }
}

public class Main {
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int size, queries, queryType, left, right;
        long[] arr;

        size = parseInt(reader.readLine());
        arr = new long[size + 1];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= size; i++) {
            arr[i] = Long.parseLong(tokenizer.nextToken());
        }

        Segment segment = new Segment(4 * size, arr);
        segment.init(1, 1, size);

        queries = parseInt(reader.readLine());

        while (queries-- > 0) {
            tokenizer = new StringTokenizer(reader.readLine());
            queryType = parseInt(tokenizer.nextToken());
            if (queryType == 1) {
                left = parseInt(tokenizer.nextToken());
                right = parseInt(tokenizer.nextToken());
                segment.update(1, 1, size, left, right);
            } else {
                index = parseInt(tokenizer.nextToken());
                writer.write(Long.toString(segment.query(1, 1, size, index)) + '\n');
            }
        }

        writer.flush();
    }
}