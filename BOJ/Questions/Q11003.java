//Question No: 11003
//Title: 최솟값 찾기
//Tier: Platinum V
import java.io.*;
import java.util.*;

public class Main {

    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        int n = Integer.parseInt(tokenizer.nextToken());
        int l = Integer.parseInt(tokenizer.nextToken());

        Deque<int[]> deque = new ArrayDeque<>();
        tokenizer = new StringTokenizer(reader.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(tokenizer.nextToken());

            while (!deque.isEmpty() && deque.peekFirst()[1] < i - (l - 1)) {
                deque.pollFirst();
            }

            while (!deque.isEmpty() && deque.peekLast()[0] > num) {
                deque.pollLast();
            }

            deque.offerLast(new int[]{num, i});

            writer.write(deque.peekFirst()[0] + " ");
        }

        writer.flush();
        writer.close();
        reader.close();
    }
}