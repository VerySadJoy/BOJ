//Question No: 14947
//Title: 상자 배달
//Tier: Gold II
import java.util.*;
import java.io.*;

public class Main {

    static int rows, columns;
    static int[][] room;
    static int startX, startY, endX, endY;
    static boolean[][][] visited;
    static int[] dx = {0, 0, 1, -1}, dy = {1, -1, 0, 0};
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());

        room = new int[rows][columns];
        startX = -1;
        startY = -1;
        endX = -1;
        endY = -1;

        for (int i = 0; i < rows; i++) {
            String inputLine = reader.readLine();
            for (int j = 0; j < columns; j++) {
                char currentChar = inputLine.charAt(j);
                if (currentChar == '2') {
                    room[i][j] = 1;
                    startX = i;
                    startY = j;
                } else if (currentChar == '3') {
                    room[i][j] = 1;
                    endX = i;
                    endY = j;
                } else if (currentChar == '1') {
                    room[i][j] = 1;
                }
            }
        }

        visited = new boolean[rows][columns][3];
        visited[startX][startY][0] = true;
        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{startX, startY, 0, 0});

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0];
            int y = current[1];
            int state = current[2];
            int moves = current[3];

            if (check(state, x, y)) {
                answer = moves;
                break;
            }

            if (state == 0) {
                processQueue(queue, x - 2, y, 2, moves + 1, x - 3 >= 0 && validBoard(2, x - 2, y));
                processQueue(queue, x + 2, y, 2, moves + 1, x + 3 < rows && validBoard(2, x + 2, y));
                processQueue(queue, x, y - 2, 1, moves + 1, y - 3 >= 0 && validBoard(1, x, y - 2));
                processQueue(queue, x, y + 2, 1, moves + 1, y + 3 < columns && validBoard(1, x, y + 2));
            } else if (state == 1) {
                processQueue(queue, x - 1, y, 1, moves + 1, x - 1 >= 0 && validBoard(1, x - 1, y));
                processQueue(queue, x + 1, y, 1, moves + 1, x + 1 < rows && validBoard(1, x + 1, y));
                processQueue(queue, x, y - 2, 0, moves + 1, y - 2 >= 0 && validBoard(0, x, y - 2));
                processQueue(queue, x, y + 2, 0, moves + 1, y + 2 < columns && validBoard(0, x, y + 2));
            } else if (state == 2) {
                processQueue(queue, x - 2, y, 0, moves + 1, x - 2 >= 0 && validBoard(0, x - 2, y));
                processQueue(queue, x + 2, y, 0, moves + 1, x + 2 < rows && validBoard(0, x + 2, y));
                processQueue(queue, x, y - 1, 2, moves + 1, y - 1 >= 0 && validBoard(2, x, y - 1));
                processQueue(queue, x, y + 1, 2, moves + 1, y + 1 < columns && validBoard(2, x, y + 1));
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? -2 : answer);
    }

    private static void processQueue(Deque<int[]> queue, int x, int y, int state, int moves, boolean condition) {
        if (condition && !visited[x][y][state]) {
            visited[x][y][state] = true;
            queue.add(new int[]{x, y, state, moves});
        }
    }

    private static boolean check(int state, int x, int y) {
        if (x == endX && y == endY) return true;
        if (state == 1 && ((y + 1 == endY && x == endX) || (y - 1 == endY && x == endX))) return true;
        if (state == 2 && ((x + 1 == endX && y == endY) || (x - 1 == endX && y == endY))) return true;
        return false;
    }

    private static boolean validBoard(int state, int x, int y) {
        if (room[x][y] == 1) return true;
        if (state == 1) return room[x][y - 1] == 1 && room[x][y + 1] == 1;
        if (state == 2) return room[x + 1][y] == 1 && room[x - 1][y] == 1;
        return false;
    }
}