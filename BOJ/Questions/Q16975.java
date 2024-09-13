//Question No: 16975
//Title: 수열과 쿼리 21
//Tier: Platinum IV
import java.io.*;
import java.util.StringTokenizer;

public class Main {

    static long[] fenwickTree;
    static int size;

    static void update(int position, int value) {
        while (position <= size) {
            fenwickTree[position] += value;
            position += (position & -position);
        }
    }

    static long query(int position) {
        long result = 0;
        while (position > 0) {
            result += fenwickTree[position];
            position &= (position - 1);
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(bufferedReader.readLine());
        fenwickTree = new long[size + 1];
        StringTokenizer tokenizer = new StringTokenizer(bufferedReader.readLine());
        int previousValue = Integer.parseInt(tokenizer.nextToken());
        int currentValue;
        update(1, previousValue);
        for (int i = 2; i <= size; i++) {
            currentValue = Integer.parseInt(tokenizer.nextToken());
            update(i, currentValue - previousValue);
            previousValue = currentValue;
        }

        StringBuilder result = new StringBuilder();
        int operations = Integer.parseInt(bufferedReader.readLine());
        for (int i = 0; i < operations; i++) {
            tokenizer = new StringTokenizer(bufferedReader.readLine());
            int operation = Integer.parseInt(tokenizer.nextToken());
            int start = Integer.parseInt(tokenizer.nextToken());

            if (operation == 1) {
                int end = Integer.parseInt(tokenizer.nextToken());
                int value = Integer.parseInt(tokenizer.nextToken());

                update(start, value);
                update(end + 1, -value);
            } else {
                result.append(query(start)).append("\n");
            }
        }

        System.out.print(result.toString());
    }
}