//Question No: 1865
//Title: 웜홀
//Tier: Gold III
namespace Joy
{
    class Q1865
    {
        static List<(int, int)>[] adj;
        static int INF = 1000000007;

        static void CheckTimeShift(int N, int src)
        {
            int[] upper = new int[N + 1];
            for (int i = 1; i <= N; i++)
            {
                upper[i] = INF;
            }

            bool updated = false;
            upper[src] = 0;

            for (int iter = 0; iter < N; iter++)
            {
                updated = false;

                for (int here = 1; here <= N; here++)
                {
                    foreach ((int there, int cost) in adj[here])
                    {
                        if (upper[there] > upper[here] + cost)
                        {
                            upper[there] = upper[here] + cost;
                            updated = true;
                        }
                    }
                }

                if (!updated)
                {
                    Console.WriteLine("NO");
                    return;
                }
            }

            if (updated)
            {
                Console.WriteLine("YES");
            }
        }

        static void Main()
        {
            int TC = int.Parse(Console.ReadLine());

            for (int k = 0; k < TC; k++)
            {
                int[] values = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                int N = values[0];
                int M = values[1];
                int W = values[2];

                adj = new List<(int, int)>[N + 1];
                for (int i = 1; i <= N; i++)
                {
                    adj[i] = new List<(int, int)>();
                }

                for (int i = 0; i < M; i++)
                {
                    values = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                    int start = values[0];
                    int end = values[1];
                    int time = values[2];
                    adj[start].Add((end, time));
                    adj[end].Add((start, time));
                }

                for (int i = 0; i < W; i++)
                {
                    values = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                    int start = values[0];
                    int end = values[1];
                    int time = values[2];
                    adj[start].Add((end, -time));
                }

                CheckTimeShift(N, 1);
            }
        }
    }

}