//Question No: 1080
//Title: 행렬
//Tier: Silver I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static int n, m;
    static int[][] listA, listB;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = reader.readLine().split(" ");
        n = Integer.parseInt(nm[0]);
        m = Integer.parseInt(nm[1]);

        listA = new int[n][m];
        listB = new int[n][m];

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                listA[i][j] = line.charAt(j) - '0';
            }
        }

        for (int i = 0; i < n; i++) {
            String line = reader.readLine();
            for (int j = 0; j < m; j++) {
                listB[i][j] = line.charAt(j) - '0';
            }
        }

        int cnt = 0;

        if ((n < 3 || m < 3) && !isEqual(listA, listB)) {
            cnt = -1;
        } else {
            for (int r = 0; r <= n - 3; r++) {
                for (int c = 0; c <= m - 3; c++) {
                    if (listA[r][c] != listB[r][c]) {
                        cnt++;
                        flip(r, c);
                    }
                }
            }

            if (!isEqual(listA, listB)) {
                cnt = -1;
            }
        }

        System.out.println(cnt);
    }

    public static void flip(int i, int j) {
        for (int x = i; x < i + 3; x++) {
            for (int y = j; y < j + 3; y++) {
                listA[x][y] = listA[x][y] == 0 ? 1 : 0;
            }
        }
    }

    public static boolean isEqual(int[][] listA, int[][] listB) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (listA[i][j] != listB[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
