//Question No: 3273
//Title: 두 수의 합
//Tier: Silver III
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int arraySize = Integer.parseInt(reader.readLine());
        int[] numbersArray = new int[arraySize];
        StringTokenizer token = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            numbersArray[i] = Integer.parseInt(token.nextToken());
        }
        Arrays.sort(numbersArray);
        int targetSum = Integer.parseInt(reader.readLine());
        int startPointer = 0;
        int endPointer = arraySize - 1;
        long pairCount = 0;
        while (startPointer < endPointer) {
            int currentSum = numbersArray[startPointer] + numbersArray[endPointer];
            if (currentSum == targetSum) {
                pairCount++;
            }
            if (currentSum <= targetSum) {
                startPointer++;
            }
            else {
                endPointer--;
            }
        }
        System.out.println(pairCount);
    }
}