//Question No: 9240
//Title: 로버트 후드
//Tier: Platinum III
import java.io.*;
import java.util.*;

class Point {
    long x, y;

    Point(long x, long y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int numPoints = Integer.parseInt(tokenizer.nextToken());
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 0; i < numPoints; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            long x = Long.parseLong(tokenizer.nextToken());
            long y = Long.parseLong(tokenizer.nextToken());
            points.add(new Point(x, y));
        }

        ArrayList<Point> convexHullPoints = new ArrayList<>(convexHull(points));
        writer.write(rotatingCalipers(convexHullPoints) + "\n");

        reader.close();
        writer.flush();
        writer.close();
    }

    static double rotatingCalipers(ArrayList<Point> convexHull) {
        double maxDistance = 0;
        int j = 1;

        for (int i = 0; i < convexHull.size(); i++) {
            int nextI = (i + 1) % convexHull.size();
            while (true) {
                int nextJ = (j + 1) % convexHull.size();

                long vecIx = convexHull.get(nextI).x - convexHull.get(i).x;
                long vecIy = convexHull.get(nextI).y - convexHull.get(i).y;
                long vecJx = convexHull.get(nextJ).x - convexHull.get(j).x;
                long vecJy = convexHull.get(nextJ).y - convexHull.get(j).y;

                long crossProduct = ccw(new Point(0, 0), new Point(vecIx, vecIy), new Point(vecJx, vecJy));
                if (crossProduct > 0) {
                    j = nextJ;
                } else {
                    break;
                }
            }

            double distance = distance(convexHull.get(i), convexHull.get(j));
            if (distance > maxDistance) {
                maxDistance = distance;
            }
        }
        return maxDistance;
    }

    static Point referencePoint = new Point(Long.MAX_VALUE, Long.MAX_VALUE);

    static Stack<Point> convexHull(ArrayList<Point> points) {
        for (Point point : points) {
            if (point.x < referencePoint.x || (point.x == referencePoint.x && point.y < referencePoint.y)) {
                referencePoint = point;
            }
        }

        points.sort((point1, point2) -> {
            long ccwResult = ccw(referencePoint, point1, point2);
            if (ccwResult > 0) {
                return -1;
            } else if (ccwResult < 0) {
                return 1;
            } else {
                double distance1 = distance(referencePoint, point1);
                double distance2 = distance(referencePoint, point2);
                return Double.compare(distance1, distance2);
            }
        });

        Stack<Point> hull = new Stack<>();
        hull.add(referencePoint);

        for (Point point : points) {
            while (hull.size() > 1 && ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) <= 0) {
                hull.pop();
            }
            hull.add(point);
        }

        return hull;
    }

    static long ccw(Point p1, Point p2, Point p3) {
        return (p1.x * p2.y + p2.x * p3.y + p3.x * p1.y) - (p1.y * p2.x + p2.y * p3.x + p3.y * p1.x);
    }

    static double distance(Point p1, Point p2) {
        return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
    }
}
