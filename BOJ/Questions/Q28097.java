//Question No: 28097
//Title: 모범생 포닉스
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int numberOfItems = scanner.nextInt();
        int totalTime = 0;

        for (int i = 0; i < numberOfItems; i++) {
            int itemTime = scanner.nextInt();
            totalTime += itemTime;
        }

        totalTime += (numberOfItems - 1) * 8;
        System.out.println(totalTime / 24 + " " + totalTime % 24);
        
        scanner.close();
    }
}