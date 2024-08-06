//Question No: 4344
//Title: 평균은 넘겠지
//Tier: Bronze I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[] scores;
        int testCases = scanner.nextInt();
        
        for (int i = 0; i < testCases; i++) {
            int studentCount = scanner.nextInt();
            scores = new int[studentCount];
            double totalScore = 0;
            
            for (int j = 0; j < studentCount; j++) {
                int score = scanner.nextInt();
                scores[j] = score;
                totalScore += score;
            }
            
            double average = totalScore / studentCount;
            double aboveAverageCount = 0;
            
            for (int j = 0; j < studentCount; j++) {
                if (scores[j] > average) {
                    aboveAverageCount++;
                }
            }
            
            System.out.printf("%.3f%%\n", (aboveAverageCount / studentCount) * 100);
        }
        
        scanner.close();
    }
}