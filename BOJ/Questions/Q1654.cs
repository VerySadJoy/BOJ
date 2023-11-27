//Question No: 1654
//Title: 랜선 자르기
//Tier: Silver II
namespace Joy
{
    class Q1654
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int k = int.Parse(input[0]);
            int n = int.Parse(input[1]);

            long[] lan = new long[k];

            for (int i = 0; i < k; i++)
            {
                lan[i] = long.Parse(Console.ReadLine());
            }

            long left = 1;
            long right = lan.Max();

            while (left <= right)
            {
                long mid = (left + right) / 2;
                long count = 0;

                foreach (var cable in lan)
                {
                    count += cable / mid;
                }

                if (count >= n)
                {
                    left = mid + 1;
                }
                else
                {
                    right = mid - 1;
                }
            }

            Console.WriteLine(right);
        }
    }
}