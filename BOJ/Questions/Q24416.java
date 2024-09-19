//Question No: 24416
//Title: 알고리즘 수업 - 피보나치 수 1
//Tier: Bronze I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {

    static int recursiveCallCount, dynamicProgrammingCount;
    static int[] dpArray;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int number = Integer.parseInt(reader.readLine());
        dpArray = new int[number];

        reader.close();

        recursiveCallCount = 0;
        dynamicProgrammingCount = 0;

        calculateRecursiveFibonacci(number);
        calculateDynamicFibonacci(number);

        System.out.println(recursiveCallCount + " " + dynamicProgrammingCount);
    }

    static int calculateRecursiveFibonacci(int number) {
        if (number == 1 || number == 2) {
            recursiveCallCount++;
            return 1;
        }
        return calculateRecursiveFibonacci(number - 1) + calculateRecursiveFibonacci(number - 2);
    }

    static int calculateDynamicFibonacci(int number) {
        dpArray[0] = 1;
        dpArray[1] = 1;

        for (int i = 2; i < number; i++) {
            dynamicProgrammingCount++;
            dpArray[i] = dpArray[i - 1] + dpArray[i - 2];
        }
        return dpArray[number - 1];
    }
}