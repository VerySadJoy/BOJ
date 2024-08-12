//Question No: 2163
//Title: 초콜릿 자르기
//Tier: Bronze I
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        int cutsNeeded = rows * columns - 1;
        System.out.println(cutsNeeded);
    }
}