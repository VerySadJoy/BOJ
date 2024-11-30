//Question No: 5502
//Title: 팰린드롬
//Tier: Gold III
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));

        int stringLength = Integer.parseInt(inputReader.readLine());
        String inputString = inputReader.readLine();

        int[][] palindromeCost = new int[stringLength + 1][stringLength + 1];

        for (int i = 1; i < stringLength; i++) {
            if (inputString.charAt(i - 1) == inputString.charAt(i)) {
                palindromeCost[i][i + 1] = 0;
            } else {
                palindromeCost[i][i + 1] = 1;
            }
        }

        for (int length = 3; length <= stringLength; length++) {
            for (int start = 1; start <= stringLength - (length - 1); start++) {
                int end = start + (length - 1);

                palindromeCost[start][end] = Math.min(
                        palindromeCost[start + 1][end] + 1,
                        palindromeCost[start][end - 1] + 1
                );

                if (inputString.charAt(start - 1) == inputString.charAt(end - 1)) {
                    palindromeCost[start][end] = Math.min(
                            palindromeCost[start][end],
                            palindromeCost[start + 1][end - 1]
                    );
                }
            }
        }

        System.out.println(palindromeCost[1][stringLength]);
    }
}