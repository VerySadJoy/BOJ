//Question No: 25501
//Title: 재귀의 귀재
//Tier: Bronze II
import java.util.Scanner;

public class Main {
    
    static int callCount;
    
    public static int checkRecursively(String text, int left, int right) {
        callCount++;
        if (left >= right) return 1;
        if (text.charAt(left) != text.charAt(right)) return 0;
        return checkRecursively(text, left + 1, right - 1);
    }

    public static int isPalindrome(String text) {
        return checkRecursively(text, 0, text.length() - 1);
    }

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int testCases = scanner.nextInt();

        for (int i = 0; i < testCases; i++) {
            callCount = 0;
            String input = scanner.next();
            System.out.println(isPalindrome(input) + " " + callCount);
        }
        scanner.close();
    }
}