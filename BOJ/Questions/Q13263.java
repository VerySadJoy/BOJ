//Question No: 13263
//Title: 나무 자르기
//Tier: Platinum II
import java.io.*;
import java.util.*;

class Main {
    static int numberOfTrees;
    static int[] heightOfTrees;
    static int[] costToCutTrees;
    static long[] dp;
    static ArrayList<Line> lineSegments;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        numberOfTrees = Integer.parseInt(reader.readLine());
        heightOfTrees = new int[numberOfTrees];
        costToCutTrees = new int[numberOfTrees];
        dp = new long[numberOfTrees];
        lineSegments = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfTrees; i++) {
            heightOfTrees[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < numberOfTrees; i++) {
            costToCutTrees[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i < numberOfTrees; i++) {
            Line newLine = new Line(costToCutTrees[i - 1], dp[i - 1]);

            while (lineSegments.size() >= 1) {
                newLine.slopeIntersection = calculateIntersection(newLine, lineSegments.get(lineSegments.size() - 1));
                if (newLine.slopeIntersection < lineSegments.get(lineSegments.size() - 1).slopeIntersection) {
                    lineSegments.remove(lineSegments.size() - 1);
                } else break;
            }

            lineSegments.add(newLine);
            long currentHeight = heightOfTrees[i];
            int bestLineIndex = 0;

            int left = 0, right = lineSegments.size() - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                if (lineSegments.get(mid).slopeIntersection < currentHeight) {
                    bestLineIndex = mid;
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            dp[i] = lineSegments.get(bestLineIndex).a * currentHeight + lineSegments.get(bestLineIndex).b;
        }
        System.out.println(dp[numberOfTrees - 1]);
    }

    static class Line {
        long a, b;
        double slopeIntersection;

        Line(long a_, long b_) {
            a = a_;
            b = b_;
            slopeIntersection = 0;
        }
    }

    static double calculateIntersection(Line line1, Line line2) {
        return (double) (line2.b - line1.b) / (line1.a - line2.a);
    }
}