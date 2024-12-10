//Question No: 17472
//Title: 다리 만들기 2
//Tier: Gold I
import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {-1, 0, 1, 0};
    static int[][] board;
    static boolean[][] visited;
    static ArrayList<Node>[] islandNodes;
    static PriorityQueue<Bridge> priorityQueue;
    static int[] parent;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        n = Integer.parseInt(tokenizer.nextToken());
        m = Integer.parseInt(tokenizer.nextToken());
        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        islandNodes = new ArrayList[7];
        visited = new boolean[n][m];
        int islandCount = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j] && board[i][j] == 1) {
                    islandNodes[islandCount] = new ArrayList<>();
                    markIsland(i, j, islandCount);
                    islandCount++;
                }
            }
        }

        priorityQueue = new PriorityQueue<>();
        for (int i = 1; i < islandCount; i++) {
            for (Node node : islandNodes[i]) {
                for (int direction = 0; direction < 4; direction++) {
                    findBridge(node.x, node.y, i, direction, -1);
                }
            }
        }

        System.out.println(calculateMinimumCost(islandCount));
    }

    public static int calculateMinimumCost(int islandCount) {
        parent = new int[islandCount];
        for (int i = 1; i < islandCount; i++) {
            parent[i] = i;
        }

        int result = 0, bridgeCount = 0;
        while (!priorityQueue.isEmpty()) {
            Bridge current = priorityQueue.poll();
            int root1 = find(current.start);
            int root2 = find(current.end);

            if (root1 != root2) {
                union(root1, root2);
                result += current.length;
                bridgeCount++;
            }
        }

        if (result == 0 || bridgeCount != islandCount - 2) {
            return -1;
        }
        return result;
    }

    public static int find(int node) {
        if (parent[node] == node) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public static void union(int node1, int node2) {
        parent[node1] = node2;
    }

    public static void findBridge(int x, int y, int islandNumber, int direction, int length) {
        if (board[x][y] != 0 && board[x][y] != islandNumber) {
            if (length >= 2) {
                priorityQueue.offer(new Bridge(islandNumber, board[x][y], length));
            }
            return;
        }

        int nx = x + dx[direction];
        int ny = y + dy[direction];
        if (nx < 0 || ny < 0 || nx >= n || ny >= m || board[nx][ny] == islandNumber) {
            return;
        }
        findBridge(nx, ny, islandNumber, direction, length + 1);
    }

    public static void markIsland(int x, int y, int islandNumber) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            board[current.x][current.y] = islandNumber;
            islandNodes[islandNumber].add(new Node(current.x, current.y));

            for (int direction = 0; direction < 4; direction++) {
                int nx = current.x + dx[direction];
                int ny = current.y + dy[direction];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && board[nx][ny] == 1) {
                    visited[nx][ny] = true;
                    queue.offer(new Node(nx, ny));
                }
            }
        }
    }

    public static class Bridge implements Comparable<Bridge> {
        int start, end, length;

        public Bridge(int start, int end, int length) {
            this.start = start;
            this.end = end;
            this.length = length;
        }

        @Override
        public int compareTo(Bridge other) {
            return this.length - other.length;
        }
    }

    public static class Node {
        int x, y;

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}