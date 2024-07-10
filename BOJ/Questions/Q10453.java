//Question No: 10453
//Title: 문자열 변환
//Tier: Gold V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int[] indexA = new int[50000];
    static int[] indexB = new int[50000];

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine().trim());

        while (t-- > 0) {
            String[] input = reader.readLine().split(" ");
            String aString = input[0];
            String bString = input[1];

            int n = 0;
            int aLen = aString.length();
            int bLen = bString.length();

            for (int i = 0; i < aLen; i++) {
                if (aString.charAt(i) == 'b') {
                    indexA[n++] = i;
                }
            }
            int aCount = n;

            n = 0;
            for (int i = 0; i < bLen; i++) {
                if (bString.charAt(i) == 'b') {
                    indexB[n++] = i;
                }
            }
            int bCount = n;

            if (aCount != bCount) {
                System.out.println("-1");
                continue;
            }

            int sum = 0;
            for (int i = 0; i < aCount; i++) {
                sum += Math.abs(indexA[i] - indexB[i]);
            }

            System.out.println(sum);
        }
    }
}
