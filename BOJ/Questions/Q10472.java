//Question No: 10472
//Title: 십자뒤집기
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] directions = { {0, 1}, {0, -1}, {0, 0}, {1, 0}, {-1, 0} };
    static boolean[] visited = new boolean[1 << 9];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        
        while (t-- > 0) {
            boolean solutionFound = false;
            int value = 0;
            int level = -1;
            String[] grid = new String[3];
            
            for (int i = 0; i < 3; i++) {
                grid[i] = reader.readLine();
                for (int j = 0; j < 3; j++) {
                    if (grid[i].charAt(j) == '*') {
                        value |= (1 << (i * 3 + j));
                    }
                }
            }
            
            Queue<Integer> queue = new LinkedList<>();
            queue.add(value);
            visited = new boolean[1 << 9];
            visited[value] = true;
            
            while (!queue.isEmpty()) {
                level++;
                int queueSize = queue.size();
                
                while (queueSize-- > 0) {
                    value = queue.poll();
                    if (value == 0) {
                        solutionFound = true;
                        break;
                    }
                    
                    for (int i = 0; i < 9; i++) {
                        int x = i % 3;
                        int y = i / 3;
                        int newValue = value;
                        
                        for (int[] dir : directions) {
                            int nx = x + dir[0];
                            int ny = y + dir[1];
                            if (nx >= 0 && nx < 3 && ny >= 0 && ny < 3) {
                                newValue ^= (1 << (ny * 3 + nx));
                            }
                        }
                        
                        if (!visited[newValue]) {
                            visited[newValue] = true;
                            queue.add(newValue);
                        }
                    }
                }
                
                if (solutionFound) break;
            }
            
            System.out.println(level);
        }
    }
}
