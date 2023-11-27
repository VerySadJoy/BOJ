//Question No: 1008
//Title: A/B
//Tier: Bronze V
namespace Joy
{
    class Q1008
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split();

            double a = double.Parse(numbers[0]);
            double b = double.Parse(numbers[1]);

            Console.WriteLine(a / b);
        }
    }
}