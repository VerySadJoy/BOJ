//Question No: 3878
//Title: 점 분리
//Tier: Platinum II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static class Point {
        long x, y;
        public Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    static List<Point> setA, setB, hullA, hullB;

    static int ccw(Point a, Point b, Point c){
        long res = a.x*b.y + b.x*c.y + c.x*a.y;
        res -= b.x*a.y + c.x*b.y + a.x*c.y;
        if (res > 0) return 1;
        if (res < 0) return -1;
        return 0;
    }

    static long dist(Point a, Point b){
        long dx = a.x - b.x;
        long dy = a.y - b.y;
        return dx*dx + dy*dy;
    }

    static void initialize() {
        setA = new ArrayList<>();
        setB = new ArrayList<>();
        hullA = new ArrayList<>();
        hullB = new ArrayList<>();
    }

    static void getConvexHull(List<Point> points, List<Point> hull){
        Collections.sort(points, Comparator.comparingLong((Point p) -> p.x).thenComparingLong(p -> p.y));
        Point pivot = points.get(0);
        points.sort((p1, p2) -> {
            int orientation = ccw(pivot, p1, p2);
            if (orientation == 0) {
                return Long.compare(dist(pivot, p1), dist(pivot, p2));
            }
            return -orientation;
        });
        for (Point point : points){
            while (hull.size() >= 2 && ccw(hull.get(hull.size() - 2), hull.get(hull.size() - 1), point) <= 0){
                hull.remove(hull.size() - 1);
            }
            hull.add(point);
        }
    }

    static boolean isPointInPolygon(Point point, List<Point> polygon){
        int crossings = 0;
        for (int i = 0; i < polygon.size(); i++){
            Point p1 = polygon.get(i);
            Point p2 = polygon.get((i + 1) % polygon.size());
            if ((p1.y > point.y) != (p2.y > point.y)){
                double intersectX = (double)(p2.x - p1.x) * (point.y - p1.y) / (p2.y - p1.y) + p1.x;
                if (point.x < intersectX) crossings++;
            }
        }
        return crossings % 2 == 1;
    }

    static boolean areSegmentsDisjoint(long a, long b, long c, long d){
        if (a > b) {
            long temp = a;
            a = b;
            b = temp;
        }
        if (c > d) {
            long temp = c;
            c = d;
            d = temp;
        }
        return b < c || d < a;
    }

    static boolean doSegmentsIntersect(Point a, Point b, Point c, Point d){
        int ab = ccw(a, b, c) * ccw(a, b, d);
        int cd = ccw(c, d, a) * ccw(c, d, b);
        if (ab == 0 && cd == 0){
            return !areSegmentsDisjoint(a.x, b.x, c.x, d.x) && !areSegmentsDisjoint(a.y, b.y, c.y, d.y);
        }
        return ab <= 0 && cd <= 0;
    }

    static void solve(BufferedReader br) throws IOException {
        initialize();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        setA = new ArrayList<>();
        setB = new ArrayList<>();
        
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            setA.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }
        
        for (int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            setB.add(new Point(Long.parseLong(st.nextToken()), Long.parseLong(st.nextToken())));
        }

        getConvexHull(setA, hullA);
        getConvexHull(setB, hullB);

        boolean intersect = false;

        if (isPointInPolygon(hullA.get(0), hullB) || isPointInPolygon(hullB.get(0), hullA)){
            intersect = true;
        }

        for (Point point : hullA){
            if (isPointInPolygon(point, hullB)){
                intersect = true;
                break;
            }
        }
        for (Point point : hullB){
            if (isPointInPolygon(point, hullA)){
                intersect = true;
                break;
            }
        }

        int hullASize = hullA.size();
        int hullBSize = hullB.size();
        for (int i = 0; i < hullASize; i++){
            for (int j = 0; j < hullBSize; j++){
                if (doSegmentsIntersect(hullA.get(i), hullA.get((i + 1) % hullASize), hullB.get(j), hullB.get((j + 1) % hullBSize))){
                    intersect = true;
                    break;
                }
            }
        }

        if (intersect) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            solve(br);
        }
    }
}
