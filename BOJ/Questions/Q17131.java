//Question No: 17131
//Title: 여우가 정보섬에 올라온 이유
//Tier: Platinum IV
import java.util.*;

public class Main {
    static int N;

    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] points = new Point[200000];

    static class SegmentTree {
        int[] nodes = new int[800000];

        void insert(int current, int left, int right, int index, int value) {
            if (left == right) {
                nodes[current] += value;
                return;
            }
            int mid = (left + right) / 2;
            if (index <= mid) insert(current * 2, left, mid, index, value);
            else insert(current * 2 + 1, mid + 1, right, index, value);
            nodes[current] = nodes[current * 2] + nodes[current * 2 + 1];
        }

        long search(int current, int searchLeft, int searchRight, int nodeLeft, int nodeRight) {
            if (searchLeft > nodeRight || searchRight < nodeLeft) return 0;
            if (searchLeft <= nodeLeft && searchRight >= nodeRight) return nodes[current];
            int mid = (nodeLeft + nodeRight) / 2;
            long sum = 0;
            if (searchLeft <= mid) sum += search(current * 2, searchLeft, searchRight, nodeLeft, mid);
            if (searchRight > mid) sum += search(current * 2 + 1, searchLeft, searchRight, mid + 1, nodeRight);
            return sum;
        }
    }

    static SegmentTree tree = new SegmentTree();
    static List<Integer> batchY = new ArrayList<>();

    static void compressCoordinates() {
        Arrays.sort(points, 0, N, Comparator.comparingInt(a -> a.x));
        int previous = Integer.MAX_VALUE;
        int rank = -1;
        for (int i = 0; i < N; i++) {
            if (previous != points[i].x) rank++;
            previous = points[i].x;
            points[i].x = rank;
        }
        Arrays.sort(points, 0, N, (a, b) -> b.y - a.y);
    }

    static long processBatch() {
        long result = 0;
        for (int y : batchY) {
            result = (result + tree.search(1, 0, y - 1, 0, N - 1) * tree.search(1, y + 1, N - 1, 0, N - 1)) % 1000000007;
        }
        for (int y : batchY) {
            tree.insert(1, 0, N - 1, y, 1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            points[i] = new Point(scanner.nextInt(), scanner.nextInt());
        }
        compressCoordinates();
        long result = 0;
        int previousY = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            if (previousY != points[i].y) {
                result = (result + processBatch()) % 1000000007;
                batchY.clear();
                previousY = points[i].y;
            }
            batchY.add(points[i].x);
        }
        result = (result + processBatch()) % 1000000007;
        System.out.println(result);
    }
}