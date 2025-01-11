//Question No: 2381
//Title: 최대 거리
//Tier: Gold II
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        List<Integer> positiveSums = new ArrayList<>();
        List<Integer> negativeSums = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            positiveSums.add(a + b);
            negativeSums.add(a - b);
        }

        Collections.sort(positiveSums);
        Collections.sort(negativeSums);

        int maxDifference = Math.max(
            positiveSums.get(n - 1) - positiveSums.get(0),
            negativeSums.get(n - 1) - negativeSums.get(0)
        );

        System.out.println(maxDifference);
    }
}