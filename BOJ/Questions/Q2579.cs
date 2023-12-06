//Question No: 2579
//Title: 계단 오르기
//Tier: Silver III
namespace Joy
{
    class Q2579
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] stairs = new int[n + 1];
            int[] res = new int[n + 1];

            for (int i = 1; i <= n; i++)
            {
                stairs[i] = int.Parse(Console.ReadLine());
            }

            if (n == 1)
            {
                Console.WriteLine(stairs[1]);
            }
            else if (n == 2)
            {
                Console.WriteLine(stairs[1] + stairs[2]);
            }
            else
            {
                res[1] = stairs[1];
                res[2] = stairs[1] + stairs[2];

                for (int i = 3; i <= n; i++)
                {
                    res[i] = Math.Max(res[i - 2] + stairs[i], res[i - 3] + stairs[i - 1] + stairs[i]);
                }

                Console.WriteLine(res[n]);
            }
        }
    }
}
