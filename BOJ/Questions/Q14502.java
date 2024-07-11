//Question No: 14502
//Title: 연구소
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] lab;
    static List<int[]> emptySpaces = new ArrayList<>();
    static List<int[]> virusPositions = new ArrayList<>();
    static List<Integer> safeAreas = new ArrayList<>();
    static int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lab = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                lab[i][j] = Integer.parseInt(st.nextToken());
                if (lab[i][j] == 0) {
                    emptySpaces.add(new int[]{i, j});
                } else if (lab[i][j] == 2) {
                    virusPositions.add(new int[]{i, j});
                }
            }
        }

        int maxSafeArea = 0;
        for (int i = 0; i < emptySpaces.size(); i++) {
            for (int j = i + 1; j < emptySpaces.size(); j++) {
                for (int k = j + 1; k < emptySpaces.size(); k++) {
                    int[][] tmpLab = copyLab();
                    tmpLab[emptySpaces.get(i)[0]][emptySpaces.get(i)[1]] = 1;
                    tmpLab[emptySpaces.get(j)[0]][emptySpaces.get(j)[1]] = 1;
                    tmpLab[emptySpaces.get(k)[0]][emptySpaces.get(k)[1]] = 1;

                    int safeAreaCount = calculateSafeArea(tmpLab);
                    maxSafeArea = Math.max(maxSafeArea, safeAreaCount);
                }
            }
        }
        System.out.println(maxSafeArea);
    }

    static int[][] copyLab() {
        int[][] newLab = new int[N][M];
        for (int i = 0; i < N; i++) {
            newLab[i] = lab[i].clone();
        }
        return newLab;
    }

    static int calculateSafeArea(int[][] tmpLab) {
        Queue<int[]> queue = new LinkedList<>(virusPositions);
        int virusCount = 0;

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int x = pos[0];
            int y = pos[1];

            for (int[] dir : directions) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && nx < N && ny >= 0 && ny < M && tmpLab[nx][ny] == 0) {
                    tmpLab[nx][ny] = 2;
                    virusCount++;
                    queue.add(new int[]{nx, ny});
                }
            }
        }

        return emptySpaces.size() - virusCount - 3;
    }
}