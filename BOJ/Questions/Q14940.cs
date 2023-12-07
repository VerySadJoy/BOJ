//Question No: 14940
//Title: 쉬운 최단거리
//Tier: Silver I
namespace Joy
{
    class Q14940
    {
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            int n = int.Parse(input[0]);
            int m = int.Parse(input[1]);
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

            int[][] graph = new int[n][];
            int[,] distances = new int[n, m];

            int startX = 0;
            int startY = 0;

            for (int i = 0; i < n; i++)
            {
                graph[i] = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                for (int j = 0; j < m; j++)
                {
                    if (graph[i][j] == 2)
                    {
                        startX = i;
                        startY = j;
                    }
                    else if (graph[i][j] == 0)
                    {
                        distances[i, j] = -1;
                    }
                }
            }

            Queue<(int, int)> queue = new Queue<(int, int)>();
            queue.Enqueue((startX, startY));
            distances[startX, startY] = 0;

            while (queue.Count > 0)
            {
                var (x, y) = queue.Dequeue();

                for (int k = 0; k < 4; k++)
                {
                    int nx = x + dx[k];
                    int ny = y + dy[k];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && distances[nx, ny] == -1)
                    {
                        distances[nx, ny] = distances[x, y] + 1;
                        queue.Enqueue((nx, ny));
                    }
                }
            }

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    Console.Write(distances[i, j] + " ");
                }
                Console.WriteLine();
            }
        }
    }
}
