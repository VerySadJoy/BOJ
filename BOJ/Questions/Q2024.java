//Question No: 2024
//Title: 선분 덮기
//Tier: Gold III
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {

    static List<int[]> segments = new ArrayList<>();
    static int targetLength;
    static int result = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        targetLength = scanner.nextInt();

        while (true) {
            int start = scanner.nextInt();
            int end = scanner.nextInt();

            if (start == 0 && end == 0) break;

            if (start > end) {
                int temp = start;
                start = end;
                end = temp;
            }

            if (end < 0 || start > targetLength || start == end) continue;

            segments.add(new int[]{start, end});
        }

        Collections.sort(segments, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return Integer.compare(a[1], b[1]);
                }
                return Integer.compare(a[0], b[0]);
            }
        });

        int currentPosition = 0;
        int index = 0;

        while (true) {
            int maxEnd = -1;

            for (; index < segments.size(); index++) {
                if (segments.get(index)[0] <= currentPosition) {
                    if (segments.get(index)[1] > maxEnd) {
                        maxEnd = segments.get(index)[1];
                    }
                } else {
                    break;
                }
            }

            if (maxEnd == -1) {
                System.out.println(0);
                break;
            }

            result++;

            if (maxEnd >= targetLength) {
                System.out.println(result);
                break;
            }

            currentPosition = maxEnd;
        }

        scanner.close();
    }
}