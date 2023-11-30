//Question No: 11651
//Title: 좌표 정렬하기 2
//Tier: Silver V
using System.Text;

namespace Joy{
    class Q11651
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());

            List<int[]> pointList = new List<int[]>();

            for (int i = 0; i < N; i++)
            {
                int[] input = Console.ReadLine().Split().Select(int.Parse).ToArray();
                pointList.Add(input);
            }

            List<int[]> finalPoints = pointList.OrderBy(p => p[1]).ThenBy(p => p[0]).ToList();
            StringBuilder result = new StringBuilder();
            foreach (var value in finalPoints)
            {
                result.Append($"{value[0]} {value[1]}\n");
            }

            result.Length--;

            Console.WriteLine(result);
        }
    }
}