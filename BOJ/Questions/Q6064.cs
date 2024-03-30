//Question No: 6064
//Title: 카잉 달력
//Tier: Silver I
using System.Text;

namespace Joy
{
    class Q6064
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int t = 0; t < T; t++)
            {
                string[] inputs = Console.ReadLine().Split();
                int M = int.Parse(inputs[0]);
                int N = int.Parse(inputs[1]);
                int x = int.Parse(inputs[2]);
                int y = int.Parse(inputs[3]);

                int year = -1;

                for (int k = x; k <= M * N; k += M)
                {
                    if ((k - 1) % N + 1 == y)
                    {
                        year = k;
                        break;
                    }
                }

                result.Append($"{year}\n");
            }
            if (result.Length > 0)
            {
                result.Length -= 1;
            }

            Console.WriteLine(result);
        }
    }
}