//Question No: 12899
//Title: 데이터 구조
//Tier: Platinum IV
import java.io.*;
import java.util.*;

public class Main {
    static int[] tree;
    static final int MAX = 2_000_001;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int queries = Integer.parseInt(reader.readLine());
        StringBuilder resultBuilder = new StringBuilder();
        tree = new int[MAX * 4];

        while (queries-- > 0) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int operation = Integer.parseInt(tokenizer.nextToken());
            int value = Integer.parseInt(tokenizer.nextToken());
            if (operation == 1) {
                update(1, MAX, 1, value);
            } else {
                resultBuilder.append(query(1, MAX, 1, value)).append("\n");
            }
        }
        System.out.print(resultBuilder);
    }

    public static void update(int start, int end, int node, int index) {
        if (index < start || index > end) return;
        tree[node] += 1;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(start, mid, node * 2, index);
        update(mid + 1, end, node * 2 + 1, index);
    }

    public static int query(int start, int end, int node, int k) {
        tree[node] -= 1;
        if (start == end) {
            return start;
        }
        int mid = (start + end) / 2;
        if (tree[node * 2] < k) {
            return query(mid + 1, end, node * 2 + 1, k - tree[node * 2]);
        } else {
            return query(start, mid, node * 2, k);
        }
    }
}