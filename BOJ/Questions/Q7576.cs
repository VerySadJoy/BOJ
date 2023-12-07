//Question No: 7576
//Title: 토마토
//Tier: Gold V
namespace Joy
{
    class Q7576
    {
        

        static void Main()
        {
            int m, n;
            int[,] box;
            int[] dx = {-1, 1, 0, 0};
            int[] dy = {0, 0, -1, 1};
            string[] input = Console.ReadLine().Split();
            m = int.Parse(input[0]);
            n = int.Parse(input[1]);

            box = new int[n, m];

            for (int i = 0; i < n; i++)
            {
                input = Console.ReadLine().Split();
                for (int j = 0; j < m; j++)
                {
                    box[i, j] = int.Parse(input[j]);
                }
            }

            Queue<(int, int)> queue = new Queue<(int, int)>();

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (box[i, j] == 1)
                    {
                        queue.Enqueue((i, j));
                    }
                }
            }

            while (queue.Count > 0)
            {
                var (x, y) = queue.Dequeue();

                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx, ny] == 0)
                    {
                        box[nx, ny] = box[x, y] + 1;
                        queue.Enqueue((nx, ny));
                    }
                }
            }

            int maxDays = 0;

            for (int i = 0; i < n; i++)
            {
                for (int j = 0; j < m; j++)
                {
                    if (box[i, j] == 0)
                    {
                        Console.WriteLine(-1);
                        return;
                    }

                    maxDays = Math.Max(maxDays, box[i, j]);
                }
            }
            Console.WriteLine(maxDays - 1);
        }
    }
}
