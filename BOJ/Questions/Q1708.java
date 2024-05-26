//Question No: 1708
//Title: 볼록 껍질
//Tier: Platinum V
import java.util.*;

class Point implements Comparable<Point> {
    long x, y;

    Point(long a, long b) {
        x = a;
        y = b;
    }

    Point() {}

    @Override
    public int compareTo(Point rhs) {
        if (x != rhs.x) return Long.compare(x, rhs.x);
        return Long.compare(y, rhs.y);
    }
}

public class Main {

    static List<Point> points = new ArrayList<>();

    static long ccw(Point pt1, Point pt2, Point pt3) {
        long ret = pt1.x * pt2.y + pt2.x * pt3.y + pt3.x * pt1.y;
        ret -= (pt2.x * pt1.y + pt3.x * pt2.y + pt1.x * pt3.y);
        return ret;
    }

    static long dist(Point pt1, Point pt2) {
        long dx = pt2.x - pt1.x;
        long dy = pt2.y - pt1.y;
        return dx * dx + dy * dy;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        points = new ArrayList<>(N);

        for (int i = 0; i < N; i++) {
            points.add(new Point(sc.nextLong(), sc.nextLong()));
        }

        List<Point> hull = new ArrayList<>();
        Collections.swap(points, 0, points.indexOf(Collections.min(points)));
        points.subList(1, points.size()).sort((x, y) -> {
            long cw = ccw(points.get(0), x, y);
            if (cw == 0) return Long.compare(dist(points.get(0), x), dist(points.get(0), y));
            return Long.compare(cw, 0);
        });

        for (Point p : points) {
            while (hull.size() >= 2 && ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), p) <= 0) {
                hull.remove(hull.size() - 1);
            }
            hull.add(p);
        }

        System.out.println(hull.size());
    }
}
