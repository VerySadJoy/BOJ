//Question No: 15488
//Title: 나이트가 체스판을 벗어나지 않을 확률
//Tier: Gold V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int x = sc.nextInt();
        int y = sc.nextInt();
        int K = sc.nextInt();
        sc.close();

        int[] dr = {1, 2, 2, 1, -1, -2, -2, -1};
        int[] dc = {2, 1, -1, -2, -2, -1, 1, 2};

        double[][][] DP = new double[K + 1][N][N];
        DP[0][x - 1][y - 1] = 1.0;

        for (int p = 1; p <= K; p++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    for (int k = 0; k < 8; k++) {
                        int ni = i + dr[k];
                        int nj = j + dc[k];
                        if (ni >= 0 && ni < N && nj >= 0 && nj < N) {
                            DP[p][ni][nj] += DP[p - 1][i][j] / 8.0;
                        }
                    }
                }
            }
        }

        double ans = 0.0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans += DP[K][i][j];
            }
        }

        System.out.println(ans);
    }
}
