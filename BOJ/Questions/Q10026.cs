//Question No: 10026
//Title: 적록색약
//Tier: Gold V
namespace Joy
{
    class Q10026
    {
        static int[] dx = { -1, 1, 0, 0 };
        static int[] dy = { 0, 0, -1, 1 };

        static void Main()
        {
            int N = int.Parse(Console.ReadLine());

            char[,] grid = new char[N, N];
            for (int i = 0; i < N; i++)
            {
                string row = Console.ReadLine();
                for (int j = 0; j < N; j++)
                {
                    grid[i, j] = row[j];
                }
            }

            bool[,] visitedNormal = new bool[N, N];
            int regionsNormal = CountRegions(grid, visitedNormal);
            bool[,] visitedColorBlind = new bool[N, N];
            int regionsColorBlind = CountRegions(grid, visitedColorBlind, true);

            Console.WriteLine(regionsNormal + " " + regionsColorBlind);
        }

        static int CountRegions(char[,] grid, bool[,] visited, bool isColorBlind = false)
        {
            int N = grid.GetLength(0);
            int regions = 0;

            for (int i = 0; i < N; i++)
            {
                for (int j = 0; j < N; j++)
                {
                    if (!visited[i, j])
                    {
                        regions++;
                        DFS(grid, visited, i, j, isColorBlind);
                    }
                }
            }
            return regions;
        }

        static void DFS(char[,] grid, bool[,] visited, int x, int y, bool isColorBlind)
        {
            visited[x, y] = true;

            for (int d = 0; d < 4; d++)
            {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx >= 0 && nx < grid.GetLength(0) && ny >= 0 && ny < grid.GetLength(1)
                    && !visited[nx, ny] && (grid[nx, ny] == grid[x, y] || (isColorBlind && (grid[x, y] == 'R' || grid[x, y] == 'G') && (grid[nx, ny] == 'R' || grid[nx, ny] == 'G'))))
                {
                    DFS(grid, visited, nx, ny, isColorBlind);
                }
            }
        }
    }

}
