//Question No: 10830
//Title: 행렬 제곱
//Tier: Gold IV
namespace Joy
{
    class Q10830
    {
        static int[,] Multiply(int[,] A, int[,] B, int N)
        {
            int[,] result = new int[N, N];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    for (int k = 0; k < N; k++)
                    {
                        result[i, j] += A[i, k] * B[k, j];
                        result[i, j] %= 1000;
                    }
                }
            }
            return result;
        }
        static int[,] MatrixPower(int[,] matrix, long exponent, int N)
        {
            if (exponent == 1)
            {
                return matrix;
            }
            int[,] half = MatrixPower(matrix, exponent / 2, N);
            int[,] result = Multiply(half, half, N);
            if (exponent % 2 == 1)
            {
                result = Multiply(result, matrix, N);
            }
            return result;
        }
        static void PrintMatrix(int[,] matrix, int N)
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    Console.Write(matrix[i, j] % 1000 + " ");
                }
                Console.WriteLine();
            }
        }
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            long B = long.Parse(input[1]);
            int[,] matrix = new int[N, N];
            for (int i = 0; i < N; i++)
            {
                string[] row = Console.ReadLine().Split();
                for (int j = 0; j < N; j++)
                {
                    matrix[i, j] = int.Parse(row[j]) % 1000;
                }
            }
            int[,] result = MatrixPower(matrix, B, N);
            PrintMatrix(result, N);
        }
    }
}