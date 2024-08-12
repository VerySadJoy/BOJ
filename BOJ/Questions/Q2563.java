//Question No: 2563
//Title: 색종이
//Tier: Silver V
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[][] paper = new int[101][101];
        int left, bottom;
        int paperCount = scanner.nextInt();
        int coveredArea = 0;
        
        for (int k = 0; k < paperCount; k++) {
            left = scanner.nextInt();
            bottom = scanner.nextInt();
            for (int i = left; i < left + 10; i++) {
                for (int j = bottom; j < bottom + 10; j++) {
                    paper[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (paper[i][j] == 1) {
                    coveredArea++;
                }
            }
        }

        System.out.println(coveredArea);
    }
}