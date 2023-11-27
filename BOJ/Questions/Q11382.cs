//Question No: 11382
//Title: 꼬마 정민
//Tier: Bronze V
namespace Joy
{
    class Q11382
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split();

            long a = long.Parse(numbers[0]);
            long b = long.Parse(numbers[1]);
            long c = long.Parse(numbers[2]);

            Console.WriteLine(a + b + c);
        }
    }
}