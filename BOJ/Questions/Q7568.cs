//Question No: 7568
//Title: 덩치
//Tier: Silver V
namespace Joy{
    class Q7568
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());

            int[] weights = new int[N];
            int[] heights = new int[N];

            for (int i = 0; i < N; i++)
            {
                string[] input = Console.ReadLine().Split();
                weights[i] = int.Parse(input[0]);
                heights[i] = int.Parse(input[1]);
            }

            for (int i = 0; i < N; i++)
            {
                int rank = 1;

                for (int j = 0; j < N; j++)
                {
                    if (i == j)
                    {
                        continue;
                    }
                    if (weights[i] < weights[j] && heights[i] < heights[j])
                    {
                        rank++;
                    }
                }

                Console.Write($"{rank} ");
            }
        }
    }
}