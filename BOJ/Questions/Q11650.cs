//Question No: 11650
//Title: 좌표 정렬하기
//Tier: Silver V
using System.Text;
using System.Linq;

namespace Joy
{
    class Q11650
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int[,] points = new int[N, 2];

            for (int i = 0; i < N; i++)
            {
                int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
                points[i, 0] = input[0];
                points[i, 1] = input[1];
            }

            var finalPoints = Enumerable.Range(0, N).Select(i => new { X = points[i, 0], Y = points[i, 1] }).OrderBy(p => p.X).ThenBy(p => p.Y);

            StringBuilder result = new StringBuilder();
            foreach (var point in finalPoints)
            {
                result.Append($"{point.X} {point.Y}\n");
            }

            if (result.Length > 0)
            {
                result.Length -= 1;
            }

            Console.WriteLine(result);
        }
    }
}
