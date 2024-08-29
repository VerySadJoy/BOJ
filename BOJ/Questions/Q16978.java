//Question No: 16978
//Title: 수열과 쿼리 22
//Tier: Platinum IV
import java.util.*;

public class Main {
    static class Query {
        int k, queryStart, queryEnd, index;
        Query(int k, int queryStart, int queryEnd, int index) {
            this.k = k;
            this.queryStart = queryStart;
            this.queryEnd = queryEnd;
            this.index = index;
        }
    }

    static final int MAX_N = 100005;
    static long[] segmentTree = new long[MAX_N * 4];
    static long[] results = new long[MAX_N];

    static void update(int node, int start, int end, int value, int index) {
        if (end < index || index < start) return;
        segmentTree[node] += value;
        if (start == end) return;
        int mid = (start + end) / 2;
        update(2 * node, start, mid, value, index);
        update(2 * node + 1, mid + 1, end, value, index);
    }

    static long query(int node, int start, int end, int queryStart, int queryEnd) {
        if (end < queryStart || queryEnd < start) return 0;
        if (queryStart <= start && end <= queryEnd) return segmentTree[node];
        int mid = (start + end) / 2;
        return query(2 * node, start, mid, queryStart, queryEnd) + 
               query(2 * node + 1, mid + 1, end, queryStart, queryEnd);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        
        for (int i = 1; i <= n; i++) {
            int value = scanner.nextInt();
            update(1, 0, MAX_N, value, i);
        }

        List<int[]> updates = new ArrayList<>();
        List<Query> queries = new ArrayList<>();
        int queryCounter = 0;

        int q = scanner.nextInt();
        for (int i = 0; i < q; i++) {
            int command = scanner.nextInt();
            if (command == 1) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                updates.add(new int[] { x, y });
            } else {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                int z = scanner.nextInt();
                queries.add(new Query(x, y, z, queryCounter++));
            }
        }

        queries.sort(Comparator.comparingInt(o -> o.k));

        int updateIndex = 0;
        for (int i = 0; i < updates.size(); i++) {
            while (updateIndex < queries.size() && queries.get(updateIndex).k == i) {
                Query query = queries.get(updateIndex);
                results[query.index] = query(1, 0, MAX_N, query.queryStart, query.queryEnd);
                updateIndex++;
            }
            int idx = updates.get(i)[0];
            int newValue = updates.get(i)[1] - (int) query(1, 0, MAX_N, idx, idx);
            update(1, 0, MAX_N, newValue, idx);
        }

        while (updateIndex < queries.size()) {
            Query query = queries.get(updateIndex);
            results[query.index] = query(1, 0, MAX_N, query.queryStart, query.queryEnd);
            updateIndex++;
        }

        for (int i = 0; i < queryCounter; i++) {
            System.out.println(results[i]);
        }
    }
}