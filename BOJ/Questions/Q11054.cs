//Question No: 11054
//Title: 가장 긴 바이토닉 부분 수열
//Tier: Gold IV
namespace Joy
{
    class Q11054
    {
        static void Main()
        {
            int N = int.Parse(Console.ReadLine());
            int[] arr = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);

            int[] increasing = new int[N];
            int[] decreasing = new int[N];
            for (int i = 0; i < N; i++)
            {
                increasing[i] = 1;
                decreasing[i] = 1;
            }
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (arr[j] < arr[i])
                    {
                        increasing[i] = Math.Max(increasing[i], increasing[j] + 1);
                    }
                }
            }
            for (int i = N - 1; i >= 0; i--)
            {
                for (int j = N - 1; j > i; j--)
                {
                    if (arr[j] < arr[i])
                    {
                        decreasing[i] = Math.Max(decreasing[i], decreasing[j] + 1);
                    }
                }
            }
            int maxLBS = 0;
            for (int i = 0; i < N; i++)
            {
                maxLBS = Math.Max(maxLBS, increasing[i] + decreasing[i] - 1);
            }
            Console.WriteLine(maxLBS);
        }
    }
}
