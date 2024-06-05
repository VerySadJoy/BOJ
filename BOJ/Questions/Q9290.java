//Question No: 9290
//Title: 틱택토 이기기
//Tier: Silver IV
import java.io.*;
import java.util.*;

public class Main {
    static char[][] board;
    static char currentPlayer;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int numberOfCases = Integer.parseInt(reader.readLine());
        board = new char[3][3];

        for (int caseNum = 1; caseNum <= numberOfCases; caseNum++) {
            for (int row = 0; row < 3; row++) {
                String input = reader.readLine();
                for (int col = 0; col < 3; col++) {
                    board[row][col] = input.charAt(col);
                }
            }
            currentPlayer = reader.readLine().charAt(0);
            updateBoardForPlayer(currentPlayer);

            writer.write("Case " + caseNum + ":\n");
            for (int row = 0; row < 3; row++) {
                for (int col = 0; col < 3; col++) {
                    writer.write(board[row][col]);
                }
                writer.write("\n");
            }
        }
        writer.flush();
        writer.close();
        reader.close();
    }

    static void updateBoardForPlayer(char player) {
        int count;
        for (int row = 0; row < 3; row++) {
            count = 0;
            for (int col = 0; col < 3; col++) {
                if (board[row][col] == player) {
                    count++;
                }
            }
            if (count >= 2) {
                for (int col = 0; col < 3; col++) {
                    board[row][col] = player;
                }
                return;
            }
        }
        for (int col = 0; col < 3; col++) {
            count = 0;
            for (int row = 0; row < 3; row++) {
                if (board[row][col] == player) {
                    count++;
                }
            }
            if (count >= 2) {
                for (int row = 0; row < 3; row++) {
                    board[row][col] = player;
                }
                return;
            }
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][i] == player) {
                count++;
            }
        }
        if (count >= 2) {
            for (int i = 0; i < 3; i++) {
                board[i][i] = player;
            }
            return;
        }
        count = 0;
        for (int i = 0; i < 3; i++) {
            if (board[i][2 - i] == player) {
                count++;
            }
        }
        if (count >= 2) {
            for (int i = 0; i < 3; i++) {
                board[i][2 - i] = player;
            }
        }
    }
}
