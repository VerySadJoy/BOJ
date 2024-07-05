//Question No: 13977
//Title: 이항 계수와 쿼리
//Tier: Platinum V
import java.io.IOException;
import java.io.InputStream;
import java.util.InputMismatchException;

public class Main {
    private static StringBuilder result;
    private static final int MOD = 1000000007;
    private static long[] factorial;

    public static void main(String[] args) throws Exception {
        initializeData();
        System.out.println(result);
    }

    private static void initializeData() throws Exception {
        InputReader input = new InputReader(System.in);
        result = new StringBuilder();
        factorial = new long[4000001];
        precomputeFactorials();

        int testCases = input.nextInt();
        while (testCases-- > 0) {
            int N = input.nextInt();
            int K = input.nextInt();
            result.append(computeCombination(N, K)).append('\n');
        }
    }

    private static long computeCombination(int N, int K) {
        long numerator = factorial[N];
        long denominator = (factorial[N - K] * factorial[K]) % MOD;
        denominator = modularExponentiation(denominator, MOD - 2);
        return (numerator * denominator) % MOD;
    }

    private static long modularExponentiation(long base, int exponent) {
        long result = 1;
        while (exponent > 0) {
            if (exponent % 2 == 1) {
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exponent /= 2;
        }
        return result;
    }

    private static void precomputeFactorials() {
        factorial[0] = 1;
        factorial[1] = 1;
        for (int i = 2; i < 4000001; i++) {
            factorial[i] = (i * factorial[i - 1]) % MOD;
        }
    }
}

class InputReader {
    private final InputStream stream;
    private final byte[] buffer = new byte[8192];
    private int currentChar, numChars;

    public InputReader(InputStream inputStream) {
        this.stream = inputStream;
    }

    public int read() {
        if (numChars == -1) {
            throw new InputMismatchException();
        }
        if (currentChar >= numChars) {
            currentChar = 0;
            try {
                numChars = stream.read(buffer);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0) {
                return -1;
            }
        }
        return buffer[currentChar++];
    }

    public int nextInt() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        int result = 0;
        do {
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public long nextLong() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        int sign = 1;
        if (c == '-') {
            sign = -1;
            c = read();
        }
        long result = 0;
        do {
            result = result * 10 + (c - '0');
            c = read();
        } while (!isSpaceChar(c));
        return result * sign;
    }

    public String nextLine() {
        int c = read();
        while (isSpaceChar(c)) {
            c = read();
        }
        StringBuilder result = new StringBuilder();
        do {
            result.appendCodePoint(c);
            c = read();
        } while (!isEndOfLine(c));
        return result.toString();
    }

    private boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }

    private boolean isEndOfLine(int c) {
        return c == '\n' || c == '\r' || c == -1;
    }
}
