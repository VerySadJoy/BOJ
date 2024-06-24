//Question No: 14226
//Title: 이모티콘
//Tier: Gold IV
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int S = scanner.nextInt();
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0, 0});
        
        boolean[][] visited = new boolean[1001][1001];
        visited[1][0] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int screen = current[0];
            int clipboard = current[1];
            int cnt = current[2];
            
            if (screen == S) {
                System.out.println(cnt);
                break;
            }
            
            for (int i = 0; i < 3; i++) {
                int newScreen, newClipboard;
                
                if (i == 0) {
                    newClipboard = screen;
                    newScreen = screen;
                } else if (i == 1) {
                    newScreen = screen + clipboard;
                    newClipboard = clipboard;
                } else {
                    newScreen = screen - 1;
                    newClipboard = clipboard;
                }
                
                if (newScreen >= 1001 || newScreen < 0 || newClipboard >= 1001 || newClipboard < 0 || visited[newScreen][newClipboard]) {
                    continue;
                }
                
                visited[newScreen][newClipboard] = true;
                queue.add(new int[]{newScreen, newClipboard, cnt + 1});
            }
        }
        
        scanner.close();
    }
}
