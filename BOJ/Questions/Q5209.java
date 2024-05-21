//Question No: 5209
//Title: Lecture Screens
//Tier: Platinum III
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static class Point {
        double x, y;

        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }

        double distance(Point other) {
            return Math.hypot(this.x - other.x, this.y - other.y);
        }
    }

    static class Screen {
        Point left, right;

        Screen(Point left, Point right) {
            this.left = left;
            this.right = right;
        }

        double length() {
            return left.distance(right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        for (int k = 1; k <= K; k++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            double x = sc.nextDouble();
            double y = sc.nextDouble();

            List<Point> polygon = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                double xi = sc.nextDouble();
                double yi = sc.nextDouble();
                polygon.add(new Point(xi, yi));
            }

            List<Screen> screens = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                double Lx = sc.nextDouble();
                double Ly = sc.nextDouble();
                double Rx = sc.nextDouble();
                double Ry = sc.nextDouble();
                screens.add(new Screen(new Point(Lx, Ly), new Point(Rx, Ry)));
            }

            double totalVisibleLength = 0;
            double totalLength = 0;

            Point observer = new Point(x, y);

            for (Screen screen : screens) {
                totalLength += screen.length();
                totalVisibleLength += calculateVisibleLength(observer, screen, polygon);
            }

            double visiblePercentage = (totalVisibleLength / totalLength) * 100;
            System.out.printf("Data Set %d:\n%.2f%%\n", k, visiblePercentage);
        }

        sc.close();
    }

    private static double calculateVisibleLength(Point observer, Screen screen, List<Point> polygon) {
        if (!isScreenFacingObserver(observer, screen)) {
            return 0;
        }

        Line2D screenLine = new Line2D.Double(screen.left.x, screen.left.y, screen.right.x, screen.right.y);
        List<Line2D> edges = new ArrayList<>();

        for (int i = 0; i < polygon.size(); i++) {
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i + 1) % polygon.size());
            edges.add(new Line2D.Double(p1.x, p1.y, p2.x, p2.y));
        }

        double visibleLength = screen.length();
        boolean leftVisible = isPointVisible(observer, screen.left, edges);
        boolean rightVisible = isPointVisible(observer, screen.right, edges);

        if (!leftVisible && !rightVisible) {
            return 0;
        } else if (leftVisible && rightVisible) {
            return visibleLength;
        } else {
            for (Line2D edge : edges) {
                if (screenLine.intersectsLine(edge)) {
                    Point2D.Double intersection = new Point2D.Double();
                    if (findIntersection(screenLine, edge, intersection)) {
                        if (leftVisible) {
                            visibleLength = screen.left.distance(new Point(intersection.getX(), intersection.getY()));
                        } else {
                            visibleLength = screen.right.distance(new Point(intersection.getX(), intersection.getY()));
                        }
                        break;
                    }
                }
            }
        }

        return visibleLength;
    }

    private static boolean isScreenFacingObserver(Point observer, Screen screen) {
        double crossProduct = (screen.right.x - screen.left.x) * (observer.y - screen.left.y) - 
                              (screen.right.y - screen.left.y) * (observer.x - screen.left.x);
        return crossProduct < 0;
    }

    private static boolean isPointVisible(Point observer, Point point, List<Line2D> edges) {
        Line2D ray = new Line2D.Double(observer.x, observer.y, point.x, point.y);
        for (Line2D edge : edges) {
            if (ray.intersectsLine(edge)) {
                return false;
            }
        }
        return true;
    }

    private static boolean findIntersection(Line2D line1, Line2D line2, Point2D.Double intersection) {
        double x1 = line1.getX1(), y1 = line1.getY1(), x2 = line1.getX2(), y2 = line1.getY2();
        double x3 = line2.getX1(), y3 = line2.getY1(), x4 = line2.getX2(), y4 = line2.getY2();

        double denominator = (y4 - y3) * (x2 - x1) - (x4 - x3) * (y2 - y1);
        if (denominator == 0) {
            return false;
        }

        double ua = ((x4 - x3) * (y1 - y3) - (y4 - y3) * (x1 - x3)) / denominator;
        intersection.setLocation(x1 + ua * (x2 - x1), y1 + ua * (y2 - y1));
        return true;
    }
}
