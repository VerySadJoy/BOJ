//Question No: 11720
//Title: 숫자의 합
//Tier: Bronze IV
namespace Joy
{
    class Q11720
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            string numbers = Console.ReadLine();
            int sum = 0;
            foreach (char digit in numbers)
            {
                sum += int.Parse(digit.ToString());
            }
            Console.WriteLine(sum);
        }
    }
}