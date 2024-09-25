//Question No: 2477
//Title: 참외밭
//Tier: Silver II
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();

        int[][] arr = new int[6][2];
        int widthIndex = 0;
        int heightIndex = 0;
        int widthMax = 0;
        int heightMax = 0;

        for (int i = 0; i < 6; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        for (int i = 0; i < 6; i++) {
            if (arr[i][0] == 1 || arr[i][0] == 2) {
                if (widthMax < arr[i][1]) {
                    widthMax = arr[i][1];
                    widthIndex = i;
                }
            } else if (arr[i][0] == 3 || arr[i][0] == 4) {
                if (heightMax < arr[i][1]) {
                    heightMax = arr[i][1];
                    heightIndex = i;
                }
            }
        }

        int W = 0, H = 0;

        switch (widthIndex) {
            case 0:
                H = Math.abs(arr[5][1] - arr[1][1]);
                break;
            case 5:
                H = Math.abs(arr[4][1] - arr[0][1]);
                break;
            default:
                H = Math.abs(arr[widthIndex + 1][1] - arr[widthIndex - 1][1]);
                break;
        }

        switch (heightIndex) {
            case 0:
                W = Math.abs(arr[5][1] - arr[1][1]);
                break;
            case 5:
                W = Math.abs(arr[4][1] - arr[0][1]);
                break;
            default:
                W = Math.abs(arr[heightIndex + 1][1] - arr[heightIndex - 1][1]);
                break;
        }
        System.out.println((widthMax * heightMax - W * H) * K);
    }
}