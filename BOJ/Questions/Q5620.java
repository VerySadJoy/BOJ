//Question No: 5620
//Title: 가장 가까운 두 점의 거리
//Tier: Platinum II
import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int pointCount = Integer.parseInt(reader.readLine());
        Point[] pointsArray = new Point[pointCount];
        for (int i = 0; i < pointCount; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int xCoordinate = Integer.parseInt(tokenizer.nextToken());
            int yCoordinate = Integer.parseInt(tokenizer.nextToken());

            pointsArray[i] = new Point(xCoordinate, yCoordinate);
        }
        Arrays.sort(pointsArray, (point1, point2) -> point1.x - point2.x);

        TreeSet<Point> pointSet = new TreeSet<>((point1, point2) -> 
            (point1.y == point2.y) ? point1.x - point2.x : point1.y - point2.y);

        pointSet.add(pointsArray[0]);
        pointSet.add(pointsArray[1]);

        int minimumDistance = calculateDistance(pointsArray[0], pointsArray[1]);
        int startIndex = 0;

        for (int i = 2; i < pointCount; i++) {
            Point currentPoint = pointsArray[i];

            while (startIndex < i) {
                Point previousPoint = pointsArray[startIndex];
                int distanceDifference = currentPoint.x - previousPoint.x;

                if (distanceDifference * distanceDifference > minimumDistance) {
                    pointSet.remove(previousPoint);
                    startIndex++;
                } else {
                    break;
                }
            }

            int range = (int) Math.sqrt((double) minimumDistance) + 1;
            Point rangeStart = new Point(-100000, currentPoint.y - range);
            Point rangeEnd = new Point(100000, currentPoint.y + range);

            for (Point point : pointSet.subSet(rangeStart, rangeEnd)) {
                minimumDistance = Math.min(minimumDistance, calculateDistance(currentPoint, point));
            }

            pointSet.add(currentPoint);
        }

        writer.write(minimumDistance + "\n");
        writer.close();
        reader.close();
    }

    public static int calculateDistance(Point point1, Point point2) {
        return (point1.x - point2.x) * (point1.x - point2.x) + 
               (point1.y - point2.y) * (point1.y - point2.y);
    }
}