//Question No: 13565
//Title: 침투
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int rows, columns;
    static int[][] grid;
    static boolean[][] visited;
    static int[] deltaX = {-1, 1, 0, 0}, deltaY = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());
        
        grid = new int[rows][columns];
        visited = new boolean[rows][columns];
        
        for (int i = 0; i < rows; i++) {
            String inputLine = reader.readLine();
            for (int j = 0; j < columns; j++) {
                grid[i][j] = inputLine.charAt(j) - '0';
            }
        }
        
        for (int i = 0; i < columns; i++) {
            if (grid[0][i] == 0 && !visited[0][i]) {
                depthFirstSearch(0, i);
            }
        }
        
        System.out.println("NO");
    }

    private static void depthFirstSearch(int row, int column) {
        visited[row][column] = true;
        
        if (row == rows - 1) {
            System.out.println("YES");
            System.exit(0);
        }
        
        for (int k = 0; k < 4; k++) {
            int newRow = row + deltaX[k];
            int newColumn = column + deltaY[k];
            if (newRow < 0 || newRow >= rows || newColumn < 0 || newColumn >= columns || visited[newRow][newColumn] || grid[newRow][newColumn] == 1) {
                continue;
            }
            depthFirstSearch(newRow, newColumn);
        }
    }
}