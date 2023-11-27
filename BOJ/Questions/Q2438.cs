//Question No: 2438
//Title: 별 찍기 - 1
//Tier: Bronze V
namespace Joy
{
    class Q2438
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            for (int i = 1; i <= n; i++)
            {
                for (int j = 1; j <= i; j++)
                {
                    Console.Write("*");
                }
                Console.WriteLine();
            }
        }
    }
}