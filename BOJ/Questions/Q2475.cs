//Question No: 2475
//Title: 검증수
//Tier: Bronze V
namespace Joy
{
    class Q2475
    {
        static void Main()
        {
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int result = numbers.Sum(x => x * x) % 10;
            Console.WriteLine(result);
        }
    }
}