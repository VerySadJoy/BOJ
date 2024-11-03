//Question No: 23307
//Title: 드디어 시작한 화석 발굴 이벤트
//Tier: Gold III
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static long totalElements, targetSum;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        totalElements = Long.parseLong(tokenizer.nextToken());
        targetSum = Long.parseLong(tokenizer.nextToken());

        if (targetSum > 2 * totalElements) {
            System.out.println((2 * totalElements + 1) * (2 * totalElements + 1));
        } else if (targetSum % 2 != 0) {
            System.out.println((2 * totalElements + 1) * (2 * totalElements + 1) 
                               - (2 * totalElements - targetSum + 1) * (2 * totalElements - targetSum + 3) / 2);
        } else {
            System.out.println(2 * totalElements * totalElements + 2 * totalElements * targetSum 
                               - targetSum * targetSum / 2 + targetSum);
        }
    }
}