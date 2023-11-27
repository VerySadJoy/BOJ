//Question No: 1929
//Title: 소수 구하기
//Tier: Silver III
using System.Text;

namespace Joy
{
    class Q1929
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int m = int.Parse(input[0]);
            int n = int.Parse(input[1]);

            StringBuilder result = new StringBuilder();

            for (int i = m; i <= n; i++)
            {
                if (Check(i))
                {
                    result.AppendLine(i.ToString());
                }
            }

            Console.Write(result);
        }

        static bool Check(int num)
        {
            if (num < 2)
                return false;

            int sqrt = (int)Math.Sqrt(num);

            for (int i = 2; i <= sqrt; i++)
            {
                if (num % i == 0)
                    return false;
            }

            return true;
        }
    }
}