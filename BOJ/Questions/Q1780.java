//Question No: 1780
//Title: 종이의 개수
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int[][] paper;
    public static int countGray = 0; 
    public static int countWhite = 0; 
    public static int countBlack = 0; 

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(reader.readLine());
        paper = new int[size][size];
        StringTokenizer tokenizer;

        for (int i = 0; i < size; i++) {
            tokenizer = new StringTokenizer(reader.readLine(), " ");
            for (int j = 0; j < size; j++) {
                paper[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }

        divide(0, 0, size);

        System.out.println(countGray); 
        System.out.println(countWhite); 
        System.out.println(countBlack); 
    }

    public static void divide(int row, int col, int size) {

        if (isUniformColor(row, col, size)) {
            if (paper[row][col] == -1) { 
                countGray++;
            } else if (paper[row][col] == 0) {
                countWhite++;
            } else {
                countBlack++;
            }
            return;
        }

        int newSize = size / 3;

        divide(row, col, newSize); 
        divide(row, col + newSize, newSize); 
        divide(row, col + 2 * newSize, newSize); 

        divide(row + newSize, col, newSize); 
        divide(row + newSize, col + newSize, newSize); 
        divide(row + newSize, col + 2 * newSize, newSize); 

        divide(row + 2 * newSize, col, newSize); 
        divide(row + 2 * newSize, col + newSize, newSize); 
        divide(row + 2 * newSize, col + 2 * newSize, newSize); 
    }

    public static boolean isUniformColor(int row, int col, int size) {
        int color = paper[row][col];

        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}