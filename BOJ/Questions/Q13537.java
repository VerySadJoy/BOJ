//Question No: 13537
//Title: 수열과 쿼리 1
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {
    static List<Integer>[] segmentTree;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 1];
        segmentTree = new ArrayList[n * 4];
        for (int i = 0; i < n * 4; i++) {
            segmentTree[i] = new ArrayList<>();
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            update(1, n, 1, i);
        }

        for (int i = 0; i < n * 4; i++) {
            Collections.sort(segmentTree[i]);
        }

        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(getCountGreaterThanK(1, n, 1, left, right, k)).append("\n");
        }

        System.out.println(sb.toString());
    }

    static void update(int start, int end, int node, int index) {
        if (start > index || end < index) return;
        segmentTree[node].add(arr[index]);

        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index);
        update(mid + 1, end, node * 2 + 1, index);
    }

    static int getCountGreaterThanK(int start, int end, int node, int left, int right, int k) {
        if (right < start || left > end) return 0;
        if (left <= start && end <= right) {
            int upperBoundIndex = upperBound(segmentTree[node], k);
            return segmentTree[node].size() - upperBoundIndex;
        }

        int mid = (start + end) / 2;
        return getCountGreaterThanK(start, mid, node * 2, left, right, k) + getCountGreaterThanK(mid + 1, end, node * 2 + 1, left, right, k);
    }

    static int upperBound(List<Integer> data, int value) {
        int start = 0;
        int end = data.size();

        while (start < end) {
            int mid = (start + end) / 2;
            if (data.get(mid) <= value) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}