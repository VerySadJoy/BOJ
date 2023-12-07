//Question No: 11659
//Title: 구간 합 구하기 4
//Tier: Silver III
using System.Text;
namespace Joy
{
    class Q11659
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            StringBuilder result = new StringBuilder();

            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();

            int[] sum = new int[n + 1];

            for (int i = 1; i <= n; i++)
            {
                sum[i] = sum[i - 1] + numbers[i - 1];
            }

            for (int i = 0; i < m; i++)
            {
                input = Console.ReadLine().Split();
                int start = int.Parse(input[0]);
                int end = int.Parse(input[1]);

                int finalSum = sum[end] - sum[start - 1];
                result.Append($"{finalSum}\n");
            }
            result.Length--;
            Console.WriteLine(result);
        }
    }
}
