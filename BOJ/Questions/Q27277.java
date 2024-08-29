//Question No: 27277
//Title: 장기자랑
//Tier: Silver I
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] dataArray = new int[n];
        
        for (int i = 0; i < n; i++) {
            dataArray[i] = scanner.nextInt();
        }
        
        Arrays.sort(dataArray);
        int start = 0;
        int end = n - 1;
        int[] rearrangedData = new int[n];
        int index = 0;
        
        while (start <= end) {
            rearrangedData[index++] = dataArray[end--];
            if (start <= end) {
                rearrangedData[index++] = dataArray[start++];
            }
        }
        
        int tempValue = 0;
        int finalAnswer = 0;
        for (int value : rearrangedData) {
            if (tempValue < value) {
                finalAnswer += value - tempValue;
            }
            tempValue = value;
        }
        
        System.out.println(finalAnswer);
    }
}