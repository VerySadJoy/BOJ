//Question No: 7869
//Title: 두 원
//Tier: Gold II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        double x1 = Double.parseDouble(tokenizer.nextToken());
        double y1 = Double.parseDouble(tokenizer.nextToken());
        double r1 = Double.parseDouble(tokenizer.nextToken());
        double x2 = Double.parseDouble(tokenizer.nextToken());
        double y2 = Double.parseDouble(tokenizer.nextToken());
        double r2 = Double.parseDouble(tokenizer.nextToken());

        double distance = calculateDistance(x1, y1, x2, y2);
        double intersectionArea = 0;

        if (Math.abs(r1 - r2) >= distance) {
            intersectionArea = Math.PI * Math.pow(Math.min(r1, r2), 2);
        } else if (r1 + r2 > distance) {
            double theta1 = Math.acos((r1 * r1 + distance * distance - r2 * r2) / (2 * r1 * distance));
            double theta2 = Math.acos((r2 * r2 + distance * distance - r1 * r1) / (2 * r2 * distance));

            double segment1 = (r1 * r1 * theta1) - (r1 * r1 * Math.sin(2 * theta1) / 2);
            double segment2 = (r2 * r2 * theta2) - (r2 * r2 * Math.sin(2 * theta2) / 2);
            intersectionArea = segment1 + segment2;
        }

        System.out.printf("%.3f%n", intersectionArea);
    }

    static double calculateDistance(double x1, double y1, double x2, double y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}