//Question No: 1012
//Title: 유기농 배추
//Tier: Silver II
namespace Joy
{
    class Q1012
    {
        static int[,] field;
        static bool[,] visited;
        static int[] dx = { -1, 1, 0, 0 };
        static int[] dy = { 0, 0, -1, 1 };
        static int M, N;

        static void Main()
        {
            int T = int.Parse(Console.ReadLine());

            for (int i = 0; i < T; i++)
            {
                int[] input = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                M = input[0];
                N = input[1];
                int K = input[2];

                field = new int[M, N];
                visited = new bool[M, N];

                for (int j = 0; j < K; j++)
                {
                    int[] cabbage = Array.ConvertAll(Console.ReadLine().Split(), int.Parse);
                    field[cabbage[0], cabbage[1]] = 1;
                }

                int result = 0;

                for (int x = 0; x < M; x++)
                {
                    for (int y = 0; y < N; y++)
                    {
                        if (field[x, y] == 1 && !visited[x, y])
                        {
                            Search(x, y);
                            result++;
                        }
                    }
                }

                Console.WriteLine(result);
            }
        }

        static void Search(int x, int y)
        {
            visited[x, y] = true;

            for (int i = 0; i < 4; i++)
            {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && field[nx, ny] == 1 && !visited[nx, ny])
                {
                    Search(nx, ny);
                }
            }
        }
    }
}

