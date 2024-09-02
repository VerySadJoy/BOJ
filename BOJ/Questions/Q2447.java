//Question No: 2447
//Title: 별 찍기 - 10
//Tier: Gold V
import java.io.*;
import java.util.*;

public class Main {

    static int size;
    static String[][] pattern;
    static StringBuilder output = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        size = Integer.parseInt(reader.readLine());
        pattern = new String[size][size];
        
        for (int i = 0; i < size; i++) {
            Arrays.fill(pattern[i], " ");
        }

        createPattern(0, 0, size);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                output.append(pattern[i][j]);
            }
            output.append("\n");
        }

        System.out.print(output);
    }

    static void createPattern(int x, int y, int n) {
        if (n == 1) {
            pattern[x][y] = "*";
            return;
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!(i == 1 && j == 1)) {
                    createPattern(x + i * (n / 3), y + j * (n / 3), n / 3);
                }
            }
        }
    }
}