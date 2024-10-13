//Question No: 13118
//Title: 뉴턴과 사과
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] points = new int[4];
        for (int i = 0; i < 4; i++) {
            points[i] = scanner.nextInt();
        }
        
        int coordinateX = scanner.nextInt();
        int coordinateY = scanner.nextInt();
        int coordinateZ = scanner.nextInt();
        
        boolean crashDetected = false;
        for (int i = 0; i < 4; i++) {
            if (points[i] == coordinateX) {
                System.out.print(i + 1);
                crashDetected = true;
            }
        }
        
        if (!crashDetected) {
            System.out.print(0);
        }
    }
}