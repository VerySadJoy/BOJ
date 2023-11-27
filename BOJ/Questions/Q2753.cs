//Question No: 2753
//Title: 윤년
//Tier: Bronze V
namespace Joy
{
    class Q2753
    {
        static void Main()
        {
            int year = int.Parse(Console.ReadLine());

            if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
            {
                Console.WriteLine("1");
            }
            else
            {
                Console.WriteLine("0");
            }
        }
    }
}