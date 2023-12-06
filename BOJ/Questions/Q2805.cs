//Question No: 2805
//Title: 나무 자르기
//Tier: Silver II
namespace Joy
{
    class Q2805
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            long m = long.Parse(input[1]);

            long[] trees = new long[n];
            long maximum = 0;

            input = Console.ReadLine().Split();
            for (int i = 0; i < n; i++)
            {
                trees[i] = long.Parse(input[i]);
                maximum = Math.Max(maximum, trees[i]);
            }

            long left = 0;
            long right = maximum;
            long result = 0;

            while (left <= right)
            {
                long mid = (left + right) / 2;
                long sum = 0;

                for (int i = 0; i < n; i++)
                {
                    if (trees[i] > mid)
                        sum += trees[i] - mid;
                }

                if (sum >= m)
                {
                    result = Math.Max(result, mid);
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }

            Console.WriteLine(result);
        }
    }
}
