//Question No: 1149
//Title: RGB거리
//Tier: Silver I
namespace Joy{
    class Q1149
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int[,] costs = new int[N, 3];
            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split();
                for (int j = 0; j < 3; j++)
                {
                    costs[i, j] = int.Parse(input[j]);
                }
            }
            int[,] dp = new int[N, 3];
            for (int j = 0; j < 3; j++)
            {
                dp[0, j] = costs[0, j];
            }
            for (int i = 1; i < N; i++)
            {
                for (int j = 0; j < 3; j++)
                {
                    dp[i, j] = costs[i, j] + Math.Min(dp[i - 1, (j + 1) % 3], dp[i - 1, (j + 2) % 3]);
                }
            }
            int minCost = Math.Min(Math.Min(dp[N - 1, 0], dp[N - 1, 1]), dp[N - 1, 2]);
            Console.WriteLine(minCost);
        }
    }
}