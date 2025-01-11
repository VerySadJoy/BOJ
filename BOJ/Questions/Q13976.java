//Question No: 13976
//Title: 타일 채우기 2
//Tier: Platinum V
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.HashMap;

public class Main {
    public static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out), 1024 * 64);
    public static long number;
    public static long[][] matrix = {{4, -1}, {1, 0}};
    public static HashMap<Long, long[][]> memoizationMap;
    public static long MODULO = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        FastReader reader = new FastReader();
        number = reader.nextLong();

        if (number % 2 == 1) {
            writer.write("0");
        } else {
            memoizationMap = new HashMap<>();
            long[][] result = divideAndConquer(number);
            writer.write(Long.toString((result[0][0] + result[0][1]) % MODULO));
        }

        writer.flush();
        writer.close();
    }

    public static long[][] divideAndConquer(long exponent) {
        if (exponent == 1) {
            return new long[][]{{1, 0}, {0, 1}};
        } else if (exponent == 2) {
            return matrix;
        }

        if (memoizationMap.containsKey(exponent)) {
            return memoizationMap.get(exponent);
        }

        long nearestPower = 0;
        for (int i = 1; i <= 60; i++) {
            if (1L << (i + 1) >= exponent) {
                nearestPower = 1L << i;
                break;
            }
        }

        long[][] firstPart = divideAndConquer(nearestPower);
        if (!memoizationMap.containsKey(nearestPower)) {
            memoizationMap.put(nearestPower, firstPart);
        }

        long[][] secondPart = divideAndConquer(exponent - nearestPower);
        if (!memoizationMap.containsKey(exponent - nearestPower)) {
            memoizationMap.put(exponent - nearestPower, secondPart);
        }

        return multiplyMatrices(firstPart, secondPart);
    }

    public static long[][] multiplyMatrices(long[][] a, long[][] b) {
        long[][] result = new long[2][2];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                long sum = 0;
                for (int k = 0; k < 2; k++) {
                    sum += a[i][k] * b[k][j];
                    sum += MODULO;
                    sum %= MODULO;
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    public static class FastReader {
        private final DataInputStream input;
        private final int BUFFER_SIZE = 1 << 16;
        private final byte[] buffer;
        private int bufferPointer, bytesRead;

        public FastReader() {
            input = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }

        public String readLine() throws IOException {
            byte[] lineBuffer = new byte[BUFFER_SIZE];
            int count = 0, character;
            while ((character = read()) != -1) {
                if (character == '\n') {
                    break;
                }
                lineBuffer[count++] = (byte) character;
            }
            return new String(lineBuffer, 0, count);
        }

        public long nextLong() throws IOException {
            long result = 0;
            byte character = read();
            while (character <= ' ') {
                character = read();
            }
            boolean isNegative = (character == '-');
            if (isNegative) {
                character = read();
            }
            do {
                result = (result << 3) + (result << 1) + (character & 15);
            } while ((character = read()) > 32);

            return isNegative ? ~result + 1 : result;
        }

        private void fillBuffer() throws IOException {
            bytesRead = input.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1) {
                buffer[0] = -1;
            }
        }

        private byte read() throws IOException {
            if (bufferPointer == bytesRead) {
                fillBuffer();
            }
            return buffer[bufferPointer++];
        }
    }
}