//Question No: 6603
//Title: 로또
//Tier: Silver II
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    static int totalNumbers;
    static int[] numbers;
    static boolean[] selected;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String inputLine = reader.readLine();
            if (inputLine.equals("0")) break;
            String[] inputTokens = inputLine.split(" ");
            totalNumbers = Integer.parseInt(inputTokens[0]);
            numbers = new int[totalNumbers];
            selected = new boolean[totalNumbers];
            for (int i = 0; i < totalNumbers; i++) {
                numbers[i] = Integer.parseInt(inputTokens[i + 1]);
            }
            generateCombinations(0, 0);
            System.out.println();
        }
    }

    public static void generateCombinations(int depth, int start) {
        if (depth == 6) {
            for (int i = 0; i < totalNumbers; i++) {
                if (selected[i]) {
                    System.out.print(numbers[i] + " ");
                }
            }
            System.out.println();
            return;
        }
        for (int i = start; i < totalNumbers; i++) {
            selected[i] = true;
            generateCombinations(depth + 1, i + 1);
            selected[i] = false;
        }
    }
}