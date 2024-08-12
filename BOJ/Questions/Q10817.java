//Question No: 10817
//Title: 세 수
//Tier: Bronze III
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        int second = scanner.nextInt();
        int third = scanner.nextInt();
        int middleValue;

        if (first >= second && first >= third) {
            middleValue = (second > third) ? second : third;
        } else if (second >= first && second >= third) {
            middleValue = (first > third) ? first : third;
        } else {
            middleValue = (first > second) ? first : second;
        }

        System.out.println(middleValue);
    }
}