//Question No: 25565
//Title: 딸기와 토마토
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {
    static int rows;
    static int columns;
    static int requiredCount;
    static int currentCount;
    static int[][] grid;
    static ArrayList<Position> positions;
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        rows = Integer.parseInt(tokenizer.nextToken());
        columns = Integer.parseInt(tokenizer.nextToken());
        requiredCount = Integer.parseInt(tokenizer.nextToken());
        currentCount = 0;
        grid = new int[rows][columns];
        positions = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < columns; j++) {
                grid[i][j] = Integer.parseInt(tokenizer.nextToken());
                if (grid[i][j] == 1) {
                    currentCount++;
                }
            }
        }
        currentCount = requiredCount * 2 - currentCount;
        if (currentCount == requiredCount) {
            handleCase1();
        } else if (currentCount == 1) {
            handleCase2();
        } else if (currentCount > 1) {
            handleCase3();
        }
        writer.write(currentCount + "\n");
        for (int i = 0; i < positions.size(); i++) {
            writer.write((positions.get(i).row + 1) + " " + (positions.get(i).column + 1) + "\n");
        }
        writer.close();
    }
    public static void handleCase1() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    boolean checkDirection = false;
                    positions.add(new Position(i, j));
                    if (j + 1 < columns && grid[i][j + 1] == 1) {
                        checkDirection = false;
                    } else if (i + 1 < rows && grid[i + 1][j] == 1) {
                        checkDirection = true;
                    }
                    for (int l = 1; l < requiredCount; l++) {
                        if (checkDirection) {
                            positions.add(new Position(i + l, j));
                        } else {
                            positions.add(new Position(i, j + l));
                        }
                    }
                    return;
                }
            }
        }
    }
    public static void handleCase2() {
        int[] rowAdjustments = {0, 0, 1, -1};
        int[] columnAdjustments = {1, -1, 0, 0};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    int adjacentCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextRow = i + rowAdjustments[k];
                        int nextColumn = j + columnAdjustments[k];

                        if (nextRow < 0 || nextColumn < 0 || nextRow >= rows || nextColumn >= columns || grid[nextRow][nextColumn] == 0) {
                            continue;
                        }

                        if (k < 2) {
                            adjacentCount |= 1;
                        } else {
                            adjacentCount |= 2;
                        }
                    }

                    if (adjacentCount == 3) {
                        positions.add(new Position(i, j));
                        return;
                    }
                }
            }
        }
        handleCase3();
    }
    public static void handleCase3() {
        int currentGroupCount = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (grid[i][j] == 1) {
                    boolean checkDirection = false;
                    currentGroupCount++;
                    if (j + 1 < columns && grid[i][j + 1] == 1) {
                        checkDirection = false;
                    } else if (i + 1 < rows && grid[i + 1][j] == 1) {
                        checkDirection = true;
                    }
                    for (int l = 1; l < requiredCount; l++) {
                        if (checkDirection) {
                            if (requiredCount - currentGroupCount <= currentCount) {
                                positions.add(new Position(i + l, j));
                            }
                            currentGroupCount++;
                        } else {
                            if (requiredCount - currentGroupCount <= currentCount) {
                                positions.add(new Position(i, j + l));
                            }
                            currentGroupCount++;
                        }
                    }
                    return;
                }
            }
        }
    }
    public static class Position {
        int row;
        int column;
        public Position(int row, int column) {
            this.row = row;
            this.column = column;
        }
    }
}