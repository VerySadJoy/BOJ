//Question No: 24060
//Title: 알고리즘 수업 - 병합 정렬 1
//Tier: Silver III
import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static int[] inputArray;
    private static int[] tempArray;
    private static int saveCount = 0;
    private static int targetSaveCount;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int arraySize = Integer.parseInt(tokenizer.nextToken());
        targetSaveCount = Integer.parseInt(tokenizer.nextToken());

        inputArray = new int[arraySize];
        tempArray = new int[arraySize];

        tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < arraySize; i++) {
            inputArray[i] = Integer.parseInt(tokenizer.nextToken());
        }

        mergeSort(0, arraySize - 1);
        System.out.println(result);
    }

    private static void mergeSort(int start, int end) {
        if (saveCount > targetSaveCount) return;
        if (start < end) {
            int mid = (start + end) / 2;
            mergeSort(start, mid);
            mergeSort(mid + 1, end);
            mergeAndCount(start, mid, end);
        }
    }

    private static void mergeAndCount(int start, int mid, int end) {
        int leftIndex = start, rightIndex = mid + 1, tempIndex = 0;

        while (leftIndex <= mid && rightIndex <= end) {
            if (inputArray[leftIndex] <= inputArray[rightIndex]) {
                tempArray[tempIndex++] = inputArray[leftIndex++];
            } else {
                tempArray[tempIndex++] = inputArray[rightIndex++];
            }
        }

        while (leftIndex <= mid) {
            tempArray[tempIndex++] = inputArray[leftIndex++];
        }

        while (rightIndex <= end) {
            tempArray[tempIndex++] = inputArray[rightIndex++];
        }

        leftIndex = start;
        tempIndex = 0;
        while (leftIndex <= end) {
            saveCount++;
            if (saveCount == targetSaveCount) {
                result = tempArray[tempIndex];
                break;
            }
            inputArray[leftIndex++] = tempArray[tempIndex++];
        }
    }
}