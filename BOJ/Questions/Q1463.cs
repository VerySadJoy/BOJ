//Question No: 1463
//Title: 1로 만들기
//Tier: Silver III
namespace Joy
{
    class Program
    {
        static void Main()
        {
            int n = int.Parse(Console.ReadLine());
            int[] lst = new int[n + 1];

            for (int i = 2; i <= n; i++)
            {
                lst[i] = lst[i - 1] + 1;

                if (i % 2 == 0)
                {
                    lst[i] = Math.Min(lst[i], lst[i / 2] + 1);
                }
                if (i % 3 == 0)
                {
                    lst[i] = Math.Min(lst[i], lst[i / 3] + 1);
                }
            }

            Console.WriteLine(lst[n]);
        }
    }
}
