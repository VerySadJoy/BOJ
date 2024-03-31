//Question No: 9461
//Title: 파도반 수열
//Tier: Silver III
namespace Joy
{
    class Q9461
    {
        static void Main()
        {
            int T = int.Parse(Console.ReadLine());
            long[] arr = new long[101];
            arr[1] = arr[2] = arr[3] = 1;
            for (int i = 4; i <= 100; i++)
            {
                arr[i] = arr[i - 2] + arr[i - 3];
            }
            for (int t = 0; t < T; t++)
            {
                int N = int.Parse(Console.ReadLine());
                Console.WriteLine(arr[N]);
            }
        }
    }

}
