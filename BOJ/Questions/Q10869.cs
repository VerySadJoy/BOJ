//Question No: 10869
//Title: 사칙연산
//Tier: Bronze V
namespace Joy
{
    class Q10869
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split();

            int a = int.Parse(numbers[0]);
            int b = int.Parse(numbers[1]);

            int sum = a + b;
            int difference = a - b;
            int product = a * b;
            int quotient = a / b;
            int remainder = a % b;

            Console.WriteLine(a + b);
            Console.WriteLine(a - b);
            Console.WriteLine(a * b);
            Console.WriteLine(a / b);
            Console.WriteLine(a % b);
        }
    }
}