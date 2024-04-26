//Question No: 11660
//Title: 구간 합 구하기 5
//Tier: Silver I
namespace Joy
{
    class Q11660
    {
        static void Main()
        {
            string[] NM = Console.ReadLine().Split();
            int N = int.Parse(NM[0]);
            int M = int.Parse(NM[1]);
            int[,] arr = new int[N + 1, N + 1];
            int[,] cumSum = new int[N + 1, N + 1];
            for (int i = 1; i <= N; i++)
            {
                string[] row = Console.ReadLine().Split();
                for (int j = 1; j <= N; j++)
                {
                    arr[i, j] = int.Parse(row[j - 1]);
                    cumSum[i, j] = cumSum[i, j - 1] + arr[i, j];
                }
            }
            for (int i = 1; i <= N; i++)
            {
                for (int j = 1; j <= N; j++)
                {
                    cumSum[i, j] += cumSum[i - 1, j];
                }
            }
            for (int k = 0; k < M; k++)
            {
                string[] query = Console.ReadLine().Split();
                int x1 = int.Parse(query[0]);
                int y1 = int.Parse(query[1]);
                int x2 = int.Parse(query[2]);
                int y2 = int.Parse(query[3]);

                int result = cumSum[x2, y2] - cumSum[x1 - 1, y2] - cumSum[x2, y1 - 1] + cumSum[x1 - 1, y1 - 1];
                Console.WriteLine(result);
            }
        }
    }
}
