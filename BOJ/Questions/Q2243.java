//Question No: 2243
//Title: 사탕상자
//Tier: Platinum V
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static final int SIZE = 1_000_001;
    static int[] candyTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        candyTree = new int[SIZE * 4];
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int operation = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());

            if (operation == 1) {
                int candy = query(1, SIZE, 1, a);
                sb.append(candy).append("\n");
            } else {
                int b = Integer.parseInt(st.nextToken());
                update(1, SIZE, 1, a, b);
            }
        }

        System.out.println(sb.toString());
    }

    static int query(int start, int end, int idx, int target) {
        if (start == end) {
            update(1, SIZE, 1, start, -1);
            return start;
        }

        int mid = (start + end) / 2;
        if (target <= candyTree[idx * 2]) {
            return query(start, mid, idx * 2, target);
        } else {
            return query(mid + 1, end, idx * 2 + 1, target - candyTree[idx * 2]);
        }
    }

    static void update(int start, int end, int idx, int target, int diff) {
        if (target < start || end < target) return;

        candyTree[idx] += diff;
        if (start == end) return;

        int mid = (start + end) / 2;
        update(start, mid, idx * 2, target, diff);
        update(mid + 1, end, idx * 2 + 1, target, diff);
    }
}
