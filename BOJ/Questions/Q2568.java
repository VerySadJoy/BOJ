//Question No: 2568
//Title: 전깃줄 - 2
//Tier: Platinum V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    static class Line implements Comparable<Line> {
        int start, end;

        Line(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Line o) {
            return this.start - o.start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            lines.add(new Line(start, end));
        }

        Collections.sort(lines);

        List<Integer> lis = new ArrayList<>();
        int[] index = new int[n];
        for (int i = 0; i < n; i++) {
            int pos = Collections.binarySearch(lis, lines.get(i).end);
            if (pos < 0) pos = -pos - 1;
            if (pos == lis.size()) {
                lis.add(lines.get(i).end);
            } else {
                lis.set(pos, lines.get(i).end);
            }
            index[i] = pos;
        }

        int len = lis.size();
        System.out.println(n - len);

        List<Integer> result = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            if (index[i] == len - 1) {
                len--;
            } else {
                result.add(lines.get(i).start);
            }
        }

        Collections.sort(result);
        for (int i : result) {
            System.out.println(i);
        }
    }
}
