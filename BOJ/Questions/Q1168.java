//Question No: 1168
//Title: 요세푸스 문제 2
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;

    public static int init(int start, int end, int node) {
        if (start == end) {
            return tree[node] = 1;
        }
        int mid = (start + end) / 2;
        return tree[node] = init(start, mid, 2 * node) + init(mid + 1, end, 2 * node + 1);
    }

    public static int update(int start, int end, int node, int del) {
        tree[node]--;
        if (start == end) {
            return 0;
        }
        int mid = (start + end) / 2;
        if (del <= mid) {
            return update(start, mid, 2 * node, del);
        } else {
            return update(mid + 1, end, 2 * node + 1, del);
        }
    }

    public static int query(int start, int end, int node, int order) {
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (order <= tree[2 * node]) {
            return query(start, mid, 2 * node, order);
        } else {
            return query(mid + 1, end, 2 * node + 1, order - tree[2 * node]);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        tree = new int[n * 4];
        init(1, n, 1);

        int index = 1;
        StringBuilder result = new StringBuilder("<");

        for (int i = 0; i < n; i++) {
            index += k - 1;
            int size = n - i;

            if (index % size == 0) {
                index = size;
            } else if (index > size) {
                index %= size;
            }

            int num = query(1, n, 1, index);
            update(1, n, 1, num);

            if (i == n - 1) {
                result.append(num).append(">");
            } else {
                result.append(num).append(", ");
            }
        }

        writer.write(result.toString());
        writer.flush();
        writer.close();
    }
}