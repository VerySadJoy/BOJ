//Question No: 5095
//Title: Q5095Matrix Powers
//Tier: Gold IV
import java.util.*;

class Q5095Matrix {
    long[][] array;

    public Q5095Matrix(int size) {
        array = new long[size][size];
    }
}

public class Main {
    @SuppressWarnings("ConvertToTryWithResources")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            int P = scanner.nextInt();

            if (N == 0 && M == 0 && P == 0) {
                break;
            }

            Q5095Matrix base = new Q5095Matrix(N);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    base.array[i][j] = scanner.nextLong();
                }
            }

            base = matrixPowerModular(base, P, N, M);

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    System.out.print(base.array[i][j]);
                    if (j < N - 1) {
                        System.out.print(" ");
                    }
                }
                System.out.println();
            }
            System.out.println();
        }

        scanner.close();
    }

    static Q5095Matrix matrixMultiplyModular(Q5095Matrix A, Q5095Matrix B, int N, int M) {
        Q5095Matrix result = new Q5095Matrix(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                result.array[i][j] = 0;
                for (int k = 0; k < N; k++) {
                    result.array[i][j] += (A.array[i][k] * B.array[k][j]) % M;
                    result.array[i][j] %= M;
                }
            }
        }

        return result;
    }

    static Q5095Matrix matrixPowerModular(Q5095Matrix A, int K, int N, int M) {
        Q5095Matrix result = new Q5095Matrix(N);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) {
                    result.array[i][j] = 1;
                } else {
                    result.array[i][j] = 0;
                }
            }
        }

        while (K > 0) {
            if ((K & 1) == 1) {
                result = matrixMultiplyModular(result, A, N, M);
            }
            A = matrixMultiplyModular(A, A, N, M);
            K >>= 1;
        }

        return result;
    }
}