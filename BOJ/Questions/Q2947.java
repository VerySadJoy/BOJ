//Question No: 2947
//Title: 나무 조각
//Tier: Bronze I
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }

        for (int j = 0; j < 5; j++) {
            for (int i = 0; i < 4; i++) {
                if (numbers[i] > numbers[i + 1]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[i + 1];
                    numbers[i + 1] = temp;
                    for (int num : numbers) {
                        System.out.print(num + " ");
                    }
                    System.out.println();
                }
            }
        }
    }
}