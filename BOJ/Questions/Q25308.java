//Question No: 25308
//Title: 방사형 그래프
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static final int TYPES = 8;
    private static final int[] status = new int[TYPES];
    private static final int[] sequence = new int[TYPES];
    private static final boolean[] checked = new boolean[TYPES];
    private static int count = 0;

    private static void input() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < TYPES; i++) {
            status[i] = Integer.parseInt(tokenizer.nextToken());
        }
        sequence[0] = status[0];
        checked[0] = true;
    }

    private static void backtracking(int depth) {
        if (depth == TYPES) {
            if (isConvex(0) && isConvex(1)) count++;
            return;
        }
        for (int i = 1; i < TYPES; i++) {
            if (checked[i]) continue;
            sequence[depth] = status[i];
            if (depth < 2 || isConvex(depth)) {
                checked[i] = true;
                backtracking(depth + 1);
                checked[i] = false;
            }
        }
    }

    private static boolean isConvex(int current) {
        int before = (current + TYPES - 2) % TYPES;
        int middle = (current + TYPES - 1) % TYPES;
        int next = current % TYPES;
        double line = Math.sqrt(2) * sequence[before] * sequence[next] / (sequence[before] + sequence[next]);
        return sequence[middle] > line;
    }

    public static void main(String[] args) throws IOException {
        input();
        backtracking(1);
        System.out.println(count * TYPES);
    }
}