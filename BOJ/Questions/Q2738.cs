//Question No: 2738
//Title: 행렬 덧셈
//Tier: Bronze V
namespace Joy
{
    class Q2738
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            int[,] matrixA = new int[n, m];
            for (int i = 0; i < n; i++)
            {
                input = Console.ReadLine().Split();
                for (int j = 0; j < m; j++)
                {
                    matrixA[i, j] = int.Parse(input[j]);
                }
            }

            int[,] matrixB = new int[n, m];
            for (int i = 0; i < n; i++)
            {
                input = Console.ReadLine().Split();
                for (int j = 0; j < m; j++)
                {
                    matrixB[i, j] = int.Parse(input[j]);
                }
            }

            int[,] result = new int[n, m];
            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    result[i, j] = matrixA[i, j] + matrixB[i, j];
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    Console.Write(result[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}