//Question No: 4225
//Title: 쓰레기 슈트
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static class Point implements Comparable<Point> {
        double x, y, angle;

        Point(double a, double b) {
            x = a;
            y = b;
        }

        @Override
        public int compareTo(Point o) {
            int comp = Double.compare(o.angle, this.angle);
            if (comp != 0) return comp;
            return Double.compare(distance(root, o), distance(root, this));
        }
    }

    static Point root;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder output = new StringBuilder();
        StringTokenizer tokenizer;
        int N, testCase = 0;

        while ((N = Integer.parseInt(reader.readLine())) != 0) {
            testCase++;
            root = new Point(0, 10000);
            Point[] points = new Point[N];

            for (int i = 0; i < N; i++) {
                tokenizer = new StringTokenizer(reader.readLine());
                int x = Integer.parseInt(tokenizer.nextToken());
                int y = Integer.parseInt(tokenizer.nextToken());
                points[i] = new Point(x, y);
                if (points[i].y <= root.y) root = points[i];
            }

            for (int i = 0; i < N; i++) points[i].angle = calculateAngle(points[i]);
            Arrays.sort(points);

            Stack<Point> stack = new Stack<>();
            stack.push(points[0]);
            stack.push(points[1]);

            for (int i = 2; i < N; i++) {
                Point second = stack.pop(), first = stack.peek(), next = points[i];
                if (ccw(first, second, next) < 0) i--;
                else {
                    stack.push(second);
                    stack.push(next);
                }
            }

            int size = stack.size();
            Point[] hull = new Point[size];
            for (int i = 0; i < size; i++) hull[i] = stack.pop();

            double minDistance = 10000;
            for (int i = 0, len = hull.length; i < len; i++) {
                int line1 = i, line2 = (i + 1) % len;
                double maxDistance = 0;
                for (int cur = 0; cur < len; cur++) {
                    if (cur != line1 && cur != line2) {
                        maxDistance = Math.max(maxDistance, distance(hull[cur], hull[line1], hull[line2]));
                    }
                }
                minDistance = Math.min(minDistance, maxDistance);
            }

            output.append("Case ").append(testCase).append(": ");
            output.append(String.format("%.2f", Math.ceil(minDistance * 100) / 100)).append("\n");
        }

        System.out.print(output);
    }

    static double calculateAngle(Point p) {
        if (root.x == p.x && root.y == p.y) return 7;
        double p12 = Math.pow(root.x + 1, 2);
        double p23 = Math.pow(root.x - p.x, 2) + Math.pow(root.y - p.y, 2);
        double p31 = Math.pow(p.x + 1, 2) + Math.pow(p.y - root.y, 2);
        return Math.acos((p12 + p23 - p31) / (2 * Math.sqrt(p12) * Math.sqrt(p23)));
    }

    static int ccw(Point a, Point b, Point c) {
        double result = (a.x * b.y + b.x * c.y + c.x * a.y) - (a.x * c.y + c.x * b.y + b.x * a.y);
        return result < 0 ? -1 : 1;
    }

    static double distance(Point a, Point l1, Point l2) {
        double X, Y, dx = l1.x - l2.x, dy = l1.y - l2.y;
        if (dx == 0) {
            X = l1.x;
            Y = a.y;
        } else if (dy == 0) {
            X = a.x;
            Y = l1.y;
        } else {
            X = (dx / dy * a.x + dy / dx * l1.x + a.y - l1.y) / (dx / dy + dy / dx);
            Y = dy / dx * (X - l1.x) + l1.y;
        }
        return distance(a, new Point(X, Y));
    }

    static double distance(Point a, Point b) {
        return Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }
}
