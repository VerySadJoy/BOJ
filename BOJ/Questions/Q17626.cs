//Question No: 17626
//Title: Four Squares
//Tier: Silver III
namespace Joy
{
    class Q17626
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];
            dp[0] = 0;

            for (int i = 1; i <= n; i++)
            {
                dp[i] = int.MaxValue;
                for (int j = 1; j * j <= i; j++)
                {
                    dp[i] = Math.Min(dp[i], dp[i - j * j] + 1);
                }
            }
            Console.WriteLine(dp[n]);
        }
    }
}