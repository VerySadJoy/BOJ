//Question No: 10254
//Title: 고속도로
//Tier: Platinum II
import java.io.*;
import java.util.*;

public class Main {
    static final long INF = (long) 2e9;
    static int T, N;
    static long minX, minY, maxD, X1, Y1, X2, Y2;
    static Point center;
    static List<Point> points = new ArrayList<>();
    static List<Point> convexHull = new ArrayList<>();
    static int left, right;

    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static long distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }

    static long ccw(Point a, Point b, Point c) {
        long op = (a.x * b.y + b.x * c.y + c.x * a.y);
        op -= (a.y * b.x + b.y * c.x + c.y * a.x);
        return op;
    }

    static Comparator<Point> comparator(Point base) {
        return (a, b) -> {
            long nowCCW = ccw(base, a, b);
            if (nowCCW > 0) return -1;
            if (nowCCW < 0) return 1;
            if (a.x != b.x) return Long.compare(a.x, b.x);
            return Long.compare(a.y, b.y);
        };
    }

    static void grahamScan() {
        minX = INF;
        minY = INF;
        int first = 0;
        for (int i = 0; i < points.size(); i++) {
            Point p = points.get(i);
            if (minX > p.x || (minX == p.x && minY > p.y)) {
                minX = p.x;
                minY = p.y;
                first = i;
            }
        }
        Collections.swap(points, 0, first);
        points.sort(comparator(points.get(0)));
        for (Point p : points) {
            while (convexHull.size() >= 2 && ccw(convexHull.get(convexHull.size() - 2), convexHull.get(convexHull.size() - 1), p) <= 0) {
                convexHull.remove(convexHull.size() - 1);
            }
            convexHull.add(p);
        }
    }

    static void rotatingCalipers() {
        left = 0;
        right = 0;
        for (int i = 0; i < convexHull.size(); i++) {
            if (convexHull.get(i).x < convexHull.get(left).x) left = i;
            if (convexHull.get(i).x > convexHull.get(right).x) right = i;
        }
        maxD = distance(convexHull.get(left), convexHull.get(right));
        X1 = convexHull.get(left).x;
        Y1 = convexHull.get(left).y;
        X2 = convexHull.get(right).x;
        Y2 = convexHull.get(right).y;

        for (int i = 0; i < convexHull.size(); i++) {
            Point prev = new Point(convexHull.get((left + 1) % convexHull.size()).x - convexHull.get(left).x,
                                   convexHull.get((left + 1) % convexHull.size()).y - convexHull.get(left).y);
            Point next = new Point(convexHull.get(right).x - convexHull.get((right + 1) % convexHull.size()).x,
                                   convexHull.get(right).y - convexHull.get((right + 1) % convexHull.size()).y);
            if (ccw(center, prev, next) > 0) {
                left = (left + 1) % convexHull.size();
            } else {
                right = (right + 1) % convexHull.size();
            }
            if (maxD < distance(convexHull.get(left), convexHull.get(right))) {
                maxD = distance(convexHull.get(left), convexHull.get(right));
                X1 = convexHull.get(left).x;
                Y1 = convexHull.get(left).y;
                X2 = convexHull.get(right).x;
                Y2 = convexHull.get(right).y;
            }
        }
    }

    static void solve() {
        grahamScan();
        rotatingCalipers();
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        T = Integer.parseInt(tokenizer.nextToken());
        while (T-- > 0) {
            points.clear();
            convexHull.clear();
            minX = INF;
            minY = INF;
            center = new Point(0, 0);
            tokenizer = new StringTokenizer(reader.readLine());
            N = Integer.parseInt(tokenizer.nextToken());
            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                long x = Long.parseLong(tokenizer.nextToken());
                long y = Long.parseLong(tokenizer.nextToken());
                points.add(new Point(x, y));
            }
            solve();
            System.out.println(X1 + " " + Y1 + " " + X2 + " " + Y2);
        }
    }
}