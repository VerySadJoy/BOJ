//Question No: 17144
//Title: 미세먼지 안녕!
//Tier: Gold IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static int[][] room;
    private static Queue<Dust> dustQueue = new LinkedList<>();
    private static List<Dust> dustList = new ArrayList<>();
    private static int[][] directions = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    private static int cleanerTop;
    private static int cleanerBottom;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] dimensions = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        room = new int[dimensions[0]][dimensions[1]];
        initializeRoom(br);

        for (int i = 0; i < room.length; i++) {
            if (room[i][0] == -1) {
                cleanerTop = i;
                cleanerBottom = i + 1;
                break;
            }
        }

        for (int i = 0; i < dimensions[2]; i++) {
            spreadDust();
            operateTopCleaner();
            operateBottomCleaner();
        }

        int totalDust = calculateTotalDust();
        System.out.println(totalDust);
    }

    private static void initializeRoom(BufferedReader br) throws IOException {
        for (int i = 0; i < room.length; i++) {
            int[] row = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 0; j < row.length; j++) {
                room[i][j] = row[j];
            }
        }
    }

    private static void operateBottomCleaner() {
        for (int row = cleanerBottom + 1; row < room.length - 1; row++) {
            room[row][0] = room[row + 1][0];
        }

        for (int col = 0; col < room[0].length - 1; col++) {
            room[room.length - 1][col] = room[room.length - 1][col + 1];
        }

        for (int row = room.length - 1; row > cleanerBottom; row--) {
            room[row][room[row].length - 1] = room[row - 1][room[row].length - 1];
        }

        for (int col = room[cleanerBottom].length - 1; col > 0; col--) {
            if (col == 1) {
                room[cleanerBottom][col] = 0;
            } else {
                room[cleanerBottom][col] = room[cleanerBottom][col - 1];
            }
        }
    }

    private static void operateTopCleaner() {
        for (int row = cleanerTop - 1; row > 0; row--) {
            room[row][0] = room[row - 1][0];
        }

        for (int col = 0; col < room[0].length - 1; col++) {
            room[0][col] = room[0][col + 1];
        }

        for (int row = 0; row < cleanerTop; row++) {
            room[row][room[row].length - 1] = room[row + 1][room[row].length - 1];
        }

        for (int col = room[cleanerTop].length - 1; col > 0; col--) {
            if (col == 1) {
                room[cleanerTop][col] = 0;
            } else {
                room[cleanerTop][col] = room[cleanerTop][col - 1];
            }
        }
    }

    private static void spreadDust() {
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                int dustAmount = room[row][col];
                int spreadAmount = dustAmount / 5;

                if (dustAmount <= 0) {
                    continue;
                }

                int spreadCount = distributeDust(row, col, spreadAmount);
                room[row][col] = dustAmount - spreadAmount * spreadCount;
            }
        }

        while (!dustQueue.isEmpty()) {
            Dust dust = dustQueue.remove();
            room[dust.row][dust.col] += dust.value;
        }
    }

    private static int distributeDust(int row, int col, int dustAmount) {
        int spreadCount = 0;

        for (int[] direction : directions) {
            int newRow = row + direction[0];
            int newCol = col + direction[1];

            if (isValidPosition(newRow, newCol, dustAmount)) {
                dustQueue.add(new Dust(newRow, newCol, dustAmount));
                spreadCount++;
            }
        }

        return spreadCount;
    }

    public static class Dust {
        private int row;
        private int col;
        private int value;

        public Dust(int row, int col, int value) {
            this.row = row;
            this.col = col;
            this.value = value;
        }
    }

    private static boolean isValidPosition(int row, int col, int dustAmount) {
        if (row < 0 || row >= room.length || col < 0 || col >= room[row].length) {
            return false;
        } else if (room[row][col] == -1) {
            return false;
        } else return dustAmount != 0;
    }

    private static int calculateTotalDust() {
        int totalDust = 0;
        for (int row = 0; row < room.length; row++) {
            for (int col = 0; col < room[row].length; col++) {
                if (room[row][col] > 0) {
                    totalDust += room[row][col];
                }
            }
        }
        return totalDust;
    }
}
