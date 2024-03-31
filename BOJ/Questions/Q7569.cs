//Question No: 7569
//Title: 토마토
//Tier: Gold V
namespace Joy
{
    class Q7569
    {
        static int M, N, H;
        static int[,,] tomatoes;
        static int[,] delta = { { 1, 0, 0 }, { -1, 0, 0 }, { 0, 1, 0 }, { 0, -1, 0 }, { 0, 0, 1 }, { 0, 0, -1 } };

        static void Main(string[] args)
        {
            string[] input = Console.ReadLine().Split();
            M = int.Parse(input[0]);
            N = int.Parse(input[1]);
            H = int.Parse(input[2]);

            tomatoes = new int[M, N, H];

            for (int k = 0; k < H; k++)
            {
                for (int i = 0; i < N; i++)
                {
                    string[] row = Console.ReadLine().Split();
                    for (int j = 0; j < M; j++)
                    {
                        tomatoes[j, i, k] = int.Parse(row[j]);
                    }
                }
            }

            Console.WriteLine(BFS());
        }

        static int BFS()
        {
            Queue<(int, int, int)> queue = new Queue<(int, int, int)>();
            
            // Enqueue all ripe tomatoes
            for (int k = 0; k < H; k++)
            {
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < M; j++)
                    {
                        if (tomatoes[j, i, k] == 1)
                        {
                            queue.Enqueue((j, i, k));
                        }
                    }
                }
            }

            int days = -1;

            while (queue.Count > 0)
            {
                int size = queue.Count;
                days++;

                for (int s = 0; s < size; s++)
                {
                    (int x, int y, int z) = queue.Dequeue();

                    for (int d = 0; d < 6; d++)
                    {
                        int nx = x + delta[d, 0];
                        int ny = y + delta[d, 1];
                        int nz = z + delta[d, 2];

                        if (nx >= 0 && nx < M && ny >= 0 && ny < N && nz >= 0 && nz < H && tomatoes[nx, ny, nz] == 0)
                        {
                            tomatoes[nx, ny, nz] = 1;
                            queue.Enqueue((nx, ny, nz));
                        }
                    }
                }
            }

            // Check if there are any unripe tomatoes left
            for (int k = 0; k < H; k++)
            {
                for (int i = 0; i < N; i++)
                {
                    for (int j = 0; j < M; j++)
                    {
                        if (tomatoes[j, i, k] == 0)
                        {
                            return -1;
                        }
                    }
                }
            }

            return days;
        }

        
    }

}
