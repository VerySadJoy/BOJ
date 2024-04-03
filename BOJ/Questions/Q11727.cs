//Question No: 11727
//Title: 2×n 타일링 2
//Tier: Silver III
namespace Joy
{
    class Q11727
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            if (n == 1)
            {
                Console.WriteLine(1);
                return;
            }
            int prev1 = 1;
            int prev2 = 3;
            for (int i = 3; i <= n; i++)
            {
                int current = (prev1 * 2 + prev2) % 10007;
                prev1 = prev2;
                prev2 = current;
            }
            Console.WriteLine(prev2);
        }
    }
}

