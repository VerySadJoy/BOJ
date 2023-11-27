//Question No: 3052
//Title: 나머지
//Tier: Bronze II
namespace Joy
{
    class Q3052
    {
        static void Main()
        {
            int[] numbers = new int[10];
            for (int i = 0; i < 10; i++)
            {
                numbers[i] = int.Parse(Console.ReadLine());
            }
            bool[] remainders = new bool[42];

            foreach (var number in numbers)
            {
                int remainder = number % 42;
                remainders[remainder] = true;
            }

            int count = 0;
            foreach (var flag in remainders)
            {
                if (flag)
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}