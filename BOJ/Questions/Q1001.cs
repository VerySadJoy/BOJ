//Question No: 1001
//Title: A-B
//Tier: Bronze V
namespace Joy
{
    class Q1001
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split();

            int a = int.Parse(numbers[0]);
            int b = int.Parse(numbers[1]);

            Console.WriteLine(a - b);
        }
    }
}