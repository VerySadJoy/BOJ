//Question No: 1330
//Title: 두 수 비교하기
//Tier: Bronze V
namespace Joy
{
    class Q1330
    {
        static void Main()
        {
            string input = Console.ReadLine();
            string[] numbers = input.Split();

            int a = int.Parse(numbers[0]);
            int b = int.Parse(numbers[1]);

            if (a > b)
            {
                Console.WriteLine(">");
            }
            else if (a < b)
            {
                Console.WriteLine("<");
            }
            else
            {
                Console.WriteLine("==");
            }
        }
    }
}