//Question No: 2577
//Title: 숫자의 개수
//Tier: Bronze II
namespace Joy
{
    class Q2577
    {
        static void Main()
        {
            int[] numbers = new int[3];
            for (int i = 0; i < 3; i++)
            {
                numbers[i] = int.Parse(Console.ReadLine());
            }
            int[] counts = new int[10];

            int result = numbers[0] * numbers[1] * numbers[2];

            while (result > 0)
            {
                int digit = result % 10;
                counts[digit]++;
                result /= 10;
            }
            foreach (var count in counts)
            {
                Console.WriteLine(count);
            }
        }
    }
}