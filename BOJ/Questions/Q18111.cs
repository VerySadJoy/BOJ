//Question No: 18111
//Title: 마인크래프트
//Tier: Silver II
namespace Joy
{
    class Q18111
    {
        static void Main()
        {
            int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int N = input[0];
            int M = input[1];
            int B = input[2];

            int[,] heights = new int[N, M];

            for (int i = 0; i < N; i++)
            {
                int[] row = Console.ReadLine().Split().Select(int.Parse).ToArray();
                for (int j = 0; j < M; j++)
                {
                    heights[i, j] = row[j];
                }
            }

            int minTime = int.MaxValue;
            int maxHeight = 0;

            for (int h = 0; h <= 256; h++)
            {
                int time = 0;
                int blocks = B;

                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < M; j++)
                    {
                        int diff = heights[i, j] - h;

                        if (diff > 0)
                        {
                            time += 2 * diff;
                            blocks += diff;
                        }
                        else
                        {
                            time -= diff;
                            blocks += diff;
                        }
                    }
                }

                if (blocks >= 0 && time <= minTime)
                {
                    minTime = time;
                    maxHeight = h;
                }
            }

            Console.WriteLine($"{minTime} {maxHeight}");
        }
    }
}