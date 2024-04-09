//Question No: 14500
//Title: 테트로미노
//Tier: Gold IV
namespace Joy
{
    class Q14500
    {
        struct Coord
        {
            public int y, x;
        }

        static Coord[] dir = { new Coord { y = 0, x = 1 }, new Coord { y = 1, x = 0 }, new Coord { y = 0, x = -1 }, new Coord { y = -1, x = 0 } };

        static int[,] lst;
        static bool[,] visited;
        static int N, M;
        static int maxNum = 0;

        static void Main()
        {
            string[] input = Console.ReadLine().Split();
            N = int.Parse(input[0]);
            M = int.Parse(input[1]);

            lst = new int[N, M];
            visited = new bool[N, M];

            for (int i = 0; i < N; i++)
            {
                string[] row = Console.ReadLine().Split();
                for (int j = 0; j < M; j++)
                {
                    lst[i, j] = int.Parse(row[j]);
                }
            }

            Middle();

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    visited[i, j] = true;
                    DFS(i, j, 0, lst[i, j]);
                    visited[i, j] = false;
                }
            }

            Console.WriteLine(maxNum);
        }

        static void DFS(int y, int x, int n, int sum)
        {
            if (y >= N || x >= M || y < 0 || x < 0)
                return;
            if (n == 3)
            {
                maxNum = Math.Max(maxNum, sum);
                return;
            }

            foreach (var d in dir)
            {
                int ny = y + d.y;
                int nx = x + d.x;

                if (ny >= 0 && ny < N && nx >= 0 && nx < M && !visited[ny, nx])
                {
                    visited[ny, nx] = true;
                    DFS(ny, nx, n + 1, sum + lst[ny, nx]);
                    visited[ny, nx] = false;
                }
            }
        }

        static void Middle()
        {
            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < M; j++)
                {
                    if (j - 1 >= 0 && j + 1 < M && i - 1 >= 0)
                    {
                        int sum = lst[i, j - 1] + lst[i, j] + lst[i, j + 1] + lst[i - 1, j];
                        maxNum = Math.Max(maxNum, sum);
                    }

                    if (j - 1 >= 0 && i + 1 < N && i - 1 >= 0)
                    {
                        int sum = lst[i, j] + lst[i, j - 1] + lst[i + 1, j] + lst[i - 1, j];
                        maxNum = Math.Max(maxNum, sum);
                    }

                    if (j - 1 >= 0 && i + 1 < N && j + 1 < M)
                    {
                        int sum = lst[i, j] + lst[i + 1, j] + lst[i, j - 1] + lst[i, j + 1];
                        maxNum = Math.Max(maxNum, sum);
                    }

                    if (i - 1 >= 0 && i + 1 < N && j + 1 < M)
                    {
                        int sum = lst[i, j] + lst[i + 1, j] + lst[i, j + 1] + lst[i - 1, j];
                        maxNum = Math.Max(maxNum, sum);
                    }
                }
            }
        }
    }

}