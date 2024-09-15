//Question No: 2336
//Title: 굉장한 학생
//Tier: Platinum II
import java.io.*;
import java.util.*;

class Main {

    static class Triplet {
        int x, y, z;
    }

    static Triplet[] elements;
    static int[] segmentTree;
    static final int MAX = 500000 + 10;
    static final int INF = 1000000007;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        elements = new Triplet[n + 1];
        segmentTree = new int[4 * MAX];

        for (int i = 1; i <= n; i++) {
            elements[i] = new Triplet();
        }

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(tokenizer.nextToken());
            elements[t].x = i;
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(tokenizer.nextToken());
            elements[t].y = i;
        }

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 1; i <= n; i++) {
            int t = Integer.parseInt(tokenizer.nextToken());
            elements[t].z = i;
        }

        Arrays.sort(elements, 1, n + 1, Comparator.comparingInt(a -> a.x));

        for (int i = 1; i <= n; i++) {
            update(1, 1, n, i, INF);
        }

        int result = 0;
        for (int i = 1; i <= n; i++) {
            if (query(1, 1, n, 1, elements[i].y) > elements[i].z) {
                result++;
            }
            update(1, 1, n, elements[i].y, elements[i].z);
        }

        System.out.println(result);
    }

    static int update(int node, int start, int end, int index, int value) {
        if (index < start || end < index) return segmentTree[node];
        if (start == end) return segmentTree[node] = value;
        int mid = (start + end) / 2;
        return segmentTree[node] = Math.min(
                update(node * 2, start, mid, index, value),
                update(node * 2 + 1, mid + 1, end, index, value)
        );
    }

    static int query(int node, int start, int end, int left, int right) {
        if (right < start || end < left) return INF;
        if (left <= start && end <= right) return segmentTree[node];
        int mid = (start + end) / 2;
        return Math.min(
                query(node * 2, start, mid, left, right),
                query(node * 2 + 1, mid + 1, end, left, right)
        );
    }
}