//Question No: 10871
//Title: X보다 작은 수
//Tier: Bronze V
using System.Text;

namespace Joy
{
    class Q10871
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int x = int.Parse(input[1]);

            string[] numbers = Console.ReadLine().Split();

            StringBuilder result = new StringBuilder();

            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(numbers[i]);
                if (num < x)
                {
                    result.Append(num).Append(' ');
                }
            }
            Console.WriteLine(result.ToString().Trim());
        }
    }
}