//Question No: 5419
//Title: 북서풍
//Tier: Platinum III
import java.io.*;
import java.util.*;

public class Main {

    static class Coordinate {
        int x, y;

        public Coordinate(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] segmentTree;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer;

        while (testCases-- > 0) {
            int pointCount = Integer.parseInt(reader.readLine());
            List<Coordinate> points = new ArrayList<>();

            for (int i = 0; i < pointCount; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                points.add(new Coordinate(Integer.parseInt(tokenizer.nextToken()), Integer.parseInt(tokenizer.nextToken())));
            }

            points.sort((a, b) -> b.y - a.y);

            int[] rank = new int[pointCount];
            int currentRank = 1;

            for (int i = 0; i < pointCount; i++) {
                if (i > 0 && points.get(i).y != points.get(i - 1).y) {
                    currentRank++;
                }
                rank[i] = currentRank;
            }

            for (int i = 0; i < pointCount; i++) {
                points.get(i).y = rank[i];
            }

            points.sort((a, b) -> a.x == b.x ? a.y - b.y : a.x - b.x);

            segmentTree = new int[4 * pointCount];
            long result = 0;

            for (int i = 0; i < pointCount; i++) {
                result += query(1, pointCount, 1, 1, points.get(i).y);
                update(1, pointCount, 1, points.get(i).y);
            }

            System.out.println(result);
        }
    }

    static void update(int start, int end, int node, int index) {
        if (index < start || index > end) {
            return;
        }

        segmentTree[node] += 1;

        if (start == end) {
            return;
        }

        int mid = (start + end) / 2;
        update(start, mid, node * 2, index);
        update(mid + 1, end, node * 2 + 1, index);
    }

    static int query(int start, int end, int node, int left, int right) {
        if (end < left || start > right) {
            return 0;
        }

        if (left <= start && end <= right) {
            return segmentTree[node];
        }

        int mid = (start + end) / 2;
        return query(start, mid, node * 2, left, right) + query(mid + 1, end, node * 2 + 1, left, right);
    }
}