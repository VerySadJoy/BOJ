//Question No: 1310
//Title: 달리기 코스
//Tier: Platinum III
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    static class Point {
        long x, y;

        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static long ccw(Point A, Point B, Point C) {
        return (A.x * (B.y - C.y)) + (B.x * (C.y - A.y)) + (C.x * (A.y - B.y));
    }

    static long distance(Point A, Point B) {
        return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
    }

    static Comparator<Point> yComparator = (A, B) -> {
        if (A.y != B.y) return Long.compare(A.y, B.y);
        return Long.compare(A.x, B.x);
    };

    static Point lowestPoint;

    static Comparator<Point> polarComparator = (A, B) -> {
        long result = ccw(lowestPoint, A, B);
        if (result > 0) return -1;
        if (result == 0) return Long.compare(distance(lowestPoint, A), distance(lowestPoint, B));
        return 1;
    };

    static List<Point> makeConvexHull(List<Point> points) {
        Collections.sort(points, yComparator);
        lowestPoint = points.get(0);
        Collections.sort(points.subList(1, points.size()), polarComparator);

        List<Point> stack = new ArrayList<>();
        stack.add(points.get(0));
        stack.add(points.get(1));

        for (int i = 2; i < points.size(); i++) {
            while (stack.size() >= 2) {
                Point a = stack.get(stack.size() - 1);
                Point b = stack.get(stack.size() - 2);
                if (ccw(b, a, points.get(i)) <= 0) {
                    stack.remove(stack.size() - 1);
                } else {
                    break;
                }
            }
            stack.add(points.get(i));
        }

        return stack;
    }

    static long rotatingCalipers(List<Point> hull) {
        long maxDistance = 0;
        int j = 1;

        for (int i = 0; i < hull.size(); i++) {
            int nextI = (i + 1) % hull.size();
            while (true) {
                int nextJ = (j + 1) % hull.size();
                long distance = distance(hull.get(i), hull.get(j));
                maxDistance = Math.max(maxDistance, distance);

                Point vectorI = new Point(hull.get(nextI).x - hull.get(i).x, hull.get(nextI).y - hull.get(i).y);
                Point vectorJ = new Point(hull.get(nextJ).x - hull.get(j).x, hull.get(nextJ).y - hull.get(j).y);

                if (ccw(new Point(0, 0), vectorI, vectorJ) <= 0) break;
                j = nextJ;
            }
            maxDistance = Math.max(maxDistance, distance(hull.get(i), hull.get(j)));
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            long a = scanner.nextLong();
            long b = scanner.nextLong();
            points.add(new Point(a, b));
        }

        List<Point> convexHull = makeConvexHull(points);
        System.out.println(rotatingCalipers(convexHull));
    }
}