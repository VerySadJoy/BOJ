//Question No: 9063
//Title: 대지
//Tier: Bronze III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int pointCount = Integer.parseInt(reader.readLine());
        int[] xCoordinates = new int[pointCount];
        int[] yCoordinates = new int[pointCount];

        for (int i = 0; i < pointCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            xCoordinates[i] = Integer.parseInt(tokenizer.nextToken());
            yCoordinates[i] = Integer.parseInt(tokenizer.nextToken());
        }

        Arrays.sort(xCoordinates);
        Arrays.sort(yCoordinates);

        int area = (xCoordinates[pointCount - 1] - xCoordinates[0]) * (yCoordinates[pointCount - 1] - yCoordinates[0]);
        System.out.println(area);
    }
}