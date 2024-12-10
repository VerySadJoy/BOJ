//Question No: 1450
//Title: 냅색문제
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    static int capacity;
    static int[] weights;
    static List<Integer> leftSums, rightSums;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int itemCount = Integer.parseInt(tokenizer.nextToken());
        capacity = Integer.parseInt(tokenizer.nextToken());

        weights = new int[itemCount];
        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < itemCount; i++) {
            weights[i] = Integer.parseInt(tokenizer.nextToken());
        }

        leftSums = new ArrayList<>();
        rightSums = new ArrayList<>();
        generateSums(leftSums, 0, itemCount / 2, 0);
        generateSums(rightSums, itemCount / 2, itemCount, 0);
        Collections.sort(rightSums);

        int count = 0;
        for (int i = 0; i < leftSums.size(); i++) {
            int index = upperBound(0, rightSums.size() - 1, leftSums.get(i));
            count += index + 1;
        }
        System.out.println(count);
    }

    static int upperBound(int start, int end, int value) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (rightSums.get(mid) <= capacity - value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return end;
    }

    static void generateSums(List<Integer> list, int start, int end, int sum) {
        if (sum > capacity) return;
        if (start == end) {
            list.add(sum);
            return;
        }
        generateSums(list, start + 1, end, sum);
        generateSums(list, start + 1, end, sum + weights[start]);
    }
}