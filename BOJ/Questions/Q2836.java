//Question No: 2836
//Title: 수상 택시
//Tier: Gold III
import java.io.*;
import java.util.*;

class Taxi implements Comparable<Taxi> {
    long start;
    long end;

    public Taxi(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    public int compareTo(Taxi other) {
        if (this.end == other.end) {
            return Long.compare(this.start, other.start);
        } else {
            return Long.compare(this.end, other.end);
        }
    }
}

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());

        long numPassengers = Long.parseLong(tokenizer.nextToken());
        long baseDistance = Long.parseLong(tokenizer.nextToken());
        long totalDistance = baseDistance;

        List<Taxi> reverseTaxis = new ArrayList<>();

        for (int i = 0; i < numPassengers; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            long start = Long.parseLong(tokenizer.nextToken());
            long end = Long.parseLong(tokenizer.nextToken());

            if (start > end) {
                reverseTaxis.add(new Taxi(start, end));
            }
        }

        if (reverseTaxis.isEmpty()) {
            System.out.println(totalDistance);
            return;
        }

        Collections.sort(reverseTaxis);

        long minEnd = reverseTaxis.get(0).end;
        long maxStart = reverseTaxis.get(0).start;

        for (int i = 1; i < reverseTaxis.size(); i++) {
            long nextEnd = reverseTaxis.get(i).end;
            long nextStart = reverseTaxis.get(i).start;

            if (nextEnd <= maxStart) {
                maxStart = Math.max(maxStart, nextStart);
            } else {
                totalDistance += 2 * (maxStart - minEnd);
                minEnd = nextEnd;
                maxStart = nextStart;
            }
        }

        totalDistance += 2 * (maxStart - minEnd);

        System.out.println(totalDistance);
    }
}