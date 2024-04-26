//Question No: 11053
//Title: 가장 긴 증가하는 부분 수열
//Tier: Silver II
namespace Joy
{
    class Q11053
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] arr = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);

            int[] dp = new int[n];
            for (int i = 0; i < n; i++)
            {
                dp[i] = 1;
                for (int j = 0; j < i; j++)
                {
                    if (arr[i] > arr[j] && dp[i] < dp[j] + 1)
                    {
                        dp[i] = dp[j] + 1;
                    }
                }
            }
            int maxLen = 0;
            for (int i = 0; i < n; i++)
            {
                if (maxLen < dp[i])
                {
                    maxLen = dp[i];
                }
            }

            Console.WriteLine(maxLen);
        }
    }
}
