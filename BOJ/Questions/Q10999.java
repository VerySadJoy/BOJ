//Question No: 10999
//Title: 구간 합 구하기 2
//Tier: Platinum IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 1000001;
    static long[] arr = new long[MAX];
    static long[] tree = new long[MAX * 4];
    static long[] lazy = new long[MAX * 4];
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        buildTree(1, N, 1);

        for (int i = 0; i < K + M; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            if (type % 2 == 1) {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                long value = Long.parseLong(st.nextToken());
                update(1, N, l, r, value, 1);
            } else {
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                System.out.println(query(1, N, l, r, 1));
            }
        }
    }

    static void buildTree(int start, int end, int node) {
        if (start == end) {
            tree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildTree(start, mid, node * 2);
            buildTree(mid + 1, end, node * 2 + 1);
            tree[node] = tree[node * 2] + tree[node * 2 + 1];
        }
    }

    static void updateLazy(int start, int end, int node) {
        if (lazy[node] != 0) {
            tree[node] += lazy[node] * (end - start + 1);
            if (start != end) {
                lazy[node * 2] += lazy[node];
                lazy[node * 2 + 1] += lazy[node];
            }
            lazy[node] = 0;
        }
    }

    static long query(int start, int end, int l, int r, int node) {
        updateLazy(start, end, node);
        if (r < start || l > end) return 0;
        if (l <= start && end <= r) return tree[node];
        int mid = (start + end) / 2;
        return query(start, mid, l, r, node * 2) + query(mid + 1, end, l, r, node * 2 + 1);
    }

    static void update(int start, int end, int l, int r, long value, int node) {
        updateLazy(start, end, node);
        if (r < start || l > end) return;
        if (l <= start && end <= r) {
            tree[node] += value * (end - start + 1);
            if (start != end) {
                lazy[node * 2] += value;
                lazy[node * 2 + 1] += value;
            }
            return;
        }
        int mid = (start + end) / 2;
        update(start, mid, l, r, value, node * 2);
        update(mid + 1, end, l, r, value, node * 2 + 1);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }
}