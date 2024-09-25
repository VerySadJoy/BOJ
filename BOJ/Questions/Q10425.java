//Question No: 10425
//Title: 피보나치 인버스
//Tier: Silver II
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        new Main().solution();
    }

    static BigInteger[] fibonacci = new BigInteger[100001];

    private void solution() throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCases = Integer.parseInt(reader.readLine());

        fibonacci[0] = new BigInteger("0");
        fibonacci[1] = new BigInteger("1");

        for (int i = 2; i < fibonacci.length; i++) {
            fibonacci[i] = fibonacci[i - 1].add(fibonacci[i - 2]);
        }

        for (int i = 0; i < testCases; i++) {
            BigInteger value = new BigInteger(reader.readLine());
            int index = findIndex(value);
            writer.write(index + "\n");
        }

        writer.flush();
        writer.close();
        reader.close();
    }

    private int findIndex(BigInteger value) {
        int start = 0;
        int end = fibonacci.length;
        while (start < end) {
            int mid = (start + end) / 2;
            if (value.compareTo(fibonacci[mid]) >= 0) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start - 1;
    }
}