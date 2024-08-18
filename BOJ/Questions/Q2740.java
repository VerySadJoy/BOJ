//Question No: 2740
//Title: 행렬 곱셈
//Tier: Silver V
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static final int threshold = 16;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] matrixA = new int[128][128];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < m; j++) {
                matrixA[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine(), " ");
        m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] matrixB = new int[128][128];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int j = 0; j < k; j++) {
                matrixB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int maxSize = Math.max(Math.max(n, k), m);
        int size = 1;
        while (size < maxSize) {
            size *= 2;
        }

        int[][] resultMatrix = multiply(matrixA, matrixB, size);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                sb.append(resultMatrix[i][j]).append(" ");
            }
            sb.append('\n');
        }

        System.out.println(sb);
    }

    public static int[][] loopMultiply(int[][] a, int[][] b, int size) {
        int[][] res = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                for (int l = 0; l < size; l++) {
                    res[i][j] += a[i][l] * b[l][j];
                }
            }
        }
        return res;
    }

    public static int[][] multiply(int[][] a, int[][] b, int size) {
        int[][] c = new int[size][size];

        if (size <= threshold) {
            return loopMultiply(a, b, size);
        }

        int newSize = size / 2;

        int[][] a11 = subArray(a, 0, 0, newSize);
        int[][] a12 = subArray(a, 0, newSize, newSize);
        int[][] a21 = subArray(a, newSize, 0, newSize);
        int[][] a22 = subArray(a, newSize, newSize, newSize);

        int[][] b11 = subArray(b, 0, 0, newSize);
        int[][] b12 = subArray(b, 0, newSize, newSize);
        int[][] b21 = subArray(b, newSize, 0, newSize);
        int[][] b22 = subArray(b, newSize, newSize, newSize);

        int[][] m1 = multiply(add(a11, a22, newSize), add(b11, b22, newSize), newSize);
        int[][] m2 = multiply(add(a21, a22, newSize), b11, newSize);
        int[][] m3 = multiply(a11, sub(b12, b22, newSize), newSize);
        int[][] m4 = multiply(a22, sub(b21, b11, newSize), newSize);
        int[][] m5 = multiply(add(a11, a12, newSize), b22, newSize);
        int[][] m6 = multiply(sub(a21, a11, newSize), add(b11, b12, newSize), newSize);
        int[][] m7 = multiply(sub(a12, a22, newSize), add(b21, b22, newSize), newSize);

        int[][] c11 = add(sub(add(m1, m4, newSize), m5, newSize), m7, newSize);
        int[][] c12 = add(m3, m5, newSize);
        int[][] c21 = add(m2, m4, newSize);
        int[][] c22 = add(add(sub(m1, m2, newSize), m3, newSize), m6, newSize);

        merge(c11, c, 0, 0, newSize);
        merge(c12, c, 0, newSize, newSize);
        merge(c21, c, newSize, 0, newSize);
        merge(c22, c, newSize, newSize, newSize);

        return c;
    }

    public static int[][] sub(int[][] a, int[][] b, int size) {
        int[][] c = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c[i][j] = a[i][j] - b[i][j];
            }
        }
        return c;
    }

    public static int[][] add(int[][] a, int[][] b, int size) {
        int[][] c = new int[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                c[i][j] = a[i][j] + b[i][j];
            }
        }
        return c;
    }

    public static int[][] subArray(int[][] src, int row, int col, int size) {
        int[][] dest = new int[size][size];
        for (int i = 0, srcRow = row; i < size; i++, srcRow++) {
            for (int j = 0, srcCol = col; j < size; j++, srcCol++) {
                dest[i][j] = src[srcRow][srcCol];
            }
        }
        return dest;
    }

    public static void merge(int[][] src, int[][] dest, int row, int col, int size) {
        for (int i = 0, srcRow = row; i < size; i++, srcRow++) {
            for (int j = 0, srcCol = col; j < size; j++, srcCol++) {
                dest[srcRow][srcCol] = src[i][j];
            }
        }
    }
}