//Question No: 7626
//Title: 직사각형
//Tier: Platinum I
import java.io.*;
import java.util.*;

class Segment {
    int x;
    Pair y;
    boolean isStart;

    public Segment(int x, Pair y, boolean isStart) {
        this.x = x;
        this.y = y;
        this.isStart = isStart;
    }
}

class Pair {
    int first, second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

public class Main {
    static final int MAX_SIZE = 400001;
    static long[] segmentTree = new long[MAX_SIZE * 4];
    static long[] countTree = new long[MAX_SIZE * 4];
    static List<Segment> segments = new ArrayList<>();
    static List<Integer> yCoordinates = new ArrayList<>();
    static int rectangleCount;

    static void updateRange(int node, int start, int end, int left, int right, int value) {
        if (left > end || right < start) return;

        if (left <= start && end <= right) {
            countTree[node] += value;
        } else {
            int mid = (start + end) / 2;
            updateRange(node * 2, start, mid, left, right, value);
            updateRange(node * 2 + 1, mid + 1, end, left, right, value);
        }

        if (countTree[node] > 0) {
            segmentTree[node] = yCoordinates.get(end) - yCoordinates.get(start - 1);
        } else {
            if (start == end) {
                segmentTree[node] = 0;
            } else {
                segmentTree[node] = segmentTree[node * 2] + segmentTree[node * 2 + 1];
            }
        }
    }

    static long calculateArea() {
        long totalArea = 0;
        for (int i = 0; i < segments.size(); i++) {
            if (i > 0) {
                int diffX = segments.get(i).x - segments.get(i - 1).x;
                totalArea += segmentTree[1] * diffX;
            }

            int value = segments.get(i).isStart ? 1 : -1;
            int y1Index = Collections.binarySearch(yCoordinates, segments.get(i).y.first);
            int y2Index = Collections.binarySearch(yCoordinates, segments.get(i).y.second);

            updateRange(1, 1, yCoordinates.size(), y1Index + 1, y2Index, value);
        }

        return totalArea;
    }

    static Segment createSegment(int x, int y1, int y2, boolean isStart) {
        return new Segment(x, new Pair(y1, y2), isStart);
    }

    static void initialize(BufferedReader reader) throws IOException {
        rectangleCount = Integer.parseInt(reader.readLine());

        for (int i = 0; i < rectangleCount; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int x1 = Integer.parseInt(tokenizer.nextToken());
            int x2 = Integer.parseInt(tokenizer.nextToken());
            int y1 = Integer.parseInt(tokenizer.nextToken());
            int y2 = Integer.parseInt(tokenizer.nextToken());

            segments.add(createSegment(x1, y1 + 1, y2 + 1, true));
            segments.add(createSegment(x2, y1 + 1, y2 + 1, false));
            yCoordinates.add(y1 + 1);
            yCoordinates.add(y2 + 1);
        }

        Collections.sort(yCoordinates);
        yCoordinates = new ArrayList<>(new LinkedHashSet<>(yCoordinates));
        segments.sort(Comparator.comparingInt(a -> a.x));
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        initialize(reader);
        long area = calculateArea();
        System.out.println(area);
    }
}