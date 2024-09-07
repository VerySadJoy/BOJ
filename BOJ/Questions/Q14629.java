//Question No: 14629
//Title: 숫자 조각
//Tier: Silver I
import java.util.*;
import java.io.*;

public class Main {

    static boolean[] digitVisited;
    static long minimumDifference = Long.MAX_VALUE;
    static long closestNumber;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String inputNumber = bufferedReader.readLine();

        if (Long.parseLong(inputNumber) >= 9876543210L) {
            System.out.println(9876543210L);
            return;
        }

        digitVisited = new boolean[10];
        closestNumber = -1;

        findClosestNumber(inputNumber, 0, "");

        System.out.println(closestNumber);
    }

    public static void findClosestNumber(String inputNumber, int currentLength, String currentCombination) {
        if (inputNumber.length() == currentLength) {
            long originalNumber = Long.parseLong(inputNumber);
            long generatedNumber = Long.parseLong(currentCombination);

            if (Math.abs(originalNumber - generatedNumber) < minimumDifference) {
                closestNumber = generatedNumber;
                minimumDifference = Math.abs(originalNumber - generatedNumber);
            }

            return;
        }

        for (int i = 0; i < 10; i++) {
            if (!digitVisited[i]) {
                digitVisited[i] = true;
                currentCombination += String.valueOf(i);

                findClosestNumber(inputNumber, currentLength + 1, currentCombination);

                currentCombination = currentCombination.substring(0, currentCombination.length() - 1);
                digitVisited[i] = false;
            }
        }
    }
}