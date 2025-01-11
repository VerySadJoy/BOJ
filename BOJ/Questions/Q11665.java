//Question No: 11665
//Title: 직육면체 교집합
//Tier: Silver V
import java.io.*;
import java.util.*;

public class Main {

    static class Interval {
        int start, end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public static Interval merge(Interval a, Interval b) {
            return new Interval(Math.max(a.start, b.start), Math.min(a.end, b.end));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Interval> xIntervals = new ArrayList<>();
        List<Interval> yIntervals = new ArrayList<>();
        List<Interval> zIntervals = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int z1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());
            int z2 = Integer.parseInt(tokenizer.nextToken());

            xIntervals.add(new Interval(x1, x2));
            yIntervals.add(new Interval(y1, y2));
            zIntervals.add(new Interval(z1, z2));
        }

        Interval x = new Interval((int) -2e9, (int) 2e9);
        Interval y = new Interval((int) -2e9, (int) 2e9);
        Interval z = new Interval((int) -2e9, (int) 2e9);

        for (int i = 0; i < n; i++) {
            x = Interval.merge(x, xIntervals.get(i));
            y = Interval.merge(y, yIntervals.get(i));
            z = Interval.merge(z, zIntervals.get(i));
        }

        int volume = Math.max(0, x.end - x.start) * Math.max(0, y.end - y.start) * Math.max(0, z.end - z.start);
        System.out.println(volume);
    }
}