//Question No: 14888
//Title: 연산자 끼워넣기
//Tier: Silver I
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static int maxResult = Integer.MIN_VALUE;
    public static int minResult = Integer.MAX_VALUE;
    public static int[] operators = new int[4];
    public static int[] numbers;
    public static int numberCount;

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        numberCount = Integer.parseInt(reader.readLine());
        numbers = new int[numberCount];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < numberCount; i++) {
            numbers[i] = Integer.parseInt(tokenizer.nextToken());
        }

        tokenizer = new StringTokenizer(reader.readLine(), " ");
        for (int i = 0; i < 4; i++) {
            operators[i] = Integer.parseInt(tokenizer.nextToken());
        }

        calculate(numbers[0], 1);

        System.out.println(maxResult);
        System.out.println(minResult);
    }

    public static void calculate(int currentValue, int index) {
        if (index == numberCount) {
            maxResult = Math.max(maxResult, currentValue);
            minResult = Math.min(minResult, currentValue);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operators[i] > 0) {
                operators[i]--;

                switch (i) {
                    case 0: calculate(currentValue + numbers[index], index + 1); break;
                    case 1: calculate(currentValue - numbers[index], index + 1); break;
                    case 2: calculate(currentValue * numbers[index], index + 1); break;
                    case 3: calculate(currentValue / numbers[index], index + 1); break;
                }

                operators[i]++;
            }
        }
    }
}