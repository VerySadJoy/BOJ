//Question No: 2845
//Title: 파티가 끝나고 난 뒤
//Tier: Bronze IV
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfArticles = scanner.nextInt();
        int multiplier = scanner.nextInt();
        int totalImpact = numberOfArticles * multiplier;

        for (int i = 0; i < 5; i++) {
            int reportedImpact = scanner.nextInt();
            System.out.print(reportedImpact - totalImpact + " ");
        }
    }
}