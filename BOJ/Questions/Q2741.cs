//Question No: 2741
//Title: N 찍기
//Tier: Bronze V
using System.Text;

namespace Joy
{
    class Q2741
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();

            for (int i = 1; i <= n; i++)
            {
                result.AppendLine(i.ToString());
            }
            Console.Write(result.ToString());
        }
    }
}