//Question No: 2839
//Title: 설탕 배달
//Tier: Silver IV
namespace Joy
{
    class Q2839
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int count = 0;

            while (N > 0)
            {
                if (N % 5 == 0)
                {
                    count += N / 5;
                    break;
                }
                else
                {
                    N -= 3;
                    count++;
                }

                if (N < 0)
                {
                    count = -1;
                    break;
                }
            };
            Console.WriteLine(count);
        }
    }
}
