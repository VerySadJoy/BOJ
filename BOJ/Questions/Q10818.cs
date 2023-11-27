//Question No: 10818
//Title: 최소, 최대
//Tier: Bronze III
namespace Joy
{
    class Q10818
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] numbers = Console.ReadLine().Split().Select(int.Parse).ToArray();
            int min = numbers.Min();
            int max = numbers.Max();

            Console.WriteLine($"{min} {max}");
        }
    }
}