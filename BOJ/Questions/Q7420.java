//Question No: 7420
//Title: 맹독 방벽
//Tier: Platinum IV
import java.util.*;

public class Main {
    static class Point {
        double x, y;
        Point(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    static int N;
    static double L;
    static Point startPoint;
    static List<Point> points = new ArrayList<>();
    static Stack<Point> stack = new Stack<>();

    static double calculateCCW(Point A, Point B, Point C) {
        double result = (A.x * B.y) + (B.x * C.y) + (C.x * A.y);
        result -= (A.x * C.y) + (B.x * A.y) + (C.x * B.y);
        if (result > 0) return 1;
        if (result < 0) return -1;
        return 0;
    }

    static boolean compareY(Point A, Point B) {
        if (A.y != B.y) return A.y < B.y;
        return A.x < B.x;
    }

    static boolean compareAngle(Point A, Point B) {
        double dir = calculateCCW(startPoint, A, B);
        if (dir != 0) return dir > 0;
        return compareY(A, B);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        L = sc.nextDouble();

        for (int i = 0; i < N; i++) {
            double x = sc.nextDouble();
            double y = sc.nextDouble();
            points.add(new Point(x, y));
        }

        points.sort((a, b) -> compareY(a, b) ? -1 : 1);
        startPoint = points.get(0);
        points.subList(1, points.size()).sort((a, b) -> compareAngle(a, b) ? -1 : 1);

        stack.push(startPoint);
        stack.push(points.get(1));

        for (int i = 2; i < N; i++) {
            Point p3 = points.get(i);
            while (stack.size() > 1) {
                Point p2 = stack.pop();
                Point p1 = stack.peek();
                if (calculateCCW(p1, p2, p3) > 0) {
                    stack.push(p2);
                    break;
                }
            }
            stack.push(p3);
        }

        stack.push(startPoint);

        double perimeter = 2.0 * L * Math.PI;
        Point P1, P2;

        while (!stack.isEmpty()) {
            P1 = stack.pop();
            if (stack.isEmpty()) break;
            P2 = stack.peek();

            double dx = Math.abs(P1.x - P2.x);
            double dy = Math.abs(P1.y - P2.y);
            perimeter += Math.sqrt(dx * dx + dy * dy);
        }

        System.out.println(Math.round(perimeter));
    }
}