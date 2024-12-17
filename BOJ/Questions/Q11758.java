//Question No: 11758
//Title: CCW
//Tier: Gold V
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        tokenizer = new StringTokenizer(reader.readLine());
        int x1 = Integer.parseInt(tokenizer.nextToken());
        int y1 = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int x2 = Integer.parseInt(tokenizer.nextToken());
        int y2 = Integer.parseInt(tokenizer.nextToken());

        tokenizer = new StringTokenizer(reader.readLine());
        int x3 = Integer.parseInt(tokenizer.nextToken());
        int y3 = Integer.parseInt(tokenizer.nextToken());

        writer.write(ccw(x1, y1, x2, y2, x3, y3) + "\n");
        writer.flush();
        writer.close();
        reader.close();
    }

    public static int ccw(int x1, int y1, int x2, int y2, int x3, int y3) {
        int a = x1 * y2 + x2 * y3 + x3 * y1;
        int b = y1 * x2 + y2 * x3 + y3 * x1;

        if (a - b > 0) {
            return 1;
        } else if (a == b) {
            return 0;
        } else {
            return -1;
        }
    }
}