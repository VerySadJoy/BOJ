//Question No: 23304
//Title: 아카라카
//Tier: Silver II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String inputString;
    static boolean isPalindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        inputString = inputReader.readLine();
        isPalindrome = true;
        int stringLength = inputString.length();
        checkPalindrome(0, stringLength - 1);
        for (int i = stringLength / 2; i > 0 && isPalindrome; i /= 2) {
            checkPalindrome(0, i - 1);
        }
        if (isPalindrome) {
            System.out.println("AKARAKA");
        } else {
            System.out.println("IPSELENTI");
        }
    }

    private static void checkPalindrome(int leftIndex, int rightIndex) {
        if (leftIndex >= rightIndex) {
            isPalindrome = true;
            return;
        }
        if (inputString.charAt(leftIndex) == inputString.charAt(rightIndex)) {
            checkPalindrome(leftIndex + 1, rightIndex - 1);
        } else {
            isPalindrome = false;
        }
    }
}