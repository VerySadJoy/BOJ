//Question No: 1000
//Title: A+B
//Tier: Bronze V
namespace Joy
{
    class Q14502
    {
        static int[,] lab;
        static int N, M;
        static int maxSafeCells;
        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);
            lab = new int[N, M];
            for (int i = 0; i < N; i++)
            {
                input = Console.ReadLine().Split();
                for (int j = 0; j < M; j++)
                {
                    lab[i, j] = int.Parse(input[j]);
                }
            }
            maxSafeCells = 0;
            ExploreWalls(0, 0);
            Console.WriteLine(maxSafeCells);
        }
        static void ExploreWalls(int wallsPlaced, int startIndex)
        {
            if (wallsPlaced == 3)
            {
                int safeCells = SimulateVirusSpread();
                maxSafeCells = Math.Max(maxSafeCells, safeCells);
                return;
            }
            for (int i = startIndex; i < N * M; i++)
            {
                int row = i / M;
                int col = i % M;
                if (lab[row, col] == 0)
                {
                    lab[row, col] = 1;
                    ExploreWalls(wallsPlaced + 1, i + 1);
                    lab[row, col] = 0;
                }
            }
        }
        static int SimulateVirusSpread()
        {
            Queue<(int, int)> queue = new Queue<(int, int)>();
            bool[,] visited = new bool[N, M];
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    if (lab[i, j] == 2)
                    {
                        queue.Enqueue((i, j));
                        visited[i, j] = true;
                    }
                }
            }
            int[] dx = { -1, 1, 0, 0 };
            int[] dy = { 0, 0, -1, 1 };
            int safeCells = 0;
            while (queue.Count > 0)
            {
                (int x, int y) = queue.Dequeue();
                safeCells++;
                for (int k = 0; k < 4; k++)
                {
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if (nx >= 0 && nx < N && ny >= 0 && ny < M && !visited[nx, ny] && lab[nx, ny] == 0)
                    {
                        queue.Enqueue((nx, ny));
                        visited[nx, ny] = true;
                    }
                }
            }
            return N * M - safeCells;
        }
    }
}