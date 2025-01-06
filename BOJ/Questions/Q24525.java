//Question No: 24525
//Title: SKK 문자열
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();

        int[] prefixSum = new int[input.length() + 1];
        int[] nonZeroCount = new int[input.length() + 1];
        Map<Integer, Integer> minIndexMap = new HashMap<>();

        for (int i = 0; i < input.length(); i++) {
            int value = 0;
            if (input.charAt(i) == 'S') value = 2;
            if (input.charAt(i) == 'K') value = -1;

            prefixSum[i + 1] = prefixSum[i] + value;
            nonZeroCount[i + 1] = nonZeroCount[i] + (value == 0 ? 0 : 1);
        }

        int maxLength = -1;

        for (int i = 0; i <= input.length(); i++) {
            if (!minIndexMap.containsKey(prefixSum[i])) {
                minIndexMap.put(prefixSum[i], i);
            } else {
                int previousIndex = minIndexMap.get(prefixSum[i]);
                if (nonZeroCount[previousIndex] == nonZeroCount[i]) continue;
                maxLength = Math.max(maxLength, i - previousIndex);
            }
        }

        System.out.println(maxLength);
    }
}