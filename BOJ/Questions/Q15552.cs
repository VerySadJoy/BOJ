//Question No: 15552
//Title: 빠른 A+B
//Tier: Bronze IV
using System.Text;

namespace Joy
{
    class Q15552
    {
        static void Main()
        {
            int t = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();

            for (int i = 0; i < t; i++)
            {
                string[] input = Console.ReadLine().Split();
                int a = int.Parse(input[0]);
                int b = int.Parse(input[1]);
                result.AppendLine((a + b).ToString());
            }
            Console.Write(result.ToString());
        }
    }
}