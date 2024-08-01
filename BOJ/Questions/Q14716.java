//Question No: 14716
//Title: 현수막
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int rows, cols;
    static int[][] grid;
    static boolean[][] visited;

    private static void bfs(int startRow, int startCol) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startRow, startCol});
        visited[startRow][startCol] = true;
        int[] rowOffsets = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] colOffsets = {0, 0, -1, 1, -1, 1, -1, 1};

        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int currentRow = cell[0];
            int currentCol = cell[1];

            for (int i = 0; i < 8; i++) {
                int newRow = currentRow + rowOffsets[i];
                int newCol = currentCol + colOffsets[i];
                
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < cols && grid[newRow][newCol] == 1 && !visited[newRow][newCol]) {
                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol});
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        rows = Integer.parseInt(st.nextToken());
        cols = Integer.parseInt(st.nextToken());

        grid = new int[rows][cols];
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < cols; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j);
                    islandCount++;
                }
            }
        }

        System.out.println(islandCount);
    }
}