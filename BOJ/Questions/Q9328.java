//Question No: 9328
//Title: 열쇠
//Tier: Gold I
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static char[][] map;
    static boolean[] hasKey;
    static ArrayList<Point>[] gates;
    static boolean[][] visited;
    static int height;
    static int width;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int documentCount;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseCount = Integer.parseInt(br.readLine());

        for (int t = 0; t < testCaseCount; t++) {
            String[] inputMap = br.readLine().split(" ");

            height = Integer.parseInt(inputMap[0]);
            width = Integer.parseInt(inputMap[1]);

            map = new char[height + 2][width + 2];
            visited = new boolean[height + 2][width + 2];
            hasKey = new boolean[26];
            gates = new ArrayList[26];

            documentCount = 0;

            for (int i = 0; i < 26; i++) {
                gates[i] = new ArrayList<>();
            }

            for (int i = 0; i < height + 2; i++) {
                for (int j = 0; j < width + 2; j++) {
                    map[i][j] = '.';
                }
            }

            for (int i = 1; i <= height; i++) {
                String input = br.readLine();
                for (int j = 1; j <= width; j++) {
                    map[i][j] = input.charAt(j - 1);
                }
            }

            String keyInput = br.readLine();
            if (!keyInput.equals("0")) {
                for (int i = 0; i < keyInput.length(); i++) {
                    int temp = keyInput.charAt(i) - 'a';
                    hasKey[temp] = true;
                }
            }

            bfs();
            System.out.println(documentCount);
        }
    }

    static void bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(0, 0));
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = current.x + dx[i];
                int nextY = current.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= height + 2 || nextY >= width + 2) {
                    continue;
                }

                if (map[nextX][nextY] == '*' || visited[nextX][nextY]) {
                    continue;
                }

                int elem = map[nextX][nextY];
                if (elem >= 'A' && elem <= 'Z') {
                    if (hasKey[elem - 'A']) {
                        map[nextX][nextY] = '.';
                        visited[nextX][nextY] = true;
                        queue.add(new Point(nextX, nextY));
                    } else {
                        gates[elem - 'A'].add(new Point(nextX, nextY));
                    }
                } else if (elem >= 'a' && elem <= 'z') {
                    hasKey[elem - 'a'] = true;
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));

                    for (int j = 0; j <= 25; j++) {
                        if (!gates[j].isEmpty() && hasKey[j]) {
                            for (Point gate : gates[j]) {
                                map[gate.x][gate.y] = '.';
                                visited[gate.x][gate.y] = true;
                                queue.add(new Point(gate.x, gate.y));
                            }
                        }
                    }
                } else if (elem == '$') {
                    documentCount++;
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                } else {
                    visited[nextX][nextY] = true;
                    queue.add(new Point(nextX, nextY));
                }
            }
        }
    }

    static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
