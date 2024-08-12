//Question No: 2587
//Title: 대표값2
//Tier: Bronze II
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numbers = new int[5];
        
        for (int i = 0; i < 5; i++) {
            numbers[i] = scanner.nextInt();
        }
        
        Arrays.sort(numbers);
        
        int sum = 0;
        for (int num : numbers) {
            sum += num;
        }
        
        int average = sum / 5;
        int median = numbers[2];
        
        System.out.println(average);
        System.out.println(median);
    }
}