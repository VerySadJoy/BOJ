//Question No: 9251
//Title: LCS
//Tier: Gold V
namespace Joy
{
    class Q9251
    {
        static int LCS(string s1, string s2)
        {
            int[,] dp = new int[s1.Length + 1, s2.Length + 1];

            for (int i = 1; i <= s1.Length; i++)
            {
                for (int j = 1; j <= s2.Length; j++)
                {
                    if (s1[i - 1] == s2[j - 1])
                    {
                        dp[i, j] = dp[i - 1, j - 1] + 1;
                    }
                    else
                    {
                        dp[i, j] = Math.Max(dp[i - 1, j], dp[i, j - 1]);
                    }
                }
            }

            return dp[s1.Length, s2.Length];
        }

        static void Main()
        {
            string s1 = Console.ReadLine();
            string s2 = Console.ReadLine();

            int result = LCS(s1, s2);
            Console.WriteLine(result);
        }
    }

}
