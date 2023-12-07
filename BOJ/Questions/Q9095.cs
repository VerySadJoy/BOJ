//Question No: 9095
//Title: 1, 2, 3 더하기
//Tier: Silver III
namespace Joy
{
    class Q9095
    {
        static int[] lst;

        static int Count(int n)
        {
            if (n == 1)
            {
                return 1;
            }
            else if (n == 2)
            {
                return 2;
            }
            else if (n == 3)
            {
                return 4;
            }

            if (lst[n] != 0)
            {
                return lst[n];
            }

            lst[n] = Count(n - 1) + Count(n - 2) + Count(n - 3);

            return lst[n];
        }

        static void Main()
        {
            int t = int.Parse(Console.ReadLine());

            for (int i = 0; i < t; i++)
            {
                int n = int.Parse(Console.ReadLine());
                lst = new int[n + 1];

                int result = Count(n);
                Console.WriteLine(result);
            }
        }
    }
}
