//Question No: 10807
//Title: 개수 세기
//Tier: Bronze V
namespace Joy
{
    class Q10807
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());

            string[] numbers = Console.ReadLine().Split();

            int v = int.Parse(Console.ReadLine());

            int count = 0;

            for (int i = 0; i < n; i++)
            {
                int num = int.Parse(numbers[i]);
                if (num == v)
                {
                    count++;
                }
            }
            Console.WriteLine(count);
        }
    }
}