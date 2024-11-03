//Question No: 24726
//Title: 미적분학 입문하기 2
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    private static final double[][] points = new double[3][];

    private static double rotate(boolean mode) {
        Arrays.sort(points, Comparator.comparing(p -> p[mode ? 0 : 1]));
        return Math.abs(calculateVolume(points[0], points[2], mode)
                        - calculateVolume(points[0], points[1], mode)
                        - calculateVolume(points[1], points[2], mode));
    }

    private static double calculateVolume(double[] p1, double[] p2, boolean mode) {
        int axisX = mode ? 0 : 1;
        int axisY = mode ? 1 : 0;

        if (p1[axisX] == p2[axisX]) return 0;

        double c2 = (Math.pow(p1[axisY] - p2[axisY], 2) / Math.pow(p1[axisX] - p2[axisX], 2)) / 3.0;
        double c1 = (2 * (p1[axisY] - p2[axisY]) * (p1[axisX] * p2[axisY] - p2[axisX] * p1[axisY]) 
                      / Math.pow(p1[axisX] - p2[axisX], 2)) / 2.0;
        double c0 = (Math.pow(p1[axisX] * p2[axisY] - p2[axisX] * p1[axisY], 2) 
                      / Math.pow(p1[axisX] - p2[axisX], 2));

        return Math.PI * (c2 * Math.abs(Math.pow(p1[axisX], 3) - Math.pow(p2[axisX], 3))
                        + c1 * Math.abs(Math.pow(p1[axisX], 2) - Math.pow(p2[axisX], 2))
                        + c0 * Math.abs(p1[axisX] - p2[axisX]));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < 3; i++) {
            points[i] = new double[] {
                Double.parseDouble(tokenizer.nextToken()),
                Double.parseDouble(tokenizer.nextToken())
            };
        }

        System.out.println(rotate(true) + " " + rotate(false));
    }
}