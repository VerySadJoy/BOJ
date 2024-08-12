//Question No: 2443
//Title: 별 찍기 - 6
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numRows = scanner.nextInt();
        
        for (int i = 0; i < numRows; i++) {
            StringBuilder line = new StringBuilder();
            for (int j = 0; j < i; j++) {
                line.append(" ");
            }
            for (int j = 0; j < (numRows - i) * 2 - 1; j++) {
                line.append("*");
            }
            System.out.println(line.toString());
        }
    }
}