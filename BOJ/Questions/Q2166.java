//Question No: 2166
//Title: 다각형의 면적
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numVertices = Integer.parseInt(reader.readLine());
        long[] xCoordinates = new long[numVertices + 1];
        long[] yCoordinates = new long[numVertices + 1];
        long sumA = 0, sumB = 0;

        for (int i = 0; i < numVertices; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            xCoordinates[i] = Long.parseLong(tokenizer.nextToken());
            yCoordinates[i] = Long.parseLong(tokenizer.nextToken());
        }

        xCoordinates[numVertices] = xCoordinates[0];
        yCoordinates[numVertices] = yCoordinates[0];

        for (int i = 0; i < numVertices; i++) {
            sumA += xCoordinates[i] * yCoordinates[i + 1];
            sumB += xCoordinates[i + 1] * yCoordinates[i];
        }

        String area = String.format("%.1f", Math.abs(sumA - sumB) / 2.0);
        writer.write(area);

        reader.close();
        writer.flush();
        writer.close();
    }
}
