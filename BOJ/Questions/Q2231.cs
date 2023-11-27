//Question No: 2231
//Title: 분해합
//Tier: Bronze II
namespace Joy
{
    class Q2231
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i < n; i++)
            {
                int number = i;
                int sum = number;

                while (number > 0)
                {
                    sum += number % 10;
                    number /= 10;
                }

                if (sum == n)
                {
                    Console.WriteLine(i);
                    return;
                }
            }
            Console.WriteLine(0);
        }
    }
}