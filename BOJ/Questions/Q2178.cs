//Question No: 2178
//Title: 미로 탐색
//Tier: Silver I
namespace Joy
{
    class Q2178
    {
        static void Main()
        {
            int[,] maze;
            bool[,] visited;
            int N, M;

            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);

            maze = new int[N, M];
            visited = new bool[N, M];

            for (int i = 0; i < N; i++)
            {
                string row = Console.ReadLine();
                for (int j = 0; j < M; j++)
                {
                    maze[i, j] = int.Parse(row[j].ToString());
                }
            }

            Queue<(int, int)> queue = new Queue<(int, int)>();
            queue.Enqueue((0, 0));
            visited[0, 0] = true;

            while (queue.Count > 0)
            {
                var (x, y) = queue.Dequeue();

                for (int i = 0; i < 4; i++)
                {
                    int nx = x + dx[i];
                    int ny = y + dy[i];

                    if (nx >= 0 && nx < N && ny >= 0 && ny < M)
                    {
                        if (maze[nx, ny] == 1 && !visited[nx, ny])
                        {
                            queue.Enqueue((nx, ny));
                            visited[nx, ny] = true;
                            maze[nx, ny] = maze[x, y] + 1;
                        }
                    }
                }
            }

            Console.WriteLine(maze[N - 1, M - 1]);
        }
    }

}