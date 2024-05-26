//Question No: 16724
//Title: 피리 부는 사나이
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static char[][] Map;
    static int[][] visit;
    static final char[] direction = {'L', 'R', 'U', 'D'};
    static final int[] dx = {0, 0, -1, 1};
    static final int[] dy = {-1, 1, 0, 0};
    static int answer = 0;

    static void move(int x, int y, int idx) {
        if (visit[x][y] != -1) {
            if (visit[x][y] == idx) {
                answer++;
            }
            return;
        }

        visit[x][y] = idx;
        int i = new String(direction).indexOf(Map[x][y]);
        move(x + dx[i], y + dy[i], idx);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        Map = new char[N][M];
        visit = new int[N][M];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                Map[i][j] = line.charAt(j);
                visit[i][j] = -1;
            }
        }

        int idx = 0;
        for (int n = 0; n < N; n++) {
            for (int m = 0; m < M; m++) {
                move(n, m, idx++);
            }
        }

        System.out.println(answer);
    }
}

