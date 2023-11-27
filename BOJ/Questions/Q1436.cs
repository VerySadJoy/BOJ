//Question No: 1436
//Title: 영화감독 숌
//Tier: Silver V
namespace Joy
{
    class Q1436
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            int count = 0;
            int number = 665;

            while (count < n)
            {
                number++;

                if (number.ToString().Contains("666"))
                {
                    count++;
                }
            }

            Console.WriteLine(number);
        }
    }
}