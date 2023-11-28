//Question No: 11050
//Title: 이항 계수 1
//Tier: Bronze I
using System;

namespace Joy
{
    class Q11050
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int K = int.Parse(input[1]);
            int[,] coefficient = new int[N + 1, K + 1];

            for (int i = 0; i <= N; i++)
            {
                for (int j = 0; j <= Math.Min(i, K); j++)
                {
                    if (j == 0 || j == i)
                        coefficient[i, j] = 1;
                    else
                        coefficient[i, j] = (coefficient[i - 1, j - 1] + coefficient[i - 1, j]) % 10007;
                }
            }

            Console.WriteLine(coefficient[N, K]);
        }
    }
}
