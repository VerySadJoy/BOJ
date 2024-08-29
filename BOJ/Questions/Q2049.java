//Question No: 2049
//Title: 가장 먼 두 점
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
        long ax = A.x, ay = A.y, bx = B.x, by = B.y, cx = C.x, cy = C.y;
        long ccwValue = ax * (by - cy) + bx * (cy - ay) + cx * (ay - by);
        return Long.compare(ccwValue, 0);
    }

    static long distance(Point A, Point B) {
        return (A.x - B.x) * (A.x - B.x) + (A.y - B.y) * (A.y - B.y);
    }

    static Comparator<Point> yComparator = (A, B) -> {
        if (A.y != B.y) return Long.compare(A.y, B.y);
        return Long.compare(A.x, B.x);
    };

    static Point lowestPoint;

    static Comparator<Point> pointComparator = (A, B) -> {
        int ccwResult = (int) ccw(lowestPoint, A, B);
        if (ccwResult > 0) return -1;
        if (ccwResult == 0) return Long.compare(distance(lowestPoint, A), distance(lowestPoint, B));
        return 1;
    };

    static List<Point> makeConvexHull(List<Point> points) {
        Collections.sort(points, yComparator);
        lowestPoint = points.get(0);
        Collections.sort(points.subList(1, points.size()), pointComparator);

        List<Point> stack = new ArrayList<>();
        stack.add(points.get(0));
        stack.add(points.get(1));

        for (int i = 2; i < points.size(); i++) {
            while (stack.size() >= 2 && ccw(points.get(i), stack.get(stack.size() - 2), stack.get(stack.size() - 1)) <= 0) {
                stack.remove(stack.size() - 1);
            }
            stack.add(points.get(i));
        }

        return stack;
    }

    static long rotatingCalipers(List<Point> convexHull) {
        long maxDistance = 0;
        int j = 0;
        int hullSize = convexHull.size();

        for (int i = 0; i < hullSize; i++) {
            int nextI = (i + 1) % hullSize;
            while (true) {
                maxDistance = Math.max(maxDistance, distance(convexHull.get(i), convexHull.get(j)));
                int nextJ = (j + 1) % hullSize;

                Point vector1 = new Point(convexHull.get(i).x - convexHull.get(nextI).x, convexHull.get(i).y - convexHull.get(nextI).y);
                Point vector2 = new Point(convexHull.get(j).x - convexHull.get(nextJ).x, convexHull.get(j).y - convexHull.get(nextJ).y);

                if (ccw(new Point(0, 0), vector1, vector2) <= 0) break;
                j = nextJ;
            }
            maxDistance = Math.max(maxDistance, distance(convexHull.get(i), convexHull.get(j)));
        }

        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfPoints = scanner.nextInt();
        List<Point> points = new ArrayList<>();

        for (int i = 0; i < numberOfPoints; i++) {
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            points.add(new Point(x, y));
        }

        List<Point> convexHull = makeConvexHull(points);
        System.out.println(rotatingCalipers(convexHull));
    }
}