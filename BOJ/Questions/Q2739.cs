//Question No: 2739
//Title: 구구단
//Tier: Bronze V
namespace Joy
{
    class Q2739
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            for (int i = 1; i <= 9; i++)
            {
                Console.WriteLine($"{n} * {i} = {n * i}");
            }
        }
    }
}