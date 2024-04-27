//Question No: 12865
//Title: 평범한 배낭
//Tier: Gold V
namespace Joy
{
    class Q12865
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int K = int.Parse(input[1]);
            int[] weights = new int[N + 1];
            int[] values = new int[N + 1];
            int[,] dp = new int[N + 1, K + 1];
            for (int i = 1; i <= N; i++)
            {
                input = Console.ReadLine().Split();
                weights[i] = int.Parse(input[0]);
                values[i] = int.Parse(input[1]);
            }
            for (int i = 1; i <= N; i++)
            {
                for (int j = 1; j <= K; j++)
                {
                    if (weights[i] <= j)
                    {
                        dp[i, j] = Math.Max(dp[i - 1, j], dp[i - 1, j - weights[i]] + values[i]);
                    }
                    else
                    {
                        dp[i, j] = dp[i - 1, j];
                    }
                }
            }
            Console.WriteLine(dp[N, K]);
        }
    }

}
