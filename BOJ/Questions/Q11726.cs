//Question No: 11726
//Title: 2×n 타일링
//Tier: Silver III
namespace Joy
{
    class Q11726
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] dp = new int[n + 1];

            Console.WriteLine(Calculate(n, dp));
        }

        static int Calculate(int n, int[] dp)
        {
            if (n <= 2)
            {
                return n;
            }

            if (dp[n] != 0)
            {
                return dp[n];
            }

            dp[n] = (Calculate(n - 1, dp) + Calculate(n - 2, dp)) % 10007;

            return dp[n];
        }
    }
}
