//Question No: 9465
//Title: 스티커
//Tier: Silver I
namespace Joy
{
    class Q9465
    {
        static void Main()
        {
            int t = int.Parse(Console.ReadLine());

            for (int testCase = 0; testCase < t; testCase++)
            {
                int n = int.Parse(Console.ReadLine());
                int[][] stickers = new int[2][] {new int[n], new int[n]};

                for (int i = 0; i < 2; i++)
                {
                    string[] input = Console.ReadLine().Split();
                    for (int j = 0; j < n; j++)
                    {
                        stickers[i][j] = int.Parse(input[j]);
                    }
                }
                int[,] dp = new int[n + 1, 3];
                for (int i = 1; i <= n; i++)
                {
                    dp[i, 0] = Math.Max(dp[i - 1, 0], Math.Max(dp[i - 1, 1], dp[i - 1, 2]));
                    dp[i, 1] = Math.Max(dp[i - 1, 0], dp[i - 1, 2]) + stickers[0][i - 1];
                    dp[i, 2] = Math.Max(dp[i - 1, 0], dp[i - 1, 1]) + stickers[1][i - 1];
                }
                int score = Math.Max(dp[n, 0], Math.Max(dp[n, 1], dp[n, 2]));
                Console.WriteLine(score);
            }
        }
    }

}
