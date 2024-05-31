//Question No: 17143
//Title: 용액
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int r, c, s, d, z;

        public Shark(int r, int c, int s, int d, int z) {
            this.r = r;
            this.c = c;
            this.s = s;
            this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;
    static Shark[][] map;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    static void moveSharks() {
        Shark[][] newMap = new Shark[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(newMap[i], null);
        }

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] != null) {
                    Shark shark = map[i][j];
                    int nr = shark.r;
                    int nc = shark.c;
                    for (int k = 0; k < shark.s; k++) {
                        if (nr + dx[shark.d] < 0 || nr + dx[shark.d] >= R) {
                            shark.d = 1 - shark.d;
                        }
                        if (nc + dy[shark.d] < 0 || nc + dy[shark.d] >= C) {
                            shark.d = 5 - shark.d;
                        }
                        nr += dx[shark.d];
                        nc += dy[shark.d];
                    }
                    if (newMap[nr][nc] == null || newMap[nr][nc].z < shark.z) {
                        newMap[nr][nc] = new Shark(nr, nc, shark.s, shark.d, shark.z);
                    }
                }
            }
        }
        map = newMap;
    }

    static int catchShark(int c) {
        for (int r = 0; r < R; r++) {
            if (map[r][c] != null) {
                int size = map[r][c].z;
                map[r][c] = null;
                return size;
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new Shark[R][C];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());
            map[r][c] = new Shark(r, c, s, d, z);
        }

        int ans = 0;
        for (int c = 0; c < C; c++) {
            ans += catchShark(c);
            moveSharks();
        }
        System.out.println(ans);
    }
}
