//Question No: 15916
//Title: 가희는 그래플러야!!
//Tier: Silver I
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numPoints = Integer.parseInt(reader.readLine());
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        long[] heights = new long[numPoints + 1];
        for (int i = 1; i <= numPoints; i++) {
            heights[i] = Long.parseLong(tokenizer.nextToken());
        }
        long slope = Long.parseLong(reader.readLine());

        String result = "F";
        if (heights[1] == slope) {
            result = "T";
        } else {
            for (int i = 2; i <= numPoints; i++) {
                if (doLinesIntersect(i - 1, slope * (i - 1), i, slope * i, i - 1, heights[i - 1], i, heights[i])) {
                    result = "T";
                    break;
                }
            }
        }

        writer.write(result);
        writer.flush();
        reader.close();
        writer.close();
    }

    public static long ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long value = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (value < 0) return -1;
        else if (value > 0) return 1;
        else return 0;
    }

    public static boolean doLinesIntersect(long x1, long y1, long x2, long y2, long x3, long y3, long x4, long y4) {
        return ccw(x1, y1, x2, y2, x3, y3) * ccw(x1, y1, x2, y2, x4, y4) <= 0 &&
               ccw(x3, y3, x4, y4, x1, y1) * ccw(x3, y3, x4, y4, x2, y2) <= 0;
    }
}

