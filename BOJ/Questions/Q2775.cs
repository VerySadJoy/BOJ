//Question No: 2775
//Title: 부녀회장이 될테야
//Tier: Bronze I
using System.Text;

namespace Joy
{
    class Q2775
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < T; i++)
            {
                int k = int.Parse(Console.ReadLine());
                int n = int.Parse(Console.ReadLine());

                if (k == 0)
                {
                    result.Append(n);
                }
                    

                int[,] house = new int[k + 1, n + 1];

                for (int j = 0; j <= n; j++)
                {
                    house[0, j] = j;
                }

                for (int a = 1; a <= k; a++)
                {
                    for (int b = 1; b <= n; b++)
                    {
                        house[a, b] = house[a, b - 1] + house[a - 1, b];
                    }
                }

                result.Append(house[k, n]);
                result.Append("\n");
            }

            if (result.Length > 0)
            {
                result.Length--;
            }

            Console.WriteLine(result);
        }
    }
}
