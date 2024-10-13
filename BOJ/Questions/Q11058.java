//Question No: 11058
//Title: 크리보드
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static long[] dpArray;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int inputNumber = Integer.parseInt(reader.readLine());
        dpArray = new long[inputNumber + 1];
        for (int i = 1; i <= inputNumber; i++) {
            dpArray[i] = dpArray[i - 1] + 1;
            if (i > 6) {
                for (int j = 2; j < 5; j++) {
                    dpArray[i] = Math.max(dpArray[i], dpArray[i - (j + 1)] * j);
                }
            }
        }
        System.out.println(dpArray[inputNumber]);
    }
}