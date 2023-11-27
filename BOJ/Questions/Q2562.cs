//Question No: 2562
//Title: 최댓값
//Tier: Bronze III
namespace Joy
{
    class Q2562
    {
        static void Main()
            {
            int max = 0;
            int maxIndex = 0;

            for (int i = 1; i <= 9; i++)
            {
                int number = int.Parse(Console.ReadLine());
                if (number > max)
                {
                    max = number;
                    maxIndex = i;
                }
            }
            Console.WriteLine(max);
            Console.WriteLine(maxIndex);
        }
    }
}