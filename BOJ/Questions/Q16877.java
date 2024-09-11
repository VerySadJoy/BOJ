//Question No: 16877
//Title: 핌버
//Tier: Platinum III
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer;

        int numberOfElements = Integer.parseInt(bufferedReader.readLine());

        int[] fibonacci = new int[34];
        fibonacci[1] = 1;

        for (int i = 2; i < 34; i++) {
            fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
        }

        int[] grundyNumbers = new int[3000001];
        grundyNumbers[0] = 0;
        grundyNumbers[1] = 1;
        grundyNumbers[2] = 2;
        grundyNumbers[3] = 3;

        boolean[] checkArray = new boolean[16];
        for (int i = 4; i <= 3000000; i++) {
            Arrays.fill(checkArray, false);

            for (int j = 2; j < 34; j++) {
                if (fibonacci[j] <= i) {
                    checkArray[grundyNumbers[i - fibonacci[j]]] = true;
                } else {
                    for (int k = 0; k < 16; k++) {
                        if (!checkArray[k]) {
                            grundyNumbers[i] = k;
                            break;
                        }
                    }
                    break;
                }
            }
        }

        tokenizer = new StringTokenizer(bufferedReader.readLine());

        int result = 0;
        for (int i = 0; i < numberOfElements; i++) {
            int temp = Integer.parseInt(tokenizer.nextToken());
            result ^= grundyNumbers[temp];
        }

        bufferedWriter.write((result != 0) ? "koosaga" : "cubelover");
        bufferedWriter.flush();
        bufferedWriter.close();
        bufferedReader.close();
    }
}