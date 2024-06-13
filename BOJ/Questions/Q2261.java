//Question No: 2261
//Title: 가장 가까운 두 점
//Tier: Platinum II
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int pointCount = Integer.parseInt(reader.readLine());
        ArrayList<Point> points = new ArrayList<>();
        for (int i = 0; i < pointCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(tokenizer.nextToken());
            int y = Integer.parseInt(tokenizer.nextToken());
            points.add(new Point(x, y));
        }
        Collections.sort(points, (p1, p2) -> Integer.compare(p1.x, p2.x));

        writer.write(closestPairDistance(points, 0, pointCount - 1) + "\n");
        writer.close();
        reader.close();
    }

    private static int calculateDistance(Point p1, Point p2) {
        int dx = p1.x - p2.x;
        int dy = p1.y - p2.y;
        return dx * dx + dy * dy;
    }

    private static int bruteForceClosestPair(ArrayList<Point> points, int start, int end) {
        int minDistance = Integer.MAX_VALUE;
        for (int i = start; i < end; i++) {
            for (int j = i + 1; j <= end; j++) {
                int distance = calculateDistance(points.get(i), points.get(j));
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }

    private static int closestPairDistance(ArrayList<Point> points, int start, int end) {
        int numPoints = end - start + 1;
        if (numPoints <= 3) {
            return bruteForceClosestPair(points, start, end);
        }

        int mid = (start + end) / 2;
        int leftDistance = closestPairDistance(points, start, mid);
        int rightDistance = closestPairDistance(points, mid + 1, end);
        int minDistance = Math.min(leftDistance, rightDistance);

        ArrayList<Point> band = new ArrayList<>();
        int midX = points.get(mid).x;
        for (int i = start; i <= end; i++) {
            if ((points.get(i).x - midX) * (points.get(i).x - midX) < minDistance) {
                band.add(points.get(i));
            }
        }
        Collections.sort(band, (p1, p2) -> Integer.compare(p1.y, p2.y));

        for (int i = 0; i < band.size() - 1; i++) {
            for (int j = i + 1; j < band.size(); j++) {
                if ((band.get(j).y - band.get(i).y) * (band.get(j).y - band.get(i).y) >= minDistance) {
                    break;
                }
                int distance = calculateDistance(band.get(i), band.get(j));
                minDistance = Math.min(minDistance, distance);
            }
        }
        return minDistance;
    }
}
