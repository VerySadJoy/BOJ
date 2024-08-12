//Question No: 10039
//Title: 평균 점수
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int total = 0;
        for (int i = 0; i < 5; i++) {
            int score = scanner.nextInt();
            if (score < 40) {
                score = 40;
            }
            total += score;
        }
        int average = total / 5;
        System.out.println(average);
    }
}