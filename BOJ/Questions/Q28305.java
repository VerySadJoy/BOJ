//Question No: 28305
//Title: 세미나 배정
//Tier: Gold I
import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int length;
    static int interval;
    static int[] values;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] input = parseInput(scanner.nextLine());
        length = input[0];
        interval = input[1];
        values = parseInput(scanner.nextLine());
        Arrays.sort(values);

        int lowerBound = 0;
        int upperBound = length + 1;
        while (lowerBound + 1 < upperBound) {
            int midPoint = (lowerBound + upperBound) / 2;
            if (isValid(midPoint)) {
                upperBound = midPoint;
            } else {
                lowerBound = midPoint;
            }
        }
        System.out.println(upperBound);
        scanner.close();
    }

    public static boolean isValid(int segments) {
        int[] adjustedValues = new int[length];
        for (int i = 0; i < length; i++) {
            adjustedValues[i] = values[i];
        }
        for (int i = 0; i < length; i++) {
            if (i < segments) {
                adjustedValues[i] = Math.max(values[i] - interval + 1, 1);
                continue;
            }
            adjustedValues[i] = Math.max(adjustedValues[i - segments] + interval, Math.max(values[i] - interval + 1, 1));
        }
        for (int i = 0; i < length; i++) {
            if (adjustedValues[i] > values[i]) return false;
        }
        return true;
    }

    public static int[] parseInput(String inputLine) {
        return Arrays.stream(inputLine.split(" "))
                     .mapToInt(Integer::parseInt)
                     .toArray();
    }
}