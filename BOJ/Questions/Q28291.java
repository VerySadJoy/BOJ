//Question No: 28291
//Title: 레드스톤
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    private static class Node {
        int x, y, stepsRemaining;

        Node(int x, int y, int stepsRemaining) {
            this.x = x;
            this.y = y;
            this.stepsRemaining = stepsRemaining;
        }
    }

    final static int EMPTY = -1, DUST = 1, BLOCK = 2, LAMP = 3, INITIAL_VOLTAGE = 15;
    static int rows, columns;
    static int[][] grid, voltageLevels;
    static Queue<Node> nodeQueue = new LinkedList<>();
    static Queue<Node> lampQueue = new LinkedList<>();

    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        rows = parseInteger(tokenizer.nextToken());
        columns = parseInteger(tokenizer.nextToken());
        initializeGrid();

        tokenizer = new StringTokenizer(bufferedReader.readLine());
        int totalElements = parseInteger(tokenizer.nextToken());
        for (int i = 0; i < totalElements; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            String type = tokenizer.nextToken().split("_")[1];
            int x = parseInteger(tokenizer.nextToken());
            int y = parseInteger(tokenizer.nextToken());
            switch (type) {
                case "block":
                    placeElement(x, y, BLOCK);
                    break;
                case "dust":
                    placeElement(x, y, DUST);
                    break;
                case "lamp":
                    placeElement(x, y, LAMP);
                    break;
            }
        }

        performBFS();
        System.out.println(checkIfSuccess() ? "success" : "failed");
    }

    private static boolean checkIfSuccess() {
        while (!lampQueue.isEmpty()) {
            Node lampNode = lampQueue.poll();
            if (voltageLevels[lampNode.x][lampNode.y] == EMPTY) {
                return false;
            }
        }
        return true;
    }

    private static void performBFS() {
        while (!nodeQueue.isEmpty()) {
            Node currentNode = nodeQueue.poll();
            if (currentNode.stepsRemaining == 0) continue;
            for (int i = 0; i < 4; i++) {
                int nextX = currentNode.x + dx[i];
                int nextY = currentNode.y + dy[i];
                if (isWithinBounds(nextX, nextY) && (grid[nextX][nextY] == DUST || grid[nextX][nextY] == LAMP) && voltageLevels[nextX][nextY] < currentNode.stepsRemaining) {
                    voltageLevels[nextX][nextY] = currentNode.stepsRemaining;
                    if (grid[nextX][nextY] != LAMP) {
                        nodeQueue.add(new Node(nextX, nextY, currentNode.stepsRemaining - 1));
                    }
                }
            }
        }
    }

    private static boolean isWithinBounds(int x, int y) {
        return x >= 0 && y >= 0 && x < rows && y < columns;
    }

    private static void placeElement(int x, int y, int elementType) {
        if (elementType == BLOCK) {
            grid[x][y] = BLOCK;
            voltageLevels[x][y] = INITIAL_VOLTAGE;
            nodeQueue.add(new Node(x, y, INITIAL_VOLTAGE));
        } else if (elementType == LAMP) {
            grid[x][y] = LAMP;
            lampQueue.add(new Node(x, y, 0));
        } else {
            grid[x][y] = DUST;
        }
    }
    
    private static void initializeGrid() {
        grid = new int[rows][columns];
        voltageLevels = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                voltageLevels[i][j] = EMPTY;
            }
        }
    }

    private static int parseInteger(String input) {
        return Integer.parseInt(input);
    }
}