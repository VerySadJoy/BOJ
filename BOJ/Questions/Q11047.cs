//Question No: 11047
//Title: 동전 0
//Tier: Silver IV
namespace Joy
{
    class Q11047
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int N = int.Parse(input[0]);
            int K = int.Parse(input[1]);
            int[] arr = new int[N];
            for (int i = 0; i < N; i++)
            {
                arr[i] = int.Parse(Console.ReadLine());
            }
            int count = 0;
            for (int i = N - 1; i >= 0; i--)
            {
                int coin = arr[i];
                while (K >= coin)
                {
                    count++;
                    K -= coin;
                }
            }
            Console.WriteLine(count);
        }
    }

}
