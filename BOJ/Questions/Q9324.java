//Question No: 9324
//Title: 진짜 메시지
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int ASCII_A = 65;

    public static void main(String[] args) throws IOException {
        BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(inputReader.readLine());

        int testCases = Integer.parseInt(tokenizer.nextToken());
        StringBuilder outputBuilder = new StringBuilder();

        while (testCases-- > 0) {
            tokenizer = new StringTokenizer(inputReader.readLine());
            String message = tokenizer.nextToken();
            char[] messageCharacters = message.toCharArray();
            int[] alphabetCount = new int[26];
            boolean isValidMessage = true;

            for (int i = 0; i < messageCharacters.length; i++) {
                int index = messageCharacters[i] - ASCII_A;
                alphabetCount[index]++;
                if (alphabetCount[index] == 3) {
                    if (i + 1 >= messageCharacters.length || messageCharacters[i] != messageCharacters[i + 1]) {
                        isValidMessage = false;
                        break;
                    }
                    alphabetCount[index] = 0;
                    i++;
                }
            }

            if (isValidMessage) {
                outputBuilder.append("OK").append("\n");
            } else {
                outputBuilder.append("FAKE").append("\n");
            }
        }

        System.out.println(outputBuilder.toString());
    }
}