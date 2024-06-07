//Question No: 7453
//Title: 합이 0인 네 정수
//Tier: Gold II
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] sumAB, sumCD;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(bufferedReader.readLine());
        int[] arrayA = new int[size], arrayB = new int[size], arrayC = new int[size], arrayD = new int[size];
        
        for (int i = 0; i < size; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            arrayA[i] = Integer.parseInt(stringTokenizer.nextToken());
            arrayB[i] = Integer.parseInt(stringTokenizer.nextToken());
            arrayC[i] = Integer.parseInt(stringTokenizer.nextToken());
            arrayD[i] = Integer.parseInt(stringTokenizer.nextToken());
        }
        
        sumAB = new int[size * size];
        sumCD = new int[size * size];
        int index = 0;
        
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                sumAB[index] = arrayA[i] + arrayB[j];
                sumCD[index] = arrayC[i] + arrayD[j];
                index++;
            }
        }
        
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        
        long totalCount = 0;
        int leftPointer = 0, rightPointer = size * size - 1;
        
        while (leftPointer < size * size && rightPointer >= 0) {
            int sum = sumAB[leftPointer] + sumCD[rightPointer];
            if (sum < 0) {
                leftPointer++;
            } else if (sum > 0) {
                rightPointer--;
            } else {
                long countAB = 1, countCD = 1;
                while (leftPointer + 1 < size * size && sumAB[leftPointer] == sumAB[leftPointer + 1]) {
                    countAB++;
                    leftPointer++;
                }
                while (rightPointer > 0 && sumCD[rightPointer] == sumCD[rightPointer - 1]) {
                    countCD++;
                    rightPointer--;
                }
                totalCount += countAB * countCD;
                leftPointer++;
            }
        }
        
        System.out.println(totalCount);
    }
}

