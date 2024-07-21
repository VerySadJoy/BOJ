//Question No: 2912
//Title: 백설공주와 난쟁이
//Tier: Platinum II
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class Dwarf {
    int color;
    int count;

    public Dwarf(int color, int count) {
        this.color = color;
        this.count = count;
    }
}

public class Main {
    static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringTokenizer tokenizer;
    static int totalDwarfs;
    static int treeSize;
    static int[] dwarfColors;
    static Dwarf[] segmentTree;
    static int maxColor;
    static int[][] colorCounts;
    static int[] colorCountArray;
    static int queries;

    public static void main(String[] args) throws Exception {
        reader = new BufferedReader(new FileReader("in"));
        tokenizer = new StringTokenizer(reader.readLine());
        totalDwarfs = Integer.parseInt(tokenizer.nextToken());
        maxColor = Integer.parseInt(tokenizer.nextToken());
        dwarfColors = new int[totalDwarfs + 1];
        colorCountArray = new int[maxColor + 1];
        colorCounts = new int[maxColor + 1][];
        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 1; i <= totalDwarfs; i++) {
            dwarfColors[i] = Integer.parseInt(tokenizer.nextToken());
            colorCountArray[dwarfColors[i]]++;
        }

        for (int i = 1; i <= maxColor; i++) {
            colorCounts[i] = new int[colorCountArray[i]];
            colorCountArray[i] = 0;
        }

        for (int i = 1; i <= totalDwarfs; i++) {
            int index = colorCountArray[dwarfColors[i]];
            colorCounts[dwarfColors[i]][index] = i;
            colorCountArray[dwarfColors[i]]++;
        }

        treeSize = 1;
        while (totalDwarfs > treeSize) {
            treeSize *= 2;
        }
        segmentTree = new Dwarf[treeSize * 2];
        initializeTree(1, 1, totalDwarfs);

        queries = Integer.parseInt(reader.readLine());
        for (int i = 1; i <= queries; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int left = Integer.parseInt(tokenizer.nextToken());
            int right = Integer.parseInt(tokenizer.nextToken());
            Dwarf result = query(1, 1, totalDwarfs, left, right);
            int range = right - left + 1;
            if (result.count > range / 2) {
                writer.write("yes " + result.color + "\n");
            } else {
                writer.write("no\n");
            }
        }
        writer.close();
    }

    private static Dwarf initializeTree(int node, int left, int right) {
        if (left == right) {
            return segmentTree[node] = new Dwarf(dwarfColors[left], 1);
        }

        int mid = (left + right) / 2;
        Dwarf leftNode = initializeTree(node * 2, left, mid);
        Dwarf rightNode = initializeTree(node * 2 + 1, mid + 1, right);

        if (leftNode.color == rightNode.color) {
            return segmentTree[node] = new Dwarf(leftNode.color, upperBound(leftNode.color, right) - lowerBound(leftNode.color, left));
        }

        int leftCount = upperBound(leftNode.color, right) - lowerBound(leftNode.color, left);
        int rightCount = upperBound(rightNode.color, right) - lowerBound(rightNode.color, left);

        if (leftCount > rightCount) {
            return segmentTree[node] = new Dwarf(leftNode.color, leftCount);
        } else if (leftCount < rightCount) {
            return segmentTree[node] = new Dwarf(rightNode.color, rightCount);
        } else {
            return segmentTree[node] = new Dwarf(0, 0);
        }
    }

    private static int lowerBound(int color, int target) {
        if (color == 0) return 0;
        int left = 0;
        int right = colorCounts[color].length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (colorCounts[color][mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static int upperBound(int color, int target) {
        if (color == 0) return 0;
        int left = 0;
        int right = colorCounts[color].length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (colorCounts[color][mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right;
    }

    private static Dwarf query(int node, int left, int right, int queryLeft, int queryRight) {
        if (queryRight < left || right < queryLeft) {
            return new Dwarf(0, 0);
        }
        if (queryLeft <= left && right <= queryRight) {
            return segmentTree[node];
        }

        int mid = (left + right) / 2;
        Dwarf leftNode = query(node * 2, left, mid, queryLeft, queryRight);
        Dwarf rightNode = query(node * 2 + 1, mid + 1, right, queryLeft, queryRight);

        if (leftNode.color == rightNode.color) {
            return new Dwarf(leftNode.color, upperBound(leftNode.color, queryRight) - lowerBound(leftNode.color, queryLeft));
        }

        int leftCount = upperBound(leftNode.color, queryRight) - lowerBound(leftNode.color, queryLeft);
        int rightCount = upperBound(rightNode.color, queryRight) - lowerBound(rightNode.color, queryLeft);

        if (leftCount > rightCount) {
            return new Dwarf(leftNode.color, leftCount);
        } else if (leftCount < rightCount) {
            return new Dwarf(rightNode.color, rightCount);
        } else {
            return new Dwarf(0, 0);
        }
    }
}
