//Question No: 12100
//Title: 2048 (Easy)
//Tier: Gold II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            String[] row = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(row[j]);
            }
        }
        dfs(board, 0);
        System.out.println(max);
    }

    public static void dfs(int[][] board, int count) {
        if (count == 5) {
            max = Math.max(max, getMaxValue(board));
            return;
        }
        for (int i = 0; i < 4; i++) {
            int[][] newBoard = move(board, i);
            dfs(newBoard, count + 1);
        }
    }

    public static int[][] move(int[][] board, int direction) {
        int[][] newBoard = new int[N][N];
        switch (direction) {
            case 0:
                for (int j = 0; j < N; j++) {
                    int idx = 0;
                    for (int i = 0; i < N; i++) {
                        if (board[i][j] != 0) {
                            if (newBoard[idx][j] == 0) {
                                newBoard[idx][j] = board[i][j];
                            } else if (newBoard[idx][j] == board[i][j]) {
                                newBoard[idx][j] *= 2;
                                idx++;
                            } else {
                                idx++;
                                newBoard[idx][j] = board[i][j];
                            }
                        }
                    }
                }
                break;
            case 1:
                for (int j = 0; j < N; j++) {
                    int idx = N - 1;
                    for (int i = N - 1; i >= 0; i--) {
                        if (board[i][j] != 0) {
                            if (newBoard[idx][j] == 0) {
                                newBoard[idx][j] = board[i][j];
                            } else if (newBoard[idx][j] == board[i][j]) {
                                newBoard[idx][j] *= 2;
                                idx--;
                            } else {
                                idx--;
                                newBoard[idx][j] = board[i][j];
                            }
                        }
                    }
                }
                break;
            case 2:
                for (int i = 0; i < N; i++) {
                    int idx = 0;
                    for (int j = 0; j < N; j++) {
                        if (board[i][j] != 0) {
                            if (newBoard[i][idx] == 0) {
                                newBoard[i][idx] = board[i][j];
                            } else if (newBoard[i][idx] == board[i][j]) {
                                newBoard[i][idx] *= 2;
                                idx++;
                            } else {
                                idx++;
                                newBoard[i][idx] = board[i][j];
                            }
                        }
                    }
                }
                break;
            case 3:
                for (int i = 0; i < N; i++) {
                    int idx = N - 1;
                    for (int j = N - 1; j >= 0; j--) {
                        if (board[i][j] != 0) {
                            if (newBoard[i][idx] == 0) {
                                newBoard[i][idx] = board[i][j];
                            } else if (newBoard[i][idx] == board[i][j]) {
                                newBoard[i][idx] *= 2;
                                idx--;
                            } else {
                                idx--;
                                newBoard[i][idx] = board[i][j];
                            }
                        }
                    }
                }
                break;
        }
        return newBoard;
    }

    public static int getMaxValue(int[][] board) {
        int maxValue = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxValue = Math.max(maxValue, board[i][j]);
            }
        }
        return maxValue;
    }
}
