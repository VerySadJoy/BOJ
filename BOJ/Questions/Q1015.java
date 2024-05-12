//Question No: 1015
//Title: 수열 정렬
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        List<Pair> pairs = new ArrayList<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
            pairs.add(new Pair(A[i], i));
        }

        Collections.sort(pairs);

        for (int i = 0; i < N; i++) {
            pairs.get(i).index = i;
        }

        Collections.sort(pairs, (a, b) -> Integer.compare(a.originalIndex, b.originalIndex));

        for (Pair pair : pairs) {
            bw.write(pair.index + " ");
        }

        bw.flush();
        br.close();
        bw.close();
    }

    static class Pair implements Comparable<Pair> {
        int value;
        int originalIndex;
        int index;

        Pair(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(this.value, other.value);
        }
    }
}
