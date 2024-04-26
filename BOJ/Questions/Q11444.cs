//Question No: 11444
//Title: 피보나치 수 6
//Tier: Gold II
namespace Joy
{
    class Q11444
    {
        static long[,] Multiply(long[,] a, long[,] b, long mod)
        {
            int n = a.GetLength(0);
            long[,] c = new long[n, n];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < n; j++)
                {
                    for (int k = 0; k < n; k++)
                    {
                        c[i, j] = (c[i, j] + a[i, k] * b[k, j]) % mod;
                    }
                }
            }
            
            return c;
        }
        static long[,] Power(long[,] matrix, long exponent, long mod)
        {
            if (exponent == 1)
                return matrix;
            long[,] half = Power(matrix, exponent / 2, mod);
            long[,] result = Multiply(half, half, mod);
            if (exponent % 2 == 1)
            {
                result = Multiply(result, matrix, mod);
            }
            return result;
        }
        static void Main()
        {
            long n = long.Parse(Console.ReadLine());
            long mod = 1000000007;
            if (n == 1)
            {
                Console.WriteLine(1);
                return;
            }
            long[,] baseMatrix = { {1, 1}, {1, 0} };
            long[,] resultMatrix = Power(baseMatrix, n - 1, mod);
            Console.WriteLine(resultMatrix[0, 0]);
        }
    }
}
