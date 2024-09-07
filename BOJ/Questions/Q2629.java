//Question No: 2629
//Title: 양팔저울
//Tier: Gold III
import java.io.*;
import java.util.*;

public class Main {

    static int numWeights;
    static int[] weights;
    static boolean[][] dpResult;

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        numWeights = Integer.parseInt(bufferedReader.readLine());
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        weights = new int[numWeights];
        dpResult = new boolean[numWeights + 1][40001];
        for (int i = 0; i < numWeights; i++) {
            weights[i] = Integer.parseInt(stringTokenizer.nextToken());
        }

        calculateWeights(0, 0);

        int numBeads = Integer.parseInt(bufferedReader.readLine());
        StringBuilder resultBuilder = new StringBuilder();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < numBeads; i++) {
            int beadWeight = Integer.parseInt(stringTokenizer.nextToken());

            if (dpResult[numWeights][beadWeight]) {
                resultBuilder.append("Y ");
            } else {
                resultBuilder.append("N ");
            }
        }

        System.out.println(resultBuilder.toString());
    }

    static void calculateWeights(int count, int currentWeight) {
        if (dpResult[count][currentWeight]) return;
        dpResult[count][currentWeight] = true;

        if (count == numWeights) return;

        calculateWeights(count + 1, currentWeight + weights[count]);
        calculateWeights(count + 1, currentWeight);
        calculateWeights(count + 1, Math.abs(currentWeight - weights[count]));
    }
}