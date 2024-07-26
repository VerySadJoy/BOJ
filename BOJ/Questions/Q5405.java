//Question No: 5405
//Title: 프랙탈 거리
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    public static class Pair {
        long x, y;
        public Pair(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public static Pair solve(int n, int i) {
        if (n == 1) {
            Pair[] v = {new Pair(1, 1), new Pair(1, 2), new Pair(2, 2), new Pair(2, 1)};
            return v[i - 1];
        } else {
            final long L = 1 << --n, sz = L * L;
            Pair p = solve(n, (i - 1) % (int)sz + 1);
            long x = p.x, y = p.y;
            if (i <= sz) return new Pair(y, x);
            if (i <= 2 * sz) return new Pair(x, y + L);
            if (i <= 3 * sz) return new Pair(x + L, y + L);
            return new Pair(2 * L - y + 1, L - x + 1);
        }
    }

    public static long calculateDistance(long x1, long y1, long x2, long y2) {
        double d = Math.sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2)) * 10;
        return (long)(d + 0.5);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            Pair p1 = solve(n, a);
            Pair p2 = solve(n, b);
            System.out.println(calculateDistance(p1.x, p1.y, p2.x, p2.y));
        }
    }
}