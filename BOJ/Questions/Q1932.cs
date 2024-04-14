//Question No: 1932
//Title: 정수 삼각형
//Tier: Silver I
namespace Joy{
    class Q1932
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int[][] triangle = new int[N][];
            for (int i = 0; i < N; i++)
            {
                string[] line = Console.ReadLine().Split();
                triangle[i] = new int[line.Length];
                for (int j = 0; j < line.Length; j++)
                {
                    triangle[i][j] = int.Parse(line[j]);
                }
            }
            int[][] dp = new int[N][];
            for (int i = 0; i < N; i++)
            {
                dp[i] = new int[i + 1];
            }
            for (int i = N - 1; i >= 0; i--)
            {
                for (int j = 0; j <= i; j++)
                {
                    if (i == N - 1)
                    {
                        dp[i][j] = triangle[i][j];
                    }
                    else
                    {
                        dp[i][j] = triangle[i][j] + Math.Max(dp[i + 1][j], dp[i + 1][j + 1]);
                    }
                }
            }
            int maxSum = dp[0][0];
            Console.WriteLine(maxSum);
        }
    }
}