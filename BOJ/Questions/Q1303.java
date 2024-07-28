//Question No: 1303
//Title: 전쟁 - 전투
//Tier: Silver I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int rows, cols, currentX, currentY;
    static char[][] battlefield;

    static boolean[][] visited;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int whitePower, blackPower;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rows = Integer.parseInt(tokenizer.nextToken());
        cols = Integer.parseInt(tokenizer.nextToken());

        battlefield = new char[cols][rows];
        visited = new boolean[cols][rows];

        for (int i = 0; i < cols; i++) {
            String line = reader.readLine();
            for (int j = 0; j < rows; j++) {
                battlefield[i][j] = line.charAt(j);
            }
        }

        int totalWhitePower = 0;
        int totalBlackPower = 0;

        for (int i = 0; i < cols; i++) {
            for (int j = 0; j < rows; j++) {
                if (!visited[i][j] && battlefield[i][j] == 'W') {
                    whitePower = 1;
                    dfsWhite(i, j);
                    totalWhitePower += (whitePower * whitePower);
                }
                if (!visited[i][j] && battlefield[i][j] == 'B') {
                    blackPower = 1;
                    dfsBlack(i, j);
                    totalBlackPower += (blackPower * blackPower);
                }
            }
        }
        System.out.println(totalWhitePower + " " + totalBlackPower);
    }

    static void dfsWhite(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            currentX = dx[i] + x;
            currentY = dy[i] + y;

            if (isInBounds() && !visited[currentX][currentY] && battlefield[currentX][currentY] == 'W') {
                whitePower++;
                dfsWhite(currentX, currentY);
            }
        }
    }

    static void dfsBlack(int x, int y) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            currentX = dx[i] + x;
            currentY = dy[i] + y;

            if (isInBounds() && !visited[currentX][currentY] && battlefield[currentX][currentY] == 'B') {
                blackPower++;
                dfsBlack(currentX, currentY);
            }
        }
    }

    static boolean isInBounds() {
        return (currentX >= 0 && currentY >= 0 && currentX < cols && currentY < rows);
    }
}