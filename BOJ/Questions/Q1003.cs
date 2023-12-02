//Question No: 1003
//Title: 피보나치 함수
//Tier: Silver III
namespace Joy
{

    class Q1003
    {
        static void Main()
        {
            int count = int.Parse(Console.ReadLine());

            while (count > 0)
            {
                int [,] fib = new int[41, 2];
                fib[0, 0] = 1;
                fib[1, 1] = 1;
                int num = int.Parse(Console.ReadLine());
                for (int i = 2; i < num + 1; i++)
                {
                    fib[i, 0] = fib[i - 1, 0] + fib[i - 2, 0];
                    fib[i, 1] = fib[i - 1, 1] + fib[i - 2, 1];
                }
                count--;
                Console.WriteLine($"{fib[num, 0]} {fib[num, 1]}");
            }
        }
    }

}
