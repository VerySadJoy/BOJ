//Question No: 14680
//Title: 효빈이의 과외
//Tier: Silver IV
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

class Matrix {
    private final int[][] values;
    private final int rows;
    private final int cols;
    private static final int MOD = 1000000007;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.values = new int[rows][cols];
    }

    public Matrix multiply(Matrix other) {
        if (this.cols != other.rows) throw new IllegalArgumentException("Invalid matrix dimensions for multiplication");

        Matrix result = new Matrix(this.rows, other.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0; j < other.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.values[i][j] = (int) ((result.values[i][j] + 1L * this.values[i][k] * other.values[k][j]) % MOD);
                }
            }
        }
        return result;
    }

    public int sum() {
        int totalSum = 0;
        for (int[] row : this.values) {
            for (int val : row) {
                totalSum = (totalSum + val) % MOD;
            }
        }
        return totalSum;
    }

    public void read(BufferedReader reader) throws IOException {
        for (int i = 0; i < this.rows; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < this.cols; j++) {
                this.values[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(reader.readLine().trim());
        Matrix[] matrices = new Matrix[N];

        boolean canMultiply = true;
        for (int i = 0; i < N; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            int rows = Integer.parseInt(tokenizer.nextToken());
            int cols = Integer.parseInt(tokenizer.nextToken());

            matrices[i] = new Matrix(rows, cols);
            matrices[i].read(reader);

            if (i > 0 && matrices[i - 1].getCols() != rows) {
                canMultiply = false;
            }
        }

        if (canMultiply) {
            Matrix result = matrices[0];
            for (int i = 1; i < N; i++) {
                result = result.multiply(matrices[i]);
            }
            System.out.println(result.sum());
        } else {
            System.out.println(-1);
        }
    }
}